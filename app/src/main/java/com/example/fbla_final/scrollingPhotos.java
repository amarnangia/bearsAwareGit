package com.example.fbla_final;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
public class scrollingPhotos extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //starting app up
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_scrolling_photos);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new

                                                AdapterView.OnItemClickListener() {
                                                //this sets up the items to enter full screen mode

                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View

                                                            view, int position, long id) {
                                                        Intent intent = new

                                                                Intent(getApplicationContext(),FullScreenMode.class);
                                                        intent.putExtra("id",position);
                                                        startActivity(intent);
                                                    }
                                                });
    }

    public void SharePhoto(View v)//opens faculty web page with links to all school employee's contact
    {
        //opens up the application to share photos
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLScDK1U109TlobG_3qSCw7L78o7VrJotKkK50DyvsxZYa0S90g/viewform?usp=sf_link"));
        startActivity(i);
    }
}