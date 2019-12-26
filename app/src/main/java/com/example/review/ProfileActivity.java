package com.example.review;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private  ImageButton mImageButton;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(ACTIVITY_NAME,"onCreate");
        setContentView(R.layout.activity_profilelayout);
        EditText text=findViewById(R.id.edit_email);
        Intent dataFromPreviousPage = getIntent();
        String email = dataFromPreviousPage.getStringExtra("email");
        text.setText(email);

        mImageButton =findViewById(R.id.imageButton);
        mImageButton.setOnClickListener(v -> {
            dispatchTakePictureIntent();
        });

    }

    private void dispatchTakePictureIntent() {
        Log.d(ACTIVITY_NAME,"dispatchTakePictureIntent");

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.d(ACTIVITY_NAME,"onActivityResult imageBitmap="+imageBitmap.toString());
            mImageButton.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ACTIVITY_NAME,"onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ACTIVITY_NAME,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ACTIVITY_NAME,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ACTIVITY_NAME,"onDestory");
    }
}

