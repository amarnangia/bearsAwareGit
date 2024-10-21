package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class parentPortal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //sets up screen and unpackages infomation
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        setContentView(R.layout.activity_parent_portal);
        first = i.getStringExtra("FIRST");
        last = i.getStringExtra("LAST");
        name = first + " " + last;
    }
    //global variables
    String first;
    String last;
    String name;
    //the following methods open up new activities or websites

    public void openCalandar(View v) {
        //opens calendar
        Intent i = new Intent(this, Calandar.class);
        startActivity(i);
    }

    public void openProfile(View v) {
        //packs information and opens profile
        Intent i = new Intent(this, Profile.class);
        i.putExtra("type", "Parents");
        i.putExtra("NAME", name);
        i.putExtra("ID", "---");
        startActivity(i);
    }
    public void openImages(View v) {
        //opens the image gallary
        Intent i = new Intent(this, scrollingPhotos.class);
        startActivity(i);
    }

    public void openFeedback(View v)
    {

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/document/d/1u-wumDBcXXHB5r4oGN3L11P0-aBAzjnPfrxtrrqkszs/edit?usp=sharing"));
        startActivity(i);
    }

    public void Contacts(View v)
    {
        Intent i = new Intent(this, contact.class);
        i.putExtra("NAME", name);
        startActivity(i);
        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app02.cfisd.net/urlcap/campus_list_016.html"));
        //startActivity(i);
    }
    public void Attendence(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/118_LDnGmybX6RCtjpo-85cL68nBWWw6a/view?usp=sharing"));
        startActivity(i);
    }

    //
}