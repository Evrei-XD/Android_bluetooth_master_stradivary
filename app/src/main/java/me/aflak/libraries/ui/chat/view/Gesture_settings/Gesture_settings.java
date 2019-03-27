package me.aflak.libraries.ui.chat.view.Gesture_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import me.aflak.libraries.R;

public class Gesture_settings extends AppCompatActivity {

    private static final String TAG = "Gesture_settings";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_settings);
        Log.i(TAG, "gesture settings started");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.i(TAG,"getIncomingIntent");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.i(TAG,"getIncomingIntent-->fond intent extras");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);
        }
    }

    private void setImage(String imageUrl, String imageName){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

//        ImageView image = findViewById(R.id.image);
//        Glide.with(this)
//                .asBitmap()
//                .load(imageUrl)
//                .into(image);
    }

}
