package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
        Log.d("Main","main onCreate");
        EditText text =findViewById(R.id.edit_text);

        prefs = getSharedPreferences("FileName", MODE_PRIVATE);
        email = prefs.getString("Email", "");
        if(!email.isEmpty()) {
            text.setText(email);
        }
        Button buttonLogin =(Button)findViewById(R.id.button_login);
        if(buttonLogin != null)
            buttonLogin.setOnClickListener(v -> {
                email=text.getText().toString();
                Intent goToPage2 = new Intent(MainActivity.this, ProfileActivity.class);
                goToPage2.putExtra("email",email);
                startActivity(goToPage2);
            });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main","main onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("Main","main onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main","main onStop");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("Main","email="+email);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Email", email);
        editor.commit();
    }
}

