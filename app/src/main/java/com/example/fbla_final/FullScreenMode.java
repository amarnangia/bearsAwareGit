package com.example.fbla_final;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
public class FullScreenMode extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_full_screen_mode); // sets the screen to the XML file associated with this
        imageView = (ImageView) findViewById(R.id.image_view);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Full Screen Image"); //makes the image pop out in full screen
        Intent i = getIntent();
        int position = i.getExtras().getInt("id"); //id is packaged into the intent whenever this activity is called, so we need to get that to know what photo we need to open
        ImageAdapter imageAdapter = new ImageAdapter(this);

        imageView.setImageResource(imageAdapter.imageArray[position]);
    }
}