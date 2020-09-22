package com.example.momchildcare;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class tipshowactivity extends AppCompatActivity {

    TextView text1,text2;
     FirebaseAuth fAuth;
     FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipshowactivity);
        Bundle bundle=getIntent().getExtras();
        String title=bundle.getString("name");
        this.setTitle(title);

        text1=findViewById(R.id.txt1);
        text2=findViewById(R.id.txt2);

        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        String tips=bundle.getString("tips");

        DocumentReference docRef = fStore.collection("tips for mother").document("tips");
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                text1.setText(documentSnapshot.getString("field1"));
                text2.setText(documentSnapshot.getString("field2"));

            }
        });
        }
    }

