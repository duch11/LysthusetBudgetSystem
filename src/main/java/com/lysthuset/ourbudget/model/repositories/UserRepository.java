package com.lysthuset.ourbudget.model.repositories;

import com.lysthuset.ourbudget.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    JdbcTemplate jdbc;


    @Override
    public void create(User user) {
        jdbc.update("INSERT user(name, pass, active, admin) VALUES('" + user.getName() + "','" + user.getPass() + "'," + user.isActive() + "," + user.isAdmin() + ")");
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();
        SqlRowSet sqlRowSet;
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user");

        while(sqlRowSet.next()){

            users.add(new User(sqlRowSet.getInt("user_ID"), sqlRowSet.getString("name"),sqlRowSet.getString("pass"), sqlRowSet.getBoolean("active"), sqlRowSet.getBoolean("admin")));


            //NOTE TO SELF!!
            //Autowire kan være et problem ved NULL pointer
            //DON'T COPY PASTE CODE! LOL Ellers tjek det ordentligt din boev.
            // TEST i Konsollen
            /*int id = sqlRowSet.getInt("user_ID");
            String name =  sqlRowSet.getString("name");
            String pass =  sqlRowSet.getString("pass");
            System.out.println(id + " " + name + " " + pass);*/
        }
        System.out.println("User Repo readAll called!");
        return users;
    }

    @Override
    public User read(int id) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE user_ID =" + id);
        if(sqlRowSet.next()){
            return new User(sqlRowSet.getInt("user_ID"), sqlRowSet.getString("name"), sqlRowSet.getString("pass"), sqlRowSet.getBoolean("active"), sqlRowSet.getBoolean("admin"));
        }
        return new User(-1, "found no user", "found no user", false, false);
    }

    @Override
    public void update(User user) {
        // strings i SQL skal omringes af 'string' quotes derfor '" + booo.getBoo() + "'
        jdbc.update("UPDATE user SET name ='" + user.getName() + "', pass = '" + user.getPass() + "', active = " + user.isActive() + " WHERE user_id =" + user.getUserID());
    }

    @Override
    public void delete(int id) {
        jdbc.update("DELETE FROM user WHERE user_ID = " + id);
    }

}
