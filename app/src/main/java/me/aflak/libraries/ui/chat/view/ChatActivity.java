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
    @BindView(R.id.seekBarCH1on) SeekBar seekBarCH1on;
    @BindView(R.id.seekBarCH1off) SeekBar seekBarCH1off;
    @BindView(R.id.seekBarCH1sleep) SeekBar seekBarCH1sleep;
    @BindView(R.id.seekBarCH2on) SeekBar seekBarCH2on;
    @BindView(R.id.seekBarCH2off) SeekBar seekBarCH2off;
    @BindView(R.id.seekBarCH2sleep) SeekBar seekBarCH2sleep;
    @BindView(R.id.valueCH1on) TextView valueCH1on;
    @BindView(R.id.valueCH1off) TextView valueCH1off;
    @BindView(R.id.valueCH1sleep) TextView valueCH1sleep;
    @BindView(R.id.valueCH2on) TextView valueCH2on;
    @BindView(R.id.valueCH2off) TextView valueCH2off;
    @BindView(R.id.valueCH2sleep) TextView valueCH2sleep;
    @BindView(R.id.activity_chat_messages) TextView messages;
    @BindView(R.id.valueCH1) TextView valueCH1;
    @BindView(R.id.activity_chat_hello_world) Button helloWorld;
    @BindView(R.id.activity_chat_hello_world2) Button helloWorld2;
    private int intValueCHon = 2500;
    private int intValueCHoff = 100;
    private int intValueCHsleep = 200;
    private byte indicatorTypeMessage;
    private byte numberChannel;
    public byte[] TextByteTreeg = new byte[8];

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

        TextByteTreeg[2] = (byte) intValueCHon;
        TextByteTreeg[3] = (byte) (intValueCHon >> 8);
        TextByteTreeg[4] = (byte) intValueCHoff;
        TextByteTreeg[5] = (byte) (intValueCHoff >> 8);
        TextByteTreeg[6] = (byte) intValueCHsleep;
        TextByteTreeg[7] = (byte) (intValueCHsleep >> 8);

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
                intValueCHon = seekBarCH1on.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x01;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[2] = (byte) intValueCHon;
                TextByteTreeg[3] = (byte) (intValueCHon >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarCH1off.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                intValueCHoff = seekBar.getProgress();
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH1off.setText(String.valueOf(seekBar.getProgress()));
                intValueCHoff = seekBarCH1off.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x01;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[4] = (byte) intValueCHoff;
                TextByteTreeg[5] = (byte) (intValueCHoff >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarCH1sleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueCH1sleep.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH1sleep.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH1sleep.setText(String.valueOf(seekBar.getProgress()));
                intValueCHsleep = seekBarCH1sleep.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x01;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[6] = (byte) intValueCHsleep;
                TextByteTreeg[7] = (byte) (intValueCHsleep >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarCH2on.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueCH2on.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH2on.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH2on.setText(String.valueOf(seekBar.getProgress()));
                intValueCHon = seekBarCH2on.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x02;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[2] = (byte) intValueCHon;
                TextByteTreeg[3] = (byte) (intValueCHon >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarCH2off.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueCH2off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH2off.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH2off.setText(String.valueOf(seekBar.getProgress()));
                intValueCHoff = seekBarCH2off.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x02;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[4] = (byte) intValueCHoff;
                TextByteTreeg[5] = (byte) (intValueCHoff >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarCH2sleep.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueCH2sleep.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueCH2sleep.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueCH2sleep.setText(String.valueOf(seekBar.getProgress()));
                intValueCHsleep = seekBarCH2sleep.getProgress();
                indicatorTypeMessage = 0x01;
                numberChannel = 0x02;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberChannel;
                TextByteTreeg[2] = (byte) intValueCHsleep;
                TextByteTreeg[3] = (byte) (intValueCHsleep >> 8);
                presenter.onHelloWorld(TextByteTreeg);
            }
        });
    }

    @OnClick(R.id.activity_chat_hello_world)
    public void onHelloWorld(){
//        presenter.sendData(intValueCH1off);
        presenter.onHelloWorld(TextByteTreeg);
    }

//    @OnClick(R.id.activity_chat_hello_world2)
//    public void onHelloWorld(){
////        presenter.sendData(intValueCH1off);
//        presenter.onHelloWorld(TextByteTreeg);
//    }

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
        helloWorld2.setEnabled(enabled);
        seekBarCH1on.setEnabled(enabled);
        seekBarCH1off.setEnabled(enabled);
        seekBarCH1sleep.setEnabled(enabled);
        seekBarCH2on.setEnabled(enabled);
        seekBarCH2off.setEnabled(enabled);
        seekBarCH2sleep.setEnabled(enabled);
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
