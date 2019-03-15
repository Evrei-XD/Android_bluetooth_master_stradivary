package me.aflak.libraries.ui.chat.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.aflak.libraries.MyApp;
import me.aflak.libraries.R;
import me.aflak.libraries.ui.chat.data.ChatModule;
import me.aflak.libraries.ui.chat.data.DaggerChatComponent;
import me.aflak.libraries.ui.chat.presenter.ChatPresenter;

/**
 * Created by Omar on 20/12/2017.
 */

public class ChatActivity extends AppCompatActivity implements ChatView{
    @BindView(R.id.activity_chat_status) TextView state;
    @BindView(R.id.seekBar) SeekBar seekBarCH1on;
    @BindView(R.id.seekBar2) SeekBar seekBarCH1off;
    @BindView(R.id.valueCH1on) TextView valueCH1on;
    @BindView(R.id.valueCH1off) TextView valueCH1off;
    @BindView(R.id.activity_chat_messages) TextView messages;
    @BindView(R.id.valueCH1) TextView valueCH1;
    @BindView(R.id.activity_chat_hello_world) Button helloWorld;
    private int intValueCH1off;
    private int intValueCH1on;
    public byte[] Textbyte;

    @Inject ChatPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        DaggerChatComponent.builder()
            .bluetoothModule(MyApp.app().bluetoothModule())
            .chatModule(new ChatModule(this))
            .build().inject(this);

        ButterKnife.bind(this);

        presenter.onCreate(getIntent());
        seekBarCH1on.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueCH1on.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH1on.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH1on.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarCH1off.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                intValueCH1off = seekBar.getProgress();
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
            }
        });
    }

    @OnClick(R.id.activity_chat_hello_world)
    public void onHelloWorld(){
//        presenter.sendData(intValueCH1off);
        presenter.onHelloWorld(Textbyte);
    }

    @Override
    public void setStatus(String status) {
        state.setText(status);
    }

    @Override
    public void setStatus(int resId) {
        state.setText(resId);
    }

    @Override
    public void setValueCH1(int levelCH1) {
        String str = new String(String.valueOf(levelCH1));
        valueCH1.setText(str);
    }

    @Override
    public void appendMessage(String message) {
        String str = messages.getText()+"\n"+message;
        messages.setText(str);
    }

    @Override
    public void enableHWButton(boolean enabled) {
        helloWorld.setEnabled(enabled);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
