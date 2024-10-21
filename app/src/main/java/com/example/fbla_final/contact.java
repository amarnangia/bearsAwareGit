package com.example.fbla_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_contact);
        Intent i = getIntent();
        name = i.getStringExtra("NAME");

    }
    String name;
    public void callSchool(View V){
        String phoneNumber = "tel:" + "832-349-7644";
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
        startActivity(dialIntent);

    }

    public void contactAttendence(View v)
    {
        String message = "Dear Bridgeland Attendence Office,  \n\n My name is " + name + " and I am contacting you for my <grade>th grader, <child name> \n\n I am emailing in regards to <state inquiry>";
        Spinner nameSpinner = findViewById(R.id.name_spinner2);
        String selectedName = nameSpinner.getSelectedItem().toString();
        String selectedEmail = getEmailForName(selectedName);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {selectedEmail});
        intent.putExtra(Intent.EXTRA_TEXT, message); // Set email message
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendingEmail(View v)
    {
        Spinner nameSpinner = findViewById(R.id.name_spinner);
        String selectedName = nameSpinner.getSelectedItem().toString();
        String selectedEmail = getEmailForName(selectedName);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {selectedEmail});
                intent.setPackage("com.google.android.gm"); // Use Gmail app explicitly
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return null;
            }
        }.execute();


        /*


        Spinner nameSpinner = findViewById(R.id.name_spinner);
        String selectedName = nameSpinner.getSelectedItem().toString();
        String selectedEmail = getEmailForName(selectedName);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {selectedEmail});
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

         */

    }

    public String getEmailForName(String name){
        String returning = "";
        if(name.indexOf(",") == -1){

            if(name.contains("A-G"))
            {
                returning =  "Jamie.burks@cfisd.net";
            }
            if(name.contains("H-P")){
                returning = "Brenya.smith@cfisd.net";
            }
            if(name.contains("Q-Z")){
                returning =  "Amber.fielding@cfisd.net";
            }
            ((EditText)findViewById(R.id.lastName2)).setText(returning);
            return returning;





        }

        returning = (name.substring(name.indexOf(",")+1) + "." + name.substring(0, name.indexOf(",")) + "@cfisd.net").replaceAll("\\s+", "");
        ((EditText)findViewById(R.id.lastName2)).setText(returning);
        return returning;

    }


}