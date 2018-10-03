package com.alexandergf.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class UserProfileActivity extends AppCompatActivity {

    private ImageView backview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        backview = findViewById(R.id.backview);
        Glide

    }
}
