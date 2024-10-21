package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;

public class studetnPortal extends login {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_studetn_portal);
        Intent i = getIntent();
        first = i.getStringExtra("FIRST");
        last = i.getStringExtra("LAST");
        name = first + " " + last;
        System.out.println(name);
        if(name.length() > 6)//we dont want the text to overlap, so if it is too long, we will only use part of the name
        {
            ((TextView)findViewById(R.id.welcomeText)).setText("Welcome " + first);
        }
        else{
            ((TextView)findViewById(R.id.welcomeText)).setText("Welcome " + name);

        }
        id = i.getStringExtra("IDNum");
        password = i.getStringExtra("Password");

    }
    String first;
    String last;
    String name;
    String id;
    String password;

    public void openCalandar(View v) { //opens calandar activity
        Intent i = new Intent(this, Calandar.class);
        startActivity(i);
    }
    public void openMap(View v) { //opens map activity
        Intent i = new Intent(this, Map.class);
        startActivity(i);
    }

    public void openProfile(View v) {//opens profile activity

        AccessToken accessToken = AccessToken.getCurrentAccessToken(); //put this code at beggining of app after create sign out option only
        if(accessToken!= null && accessToken.isExpired() == false)//if they arent logged into facebook
        {
            Intent i = new Intent(this, Profile.class);
            i.putExtra("NAME", name);
            i.putExtra("ID", id);
            i.putExtra("type", "students/teachers");
            startActivity(i);
            finish();
        }
        else{//if they are logged into facebook, we want to open up their profile
            Intent i = new Intent(this, Profile.class);
            i.putExtra("NAME", name);
            i.putExtra("ID", id);
            i.putExtra("type", "students/teachers");
            startActivity(i);
        }


    }
    public void openImages(View v) {//opens openImage activity
        Intent i = new Intent(this, scrollingPhotos.class);
        startActivity(i);
    }


    public void openFeedback(View v)//opens opens a doc with copyright and a feedback form activity
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1u-wumDBcXXHB5r4oGN3L11P0-aBAzjnPfrxtrrqkszs/edit?usp=sharing"));
        startActivity(i);
    }

    public void Contacts(View v)//opens faculty web page with links to all school employee's contact
    {
        Intent i = new Intent(this, contact.class);
        i.putExtra("NAME", name);
        startActivity(i);
    }
    public void SharePhoto(View v)//opens faculty web page with links to all school employee's contact
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScDK1U109TlobG_3qSCw7L78o7VrJotKkK50DyvsxZYa0S90g/viewform?usp=sf_link"));
        startActivity(i);
    }

}