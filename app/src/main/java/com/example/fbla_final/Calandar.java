package com.example.fbla_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.widget.CalendarView;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.Calendar;

public class Calandar extends AppCompatActivity {
    /*
    This is opened from the student portal
    Events are coded into the calander

    Each day has its events. To add events, add an else if statement for that date,
    and if that date is selected, set the Text View, firstDate,
    to the event for that day
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Events
        String eventOne = "Student/Staff Holiday";
        String eventTwo = "Teacher Work Day";
        String eventThree = "FBLA State Leadership Training";
        String eventFour = "Science Olympiad State";
        String eventFive = "Belles Spring Show, auditorium, 7pm";
        String eventSix = "Bridgeland Orchestra Solo and Ensemble";
        String eventSeven = "Bridgeland HOSA National Competition";
        String eventEight = "Bridgeland Science Olympiad District Competition";
        String eventNine = "FBLA Nationals";
        String eventTen = "Bridgeland Key Club Meeting";
        String eventEleven = "Bridgeland Computer Science Club Meeting";
        String eventTwelve = "Bridgeland National Honor Society Meeting";
        String eventThirteen = "Bridgeland Science Olympiad Meeting";


        // Actual Code
        CalendarView calendarView; //creates the calendar view
        TextView firstDate; //this and the next line is the texView that we update for each date's events
        TextView secondDate;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calandar);
        //setting our variables equal to their respective views
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        firstDate = (TextView) findViewById(R.id.firstEvent);
        secondDate = (TextView) findViewById(R.id.eventTwo);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i; //creates the date for us to compare with
                //the following lines decide what events to display for the day selected
                if (date.equals("7/4/2023")) {
                    firstDate.setText(eventOne);
                }
                else if (date.equals("4/10/2023")) {
                    firstDate.setText(eventTwo);
                }
                else if (date.equals("5/22/2023")) {
                    firstDate.setText(eventThree);
                }
                else if (date.equals("5/23/2023")) {
                    firstDate.setText(eventThree);
                }
                else if (date.equals("5/24/2023")) {
                    firstDate.setText(eventThree);
                }
                else if (date.equals("4/21/2023")) {
                    firstDate.setText(eventFour);
                    secondDate.setText(eventFive);
                }
                else if (date.equals("4/19/2023")) {
                    firstDate.setText(eventNine);
                }
                else if (date.equals("6/28/2023")) {
                    firstDate.setText("FBLA NLC Day 2");
                }
                else if (date.equals("7/21/2023")) {
                    firstDate.setText(eventTwo);
                }
                else if (date.equals("1/28/2023")) {
                    firstDate.setText(eventSeven);
                    secondDate.setText(eventEight);
                }
                else if (date.equals("6/3/2023")||date.equals("6/4/2023")||date.equals("6/5/2023"))
                {
                    firstDate.setText(eventSix);
                }
                else {
                    firstDate.setText("");
                    secondDate.setText("");
                }
            }
     });
    }
};