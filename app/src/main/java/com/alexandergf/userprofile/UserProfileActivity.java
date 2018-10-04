package com.alexandergf.userprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class UserProfileActivity extends AppCompatActivity {
    //model
    private Profile profile;
    //referencias
    private TextView textabview;
    private TextView followingnumview;
    private TextView followersnumview;
    private ImageView backview;
    private ImageView fotoview;
    private TextView handleview;
    private TextView namelastview;
    private RequestQueue mQueue;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        gson = new Gson();

        /*
        try {
            InputStream stream = getAssets().open("AlexanderGonzalez.json");
            InputStreamReader reader = new InputStreamReader(stream);
            profile = gson.fromJson(reader, Profile.class);
        } catch (IOException e) {
            Toast.makeText(this, "No he pogut llegir", Toast.LENGTH_SHORT).show();
        }
        */

        //------------------------------------------------------
        mQueue= Volley.newRequestQueue(this);
        jsonParse();
        //-------------------------------------------------------
        textabview = findViewById(R.id.textoabview);
        followingnumview=findViewById(R.id.followingnumview);
        followersnumview=findViewById(R.id.followersnumview);
        namelastview=findViewById(R.id.namelastview);
        handleview=findViewById(R.id.handleview);


        backview = findViewById(R.id.backview);
        Glide.with(this)
                .load("file:///android_asset/UserProfile-background.jpg")
                .apply(bitmapTransform(new BlurTransformation(5)))
                .into(backview);

        fotoview=findViewById(R.id.fotoview);
        Glide.with(this)
                .load("file:///android_asset/fotoCV2.png")
                .apply(RequestOptions.circleCropTransform())
                .into(fotoview);
    }

    private void updateProfile() {
        textabview.setText(profile.getAbout());
        followingnumview.setText(profile.getFollowing());
        followersnumview.setText(profile.getFollowers());
        handleview.setText(profile.getHandle());
        namelastview.setText(profile.getName() + " " + profile.getLastname());
    }

    //------------------------------------------------------------------
    private void jsonParse() {
        String url="https://raw.githubusercontent.com/alexandergf/UserProfile/master/app/src/main/assets/AlexanderGonzalez.json";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                profile = gson.fromJson(response, Profile.class);
                updateProfile();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
//------------------------------------------------------------------
}
