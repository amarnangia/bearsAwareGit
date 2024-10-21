package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

public class login extends AppCompatActivity {
    /*
    this part takes the following intents
    login type: tells us if this will lead to the parent portal or student portal

    If the user logs in by filling in the form's editTexts and presses the login button, they will go to their respective portal
    it will also package the name, id, and password of the user to be extracted later

    if the user signs into facebook, they go to the profile immediately and can return to student portal


     */
    CallbackManager callbackManager;
    ImageView fbBtn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent i = getIntent();
        // this is the packaged item from teh intent
        loginType = i.getStringExtra("TYPE"); //so that we know if we need to go to parent portal or student portal
        ((TextView)findViewById(R.id.welcomeText)).setText(loginType + " Login");

        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {//successful log in will open up profile
                        System.out.println("This works_");
                        Intent i = new Intent(login.this, Profile.class);
                        i.putExtra("type", loginType);
                        startActivity(i);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        fbBtn = findViewById(R.id.fb_btn);
        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {// handleling facebook sdk
                LoginManager.getInstance().logInWithReadPermissions(login.this, Arrays.asList("public_profile"));
                System.out.println("its happening");
            }
        });



    }
    //making the variables "global"
    String loginType;
    private String First;
    private String Last;
    private String IDNum;
    private String Password;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //this is the part where we get data from Facebook
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void calling(View v)
    {
        /*
        runs when the login button is run

        this takes in the data from the EditViews that the user filled out
        it packages into an intent and opens up an intent of the correct portal
         */
        //gathers the information that the user types
        First = ((EditText)findViewById(R.id.firstName)).getText().toString();
        Last = ((EditText)findViewById(R.id.lastName)).getText().toString();
        IDNum = ((EditText)findViewById(R.id.IDNumber)).getText().toString();
        Password = ((EditText)findViewById(R.id.Password)).getText().toString();
        loginType = ((TextView)findViewById(R.id.welcomeText)).getText().toString();
        loginType = loginType.substring(0,loginType.length() - 6);
        System.out.println(loginType);

        //choses which portal we are opening depending on what the user selected in teh main activity
        Intent j  = new Intent(this, studetnPortal.class);
        if(loginType.equals("Parents"))
        {
            System.out.println("Your");
           j  = new Intent(this, parentPortal.class); //in the case that we need to go to parent portal
        }


        //packaging information
        j.putExtra("FIRST", First);
        j.putExtra("LAST", Last);
        j.putExtra("IDNum", IDNum);
        j.putExtra("Password", Password);
        startActivity(j);
    }

    public String getName()
    {
        System.out.println(First + "name");
        return First + " " + Last;
    }


}