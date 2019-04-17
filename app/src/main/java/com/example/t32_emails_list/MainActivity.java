package com.example.t32_emails_list;

//Android Recyclerview tutorial
//If your app needs to display a scrolling list of elements based on large data sets
// (or data that frequently changes), you should use RecyclerView as described on this page.


//In this tutorial we will learn how to use Android Recyclerview to display a list of emails.
// The app will have 2 pages, the first (main) page will show you the list of emails and each
// email will have the following data:  Sender, Icon, Title, Title Description, Favorite Button, Time
//When you tap on a specific row (Email), you will be directed to the second page which shows you
// the full email in details.

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<EmailData> mEmailData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Android Toolbar and set the app name to appear inside.
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("MyMail");

        // Initialize Android Recyclerview.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Initialize Android LinearLayoutManager, this layout manager is used together with
        // Android Recyclerview to determine whether you want to allow the user to scroll
        // in a vertical or horizontal orientation.
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);

        // Initialize Android DividerItemDecoration, this item decoration is used to draw
        // a line under each item in Recyclerview.
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        //Set the data to Android Recyclerview adapter.
        MailAdapter mMailAdapter = new MailAdapter(MainActivity.this,   mEmailData);
        mRecyclerView.setAdapter(mMailAdapter);

        // Initialize the actual data that will show up in Recyclerview.
        EmailData mEmail = new EmailData("Sam", "Weekend adventure",
                "Let's go fishing with John and others. We will do some barbecue and have soo much fun",
                "10:42am");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Facebook", "James, you have 1 new notification",
                "A lot has happened on Facebook since",
                "16:04pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Google+", "Top suggested Google+ pages for you",
                "Top suggested Google+ pages for you",
                "18:44pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Twitter", "Follow T-Mobile, Samsung Mobile U",
                "James, some people you may know",
                "20:04pm");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Pinterest Weekly", "Pins you’ll love!",
                "Have you seen these Pins yet? Pinterest",
                "09:04am");
        mEmailData.add(mEmail);
        mEmail = new EmailData("Josh", "Going lunch",
                "Don't forget our lunch at 3PM in Pizza hut",
                "01:04am");
        mEmailData.add(mEmail);

        mEmail = new EmailData("Dan", "Big Sale",
                "Big summer sale",
                "01:05am");
        mEmailData.add(mEmail);

        mEmail = new EmailData("Mango", "Mango Sale",
                "Big summer sale on Mango",
                "01:06am");
        mEmailData.add(mEmail);

        mEmail = new EmailData("ZARA", "ZARA Sale",
                "Big summer sale on ZARA",
                "01:07am");
        mEmailData.add(mEmail);



    }
}
