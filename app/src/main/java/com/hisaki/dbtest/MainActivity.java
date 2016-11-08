package com.hisaki.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hisaki.dbtest.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserDbHandler db = new UserDbHandler(this);

        System.out.println("Inserting ..");
        db.addUser(new User("Anatolii", "Psozniak"));

        System.out.println("Reading all contacts..");
        List<User> users = db.getAllUsers();
        for (User user : users) {
            String log = "Id: "+user.getId()+" ,Name: " + user.getName() + " ,Phone: " + user.getSurname();
            Log.d("db_data",log);
        }

        db.deleteAll();
    }
}
