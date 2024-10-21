package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    this is the welcome page. It will ask the user to select either parent/guest or teacher/student. It will then take them to the login page
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String j = "words";
        ((Button)findViewById(R.id.button)).setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
    }
    public void goLogin(View v)
            /*
            once the user choses one of the two option, this will send them to the login page. It packages the login type for us to reference in the next file
             */
    {

        String name = ((Button)v).getText().toString();
        Intent i = new Intent(this, login.class );


        i.putExtra("TYPE", name);
        startActivity(i);
    }
}