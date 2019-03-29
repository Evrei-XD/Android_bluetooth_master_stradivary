package me.aflak.libraries.ui.chat.view.Gripper_settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aflak.libraries.MyApp;
import me.aflak.libraries.R;
import me.aflak.libraries.ui.chat.data.ChatModule;
import me.aflak.libraries.ui.chat.data.DaggerChatComponent;
import me.aflak.libraries.ui.chat.presenter.ChatPresenter;
import me.aflak.libraries.ui.chat.view.ChatView;


public class GripperSettings extends AppCompatActivity implements ChatView {
    @BindView(R.id.seekBarFinger1Angle) SeekBar seekBarFinger1Angle;
    @BindView(R.id.seekBarFinger2Angle) SeekBar seekBarFinger2Angle;
    @BindView(R.id.seekBarFinger3Angle) SeekBar seekBarFinger3Angle;
    @BindView(R.id.seekBarFinger4Angle) SeekBar seekBarFinger4Angle;
    @BindView(R.id.seekBarFinger5Angle) SeekBar seekBarFinger5Angle;
    @BindView(R.id.seekBarFinger1Speed) SeekBar seekBarFinger1Speed;
    @BindView(R.id.seekBarFinger2Speed) SeekBar seekBarFinger2Speed;
    @BindView(R.id.seekBarFinger3Speed) SeekBar seekBarFinger3Speed;
    @BindView(R.id.seekBarFinger4Speed) SeekBar seekBarFinger4Speed;
    @BindView(R.id.seekBarFinger5Speed) SeekBar seekBarFinger5Speed;
    @BindView(R.id.valueFinger1Angle) TextView valueFinger1Angle;
    @BindView(R.id.valueFinger2Angle) TextView valueFinger2Angle;
    @BindView(R.id.valueFinger3Angle) TextView valueFinger3Angle;
    @BindView(R.id.valueFinger4Angle) TextView valueFinger4Angle;
    @BindView(R.id.valueFinger5Angle) TextView valueFinger5Angle;
    @BindView(R.id.valueFinger1Speed) TextView valueFinger1Speed;
    @BindView(R.id.valueFinger2Speed) TextView valueFinger2Speed;
    @BindView(R.id.valueFinger3Speed) TextView valueFinger3Speed;
    @BindView(R.id.valueFinger4Speed) TextView valueFinger4Speed;
    @BindView(R.id.valueFinger5Speed) TextView valueFinger5Speed;
    @BindView(R.id.save_gripper_settings) Button save_gripper_settings;
    private int intValueFinger1Angle = 50;
    private int intValueFinger2Angle = 50;
    private int intValueFinger3Angle = 50;
    private int intValueFinger4Angle = 50;
    private int intValueFinger5Angle = 50;
    private int intValueFinger1Speed = 20;
    private int intValueFinger2Speed = 20;
    private int intValueFinger3Speed = 20;
    private int intValueFinger4Speed = 20;
    private int intValueFinger5Speed = 20;
    private byte indicatorTypeMessage = 0x03;
    private byte numberFinger;
    private byte requestType = 0x02;
    private byte GESTURE_SETTINGS = 0x21;
    private byte NUMBER_CELL = 0x00;
    public byte[] TextByteTreeg = new byte[8];
    private static final String TAG = "GripperSettings";
    
    @Inject ChatPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gripper_settings);

        DaggerChatComponent.builder()
                .bluetoothModule(MyApp.app().bluetoothModule())
                .chatModule(new ChatModule(this))
                .build().inject(this);
        ButterKnife.bind(this);

        save_gripper_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberFinger;
                TextByteTreeg[2] = numberFinger;
                TextByteTreeg[3] = numberFinger;
                TextByteTreeg[4] = numberFinger;
                TextByteTreeg[5] = numberFinger;
                TextByteTreeg[6] = numberFinger;
                TextByteTreeg[7] = numberFinger;
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        presenter.onCreate(getIntent());
        seekBarFinger1Angle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger1Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger1Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger1Angle.setText(String.valueOf(seekBar.getProgress()));
                intValueFinger1Angle = seekBarFinger1Angle.getProgress();
                numberFinger = 0x01;
                TextByteTreeg[0] = indicatorTypeMessage;
                TextByteTreeg[1] = numberFinger;
                TextByteTreeg[2] = requestType;
                TextByteTreeg[3] = GESTURE_SETTINGS;
                TextByteTreeg[4] = NUMBER_CELL;
                TextByteTreeg[5] = (byte) intValueFinger1Angle;
                TextByteTreeg[6] = (byte) intValueFinger1Speed;
                for (int i = 0; i < TextByteTreeg.length-1; i++){
                    TextByteTreeg[7] += TextByteTreeg[i];
                    TextByteTreeg[7] = (byte) (TextByteTreeg[7] << 1);
                }
                presenter.onHelloWorld(TextByteTreeg);
            }
        });

        seekBarFinger2Angle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger2Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger2Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger2Angle.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger3Angle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger3Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger3Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger3Angle.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger4Angle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger4Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger4Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger4Angle.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger5Angle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger5Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger5Angle.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger5Angle.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger1Speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger1Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger1Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger1Speed.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger2Speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger2Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger2Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger2Speed.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger3Speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger3Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger3Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger3Speed.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger4Speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger4Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger4Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger4Speed.setText(String.valueOf(seekBar.getProgress()));
            }
        });

        seekBarFinger5Speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueFinger5Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valueFinger5Speed.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueFinger5Speed.setText(String.valueOf(seekBar.getProgress()));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        presenter.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("GRIPPER_SETTINGS--------------> nonStop");
//        presenter.onStop();
    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public void setStatus(int resId) {

    }

    @Override
    public void setValueCH(int levelCH, int numberChannel) {

    }

    @Override
    public void appendMessage(String message) {

    }

    @Override
    public void enableHWButton(boolean enabled) {

    }

    @Override
    public void showToast(String message) {

    }

//    @Override
//    public void onGestureClick(int position, String extraName, BluetoothDevice extraDevice) {
//
//    }
}