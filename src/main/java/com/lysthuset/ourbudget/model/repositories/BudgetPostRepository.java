package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.BudgetPost;
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
        //TODO: Make actual implementation, with SQL calls etc.
        List<BudgetPost> budgetPostsForMonth = new ArrayList<BudgetPost>();

        //Joiner payments og paymentlabels på deres FK og ID Finder en bestemt brugers payments (ikke måned specifik)

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM budgetposts INNER JOIN bpostlabels ON FK_bpostlabel_ID=BPostLabel_ID WHERE FK_month_ID=" + monthID);
        while (sqlRowSet.next()) {

            budgetPostsForMonth.add(
                    new BudgetPost()
            );

        }
        return (ArrayList<BudgetPost>) budgetPostsForMonth;

        return new ArrayList<BudgetPost>();
    }

    private ArrayList<User> usersForBudgetPost(int budgetPostID){
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM _budgetpost_users INNER JOIN bpostlabels ON FK_bpostlabel_ID=BPostLabel_ID WHERE FK_month_ID=" + monthID);)
    }
}
