package com.example.test_firebase_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private DatabaseReference logRef = FirebaseDatabase.getInstance().getReference().child("log");
    private DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("users");
    private Uri ImageUri;
    private StorageReference imageRef;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                String message = editText.getText().toString();

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStamp  = dateFormat.format(new Date());

                writeLog(timeStamp,message);
            }
        });



        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText2 = findViewById(R.id.editText2);
                EditText editText3 = findViewById(R.id.editText3);
                EditText editText4 = findViewById(R.id.editText4);

                String userName = editText2.getText().toString();
                String email = editText3.getText().toString();
                String userId = editText4.getText().toString();

                //writeNewUser( userId, userName, email);
                writeNewUser2( userId, userName, email);
            }
        });



        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getData();
            }
        });



        logRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = "";
                for(DataSnapshot data : dataSnapshot.getChildren()){

                    String test = data.getValue().toString();
                    Log.i("value:", test);
                    value += test;
                }

//              String key = mDatabase.child("log").getDatabase().toString();
//              Toast.makeText(this, value, Toast.LENGTH_SHORT).show();

                TextView textView2 = findViewById(R.id.textView2);
                textView2.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



    private void writeNewUser(String userId, String name, String email) {
//        User user = new User(name, email);
//        mDatabase.child("users").child(userId).setValue(user);
        userRef.child(userId).setValue(name);
    }

    private void writeNewUser2(String userId, String name, String email) {
        HashMap<String, Object> userdataMap = new HashMap<>();
        userdataMap.put("name", name);
        userdataMap.put("password", email);
        userdataMap.put("phone", userId);

        userRef.child(userId).updateChildren(userdataMap);
    }

    public void writeLog(String timeStamp, String message){
        logRef.child(timeStamp).setValue(message);
    }

    public void getData(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.


//        String value = dataSnapshot.getValue(String.class);
//        Log.d(TAG, "Value is: " + value);
    }




}


