package me.aflak.libraries.ui.chat.view.Gesture_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.aflak.libraries.R;
import me.aflak.libraries.data.GesstureAdapter;
import me.aflak.libraries.data.Gesture_my;

public class Gesture_settings2 extends AppCompatActivity implements GesstureAdapter.OnGestureMyListener {

    private static final String TAG = "Gesture_settings2";

    RecyclerView recyclerView;
    GesstureAdapter gestureAdapter;
    List<Gesture_my> gestureMyList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_settings);

        gestureMyList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.gestures_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        gestureMyList.add(
                new Gesture_my(
                        1,
                        R.drawable.ic_audiotrack_light,
                        "bla bla bla",
                        "13.3 inch, Silver, 1.35 kg",
                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
                        4.3,
                        60000));

        gestureAdapter = new GesstureAdapter(this, gestureMyList,this);
//        gestureAdapter = new GesstureAdapter(this, gestureMyList, this);
        recyclerView.setAdapter(gestureAdapter);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){

        }
    }

    @Override
    public void onGestureClick(int position) {

    }
}