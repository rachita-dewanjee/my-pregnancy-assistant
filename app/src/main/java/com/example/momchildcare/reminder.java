package com.example.momchildcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class reminder extends AppCompatActivity implements View.OnClickListener {
    int notificationId=1;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
         findViewById(R.id.setbtn).setOnClickListener(this);
         findViewById(R.id.cancelbtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText editText=findViewById(R.id.edittext) ;
        TimePicker timePicker=findViewById(R.id.timepicker);

        Intent intent=new Intent(reminder.this,AlarmReciever.class);
        intent.putExtra("notificationId",notificationId);
        intent.putExtra("todo",editText.getText().toString());
        PendingIntent alarmIntent=PendingIntent.getBroadcast(reminder.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
        switch (v.getId()){
            case R.id.setbtn:
                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                //create time
                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime= startTime.getTimeInMillis();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
                Toast.makeText(this,"DONE",Toast.LENGTH_SHORT).show();
                break;

            case R.id.cancelbtn:
                alarm.cancel(alarmIntent);
                Toast.makeText(this,"canceled",Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
