package com.example.xiaomi04.timertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.os.Message;

public class MainActivity extends Activity {

    private static final int MSG_NEXT_STEP_WHAT = 1;
    private static final int MSG_NEXT_STEP_INTERVAL = 1000;
    private int mAutoNextStepTime = 10;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.myButton);
        button.setText(getString(R.string.button_text_next_step_timer, mAutoNextStepTime));
        button.setEnabled(false);
        mHandler.sendEmptyMessageDelayed(MSG_NEXT_STEP_WHAT, MSG_NEXT_STEP_INTERVAL);
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            mAutoNextStepTime --;
            if (mAutoNextStepTime == 0) {
                button.setEnabled(true);
                button.setText(R.string.button_text_on);
            } else {
                if (mAutoNextStepTime == 0) {
                    button.setEnabled(true);
                    button.setText(R.string.button_text_next_step_timer);
                } else {
                    button.setText(getString(R.string.button_text_next_step_timer, mAutoNextStepTime));
                }
                mHandler.removeMessages(MSG_NEXT_STEP_WHAT);
                mHandler.sendEmptyMessageDelayed(MSG_NEXT_STEP_WHAT, MSG_NEXT_STEP_INTERVAL);
            }
        };
    };
}
