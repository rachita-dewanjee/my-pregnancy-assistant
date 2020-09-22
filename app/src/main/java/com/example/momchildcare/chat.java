package com.example.momchildcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chat extends AppCompatActivity  {

    private EditText txt_pNumber,txt_messege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        txt_messege=findViewById(R.id.txt_messege);
        txt_pNumber=findViewById(R.id.txt_phone_number);


    }


    public void btn_send(View view) {
        int permissionCheck= ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permissionCheck== PackageManager.PERMISSION_GRANTED){
            MyMessage();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},0);
        }
    }


    private void MyMessage() {
        String phoneNumber=txt_pNumber.getText().toString().trim();
        String Message=txt_messege.getText().toString().trim();
        if(txt_pNumber.getText().toString().equals("")||!txt_messege.getText().toString().equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, Message, null, null);
            Toast.makeText(this, "messsege sent", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"please enter number oe messege",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case 0:
                if(grantResults.length>=0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    MyMessage();
                }
                else{
                    Toast.makeText(this,"you dont have permission",Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }





}
