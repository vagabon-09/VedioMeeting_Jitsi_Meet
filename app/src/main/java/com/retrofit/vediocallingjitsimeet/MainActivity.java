package com.retrofit.vediocallingjitsimeet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    static  final  String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        try{
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .build();
        }catch (Exception e){
            Log.d(TAG, "onCreate: "+e.getMessage());
        }
        Button btn = findViewById(R.id.joinBtn);
        btn.setOnClickListener(view -> {
            EditText tv = findViewById(R.id.room_id);
            String text = tv.getText().toString();


            // if user has typed some text in
            // EditText then only room will create
            if (!text.isEmpty()) {
                // creating a room using  JitsiMeetConferenceOptions class
                // here .setRoom() method will set the text in room name
                // here launch method with launch a new room to user where
                // they can invite others too.
                JitsiMeetConferenceOptions options
                        = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(text)
                        .build();
                JitsiMeetActivity.launch(this, options);
            }
        });
    }
}