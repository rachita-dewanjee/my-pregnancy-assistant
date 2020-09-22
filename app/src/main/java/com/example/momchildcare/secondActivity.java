package com.example.momchildcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class secondActivity extends AppCompatActivity implements View.OnClickListener {
    public Button food;
    public Button lifestyle;
    public Button healthissues;
    public Button babysgrowth;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        food=findViewById(R.id.foodId);
        lifestyle=findViewById(R.id.lifestyle);
        healthissues=findViewById(R.id.healthissues);
        babysgrowth=findViewById(R.id.babysgrowth);

        food.setOnClickListener(this);
        lifestyle.setOnClickListener(this);
        healthissues.setOnClickListener(this);
        babysgrowth.setOnClickListener(this);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.foodId){

            Intent intent =new Intent(getApplicationContext(),tipshowactivity.class);
            intent.putExtra("name","food");
            String text1="DAIRY LEGUMES SWEEETPOTATOES SALMON EGGS LEAFYGREENS LEANMEAT WHOLEGRAINS BERRIES AVACADOS DRIED FRUITS FISHLIVEROIL";
            String text2="HIGH MERCURYFISH  RAWFOOD ORGANMEAT CAFFEINE UNPASTURIIZES CHEESEMILK ALCHOL CIGGETRE PAPAYA RAW FISHMEAT ";


            DocumentReference documentReference=fStore.collection("tips for mother").document("tips");
            Map<String,Object> bp=new HashMap<>();
            bp.put("field1",text1);
            bp.put("field2",text2);


            intent.putExtra("tips","food");
            documentReference.set(bp).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    Toast.makeText(getApplicationContext() ,"Food Details", Toast.LENGTH_SHORT).show();
                }

            });
            startActivity(intent);

        }
        if(v.getId()==R.id.lifestyle){

            Intent intent =new Intent(getApplicationContext(),tipshowactivity.class);
            intent.putExtra("name","lifestyle");
            String text1="SEE YOUR DOCTOR REGULARLY   BE CAREFUL ABOUT FOOD HYGINE     EXCERCISE REGULARLY PRAY EVERYDAY  ALWAYS TRY TO BE HAPPY ANS POSITIVE";
            String text2="SMOKING  CATS ALCOHOL HAIRDYE lATE NIGHT SLEEPING DO HEAVY WORK   TAKE EXTRA TENSION ALCOHOL AVOID TAKING UNNECCESSARY MEDICINE ";


            DocumentReference documentReference=fStore.collection("tips for mother").document("tips");
            Map<String,Object> bp=new HashMap<>();
            bp.put("field1",text1);
            bp.put("field2",text2);


            intent.putExtra("tips","lifestyle");
            documentReference.set(bp).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    Toast.makeText(getApplicationContext() ,"Lifestyle Details", Toast.LENGTH_SHORT).show();
                }

            });
            startActivity(intent);

        }
        if(v.getId()==R.id.healthissues){

            Intent intent =new Intent(getApplicationContext(),tipshowactivity.class);
            intent.putExtra("name","healthissues");
            String text1="CONSTIPATION CRAMP FAINTING VOMITING  FEELING HOT MOOD SWINGS FEELING NERVOUSNESS OVER SILLY MATTTERS";
            String text2="BLEEDING  BABYS ACTIVTITY LEVEL SIGNIFICANTLY DECLINES  FEVER HIGH BLOOD PRESSURE ANXIETY FATEL PROBLEM";


            DocumentReference documentReference=fStore.collection("tips for mother").document("tips");
            Map<String,Object> bp=new HashMap<>();
            bp.put("field1",text1);
            bp.put("field2",text2);


            intent.putExtra("tips","healthissues");
            documentReference.set(bp).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    Toast.makeText(getApplicationContext() ,"healthissues Details", Toast.LENGTH_SHORT).show();
                }

            });
            startActivity(intent);

        }
        if(v.getId()==R.id.babysgrowth){

            Intent intent =new Intent(getApplicationContext(),tipshowactivity.class);
            intent.putExtra("name","babysgrowth");
            String text1="the end of the second month your baby now a fetus is about 2.54cm (1 inch) long weighs about 9.45g (1/3 ounce) and a third of baby is now made up of its head";
            String text2="nothing be worried about";


            DocumentReference documentReference=fStore.collection("tips for mother").document("tips");
            Map<String,Object> bp=new HashMap<>();
            bp.put("field1",text1);
            bp.put("field2",text2);


            intent.putExtra("tips","babysgrowth");
            documentReference.set(bp).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    Toast.makeText(getApplicationContext() ,"growth Details", Toast.LENGTH_SHORT).show();
                }

            });
            startActivity(intent);

        }







    }
}
