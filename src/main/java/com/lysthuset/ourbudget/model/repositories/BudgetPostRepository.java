package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.BudgetCategory;
import com.lysthuset.ourbudget.model.entities.BudgetPost;
import com.lysthuset.ourbudget.model.entities.PayLabel;
import com.lysthuset.ourbudget.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BudgetPostRepository implements IBudgetPostRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public ArrayList<BudgetPost> readAll() {
        return null;
    }

    @Override
    public ArrayList<BudgetPost> readBudgetPostsForMonth(int monthID) {
        List<BudgetPost> budgetPostsForMonth = new ArrayList<BudgetPost>();

        //Collect budgetposts for matching monthID
        SqlRowSet sqlRowSetBP = jdbc.queryForRowSet(
                "SELECT * FROM budgetposts"
                        +" INNER JOIN bpostlabels ON FK_bpostlabel_ID=BPostLabel_ID"
                        +" WHERE FK_month_ID=" + monthID);

        //construct the budgetposts
        while (sqlRowSetBP.next()) {

            //Get users from DB for current budgetpost
            SqlRowSet sqlRowSetUsers = jdbc.queryForRowSet(
                    "SELECT * FROM _budgetpost_users"
                            +" INNER JOIN user on FK_user_ID = user_ID"
                            +" WHERE FK_budgetpost_ID =" + sqlRowSetBP.getInt("BudgetPost_ID"));

            //Generate and add users to arraylist
            List<User> userList = new ArrayList<>();
            while (sqlRowSetUsers.next()){

                User user = new User();

                user.setUserID(sqlRowSetUsers.getInt("user_ID"));
                user.setName(sqlRowSetUsers.getString("name"));

                userList.add(user);
            }

            //Get BudgetpostLabel and its children
            int BPostLabel_ID = sqlRowSetBP.getInt("BPostLabel_ID");

            //Get it's payment category children from DB
            SqlRowSet pCategoryRows = jdbc.queryForRowSet("SELECT PaymentLabel_ID, label FROM paymentlabels where FK_BPostLabel_ID =" + BPostLabel_ID);
            ArrayList<PayLabel> payCategories = new ArrayList<>();

            //collect payment category children in array list
            while(pCategoryRows.next()){

                int payCatID = pCategoryRows.getInt("PaymentLabel_ID");
                String pCatLabel = pCategoryRows.getString("label");

                payCategories.add(
                        new PayLabel(payCatID, pCatLabel)
                );
            }

            //collect the category along with it's children
            BudgetCategory category = new BudgetCategory(BPostLabel_ID,sqlRowSetBP.getString("label"), payCategories);

            //add the budgetpost containing its users and its BudgetPostlabel+Payment Categories children, to the list
            budgetPostsForMonth.add(

                    new BudgetPost(
                            sqlRowSetBP.getInt("BudgetPost_ID"),
                            category,
                            sqlRowSetBP.getBigDecimal("amount"),
                            (ArrayList<User>) userList
                    )
            );

        }

        return (ArrayList<BudgetPost>) budgetPostsForMonth;
    }
}
