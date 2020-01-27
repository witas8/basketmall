package com.example.basketmall;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class DateTimePicker extends AppCompatActivity {

    ImageButton dateBtn, timeBtn;
    TextView dateText, timeText;
    Button setBtn, cancelBtn;
    String viewTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_date_time_picker );

        getSupportActionBar().setTitle("Set your shopping reminder"); // set the top title

        dateBtn = findViewById( R.id.dateBtn);
        timeBtn = findViewById( R.id.timeBtn );
        dateText = findViewById( R.id.dateText );
        timeText = findViewById( R.id.timeText );
        setBtn = findViewById( R.id.setBtn );
        cancelBtn = findViewById( R.id.cancelBtn );

        dateBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateBtn();
            }
        } );

        timeBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimeBtn();
            }
        } );
    }


    public TimePickerDialog handleTimeBtn(){
        int setHour = 12;
        int setMinute = 0;

        TimePickerDialog timePickerDialog = new TimePickerDialog( this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String AM_PM;
                if(hourOfDay >= 12){
                    AM_PM = "in the afternoon";
                }else {
                    AM_PM = "in the morning";
                }

                String timeString;
                if(hourOfDay>=10 && minute>=10){
                    timeString = hourOfDay + ":" + minute + " " + AM_PM;
                }
                else if(hourOfDay<10 && minute>=10) {
                    timeString = "0" + hourOfDay + ":" + minute + " " + AM_PM;
                }
                else if(hourOfDay>=10 && minute<10) {
                    timeString = hourOfDay + ":0" + minute + " " + AM_PM;
                }
                else{
                    timeString = "0" + hourOfDay + ":0" + minute + " " + AM_PM;
                }

                viewTimeText = "Shopping time:\n" + timeString;
                timeText.setText(viewTimeText);
            }
        }, setHour, setMinute, true );
        timePickerDialog.show();

        return timePickerDialog;
    }


    public DatePickerDialog handleDateBtn(){
        Calendar calendar = Calendar.getInstance();

        int setYear = calendar.get(calendar.YEAR);
        int setMonth = calendar.get(calendar.MONTH);
        int setDay = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog( this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                int m;
                if(month == 12){
                    m = 12;
                }
                else{
                    m = month+1;
                }

                String dateString;
                if(m>=10 && day>=10){
                    dateString = day + "/" + m + "/" + year;
                }
                else if(m<10 && day>=10){
                    dateString = day + "/0" + m + "/" + year;
                }
                else if(m>=10 && day<10){
                    dateString = "0" + day + "/" + m + "/" + year;
                }
                else{
                    dateString = "0" +day + "/0" + m + "/" + year;
                }


                String viewDateText = "Shopping date:\n" + dateString;
                dateText.setText( viewDateText );
            }
        }, setYear, setMonth, setDay );

        datePickerDialog.show();

        return datePickerDialog;
    }


    public void resetText(){
        handleDateBtn().cancel();
        dateText.setText("Set shopping time");
        handleTimeBtn().cancel();
        timeText.setText( "Set shopping date" );
    }

    public void handleSetBtn(View view){
        if((timeText.getText().length()>17) && (dateText.getText().length()>17)) {
            //time text
            CharSequence timeChar = timeText.getText();
            String hourString = timeChar.subSequence( 15, 17 ).toString();
            String minuteString = timeChar.subSequence( 18, 20 ).toString();
            String hour0 = String.format( hourString, "%02" ); //hour with zeros
            String minute0 = String.format( minuteString, "%02" ); //minute with zeros
            int setHour = Integer.parseInt( hour0 ); //popraw
            int setMinute = Integer.parseInt( minute0 ); //popraw

            //date text
            CharSequence dateChar = dateText.getText();
            String dayString = dateChar.subSequence( 15, 17 ).toString();
            String monthString = dateChar.subSequence( 18, 20 ).toString();
            String yearString = dateChar.subSequence( 21, 25 ).toString();

            System.out.println(dayString);
            System.out.println(monthString);
            System.out.println(yearString);
            String day0 = String.format( dayString, "%02" );
            String month0 = String.format( monthString, "%02" );
            String year0 = String.format( yearString, "%04" );
            int setDay = Integer.parseInt( day0 );
            int setMonth = Integer.parseInt( month0 );
            int setYear = Integer.parseInt( year0 );

            createNotificationChannel();
            AlarmManager alarmManager = (AlarmManager) getSystemService( ALARM_SERVICE );
            Intent alertIntent = new Intent( this, AlertReceiver.class );

            Calendar startTime = Calendar.getInstance();
            startTime.set( Calendar.HOUR_OF_DAY, setHour );
            startTime.set( Calendar.MINUTE, setMinute );
            startTime.set( Calendar.SECOND, 0 );
            startTime.set( Calendar.DATE, setDay );
            startTime.set( Calendar.MONTH, setMonth-1 );
            startTime.set( Calendar.YEAR, setYear );

            long alarmTime = startTime.getTimeInMillis();
            alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, PendingIntent.getBroadcast( this, 1, alertIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT));

            Toast.makeText( this, "Notification is set!", Toast.LENGTH_SHORT ).show();
        }
        else{
            Toast.makeText( this, "Please, set time and date!", Toast.LENGTH_SHORT ).show();
        }
    }

    public void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "myChannel";
            String description = "Channel for my notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel( "notifyId", name, importance );
            channel.getLockscreenVisibility();
            channel.setDescription( description );

            NotificationManager notificationManager = getSystemService( NotificationManager.class);
            notificationManager.createNotificationChannel( channel );
        }

    }


    public void handleCancelBtn(View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = getSystemService( NotificationManager.class );
            manager.deleteNotificationChannel( "notifyId" );
            resetText();
            Toast.makeText( this, "Notification is canceled!", Toast.LENGTH_SHORT ).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate( R.menu.upper_bar, menu  );
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_basket:
                Intent intent = new Intent(this, BasketHandler.class);
                startActivity( intent );
                break;
            case R.id.shopping_time:
                Intent intent2 = new Intent(this, DateTimePicker.class);
                startActivity( intent2 );
                break;
            case R.id.back_menu:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity( intent3 );
                return true;
        }
        return true;
    }
}
