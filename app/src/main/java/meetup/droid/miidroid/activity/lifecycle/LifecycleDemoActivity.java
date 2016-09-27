package meetup.droid.miidroid.activity.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import meetup.droid.miidroid.R;

public class LifecycleDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LifecycleDemoActivity.class.getSimpleName();

    private static StringBuilder mLogs = new StringBuilder();

    private TextView mTextView;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LifecycleDemoActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.tv_logs);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendEvent("onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        appendEvent("onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendEvent("onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendEvent("onResume()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        appendEvent("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appendEvent("onDestroy()");
    }

    private void appendEvent(String str) {
        mLogs.append(str).append('\n');
        Log.d(TAG, str);
        if (mTextView != null) {
            mTextView.setText(mLogs.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_clear:
                mLogs = new StringBuilder();
                if (mTextView != null) {
                    mTextView.setText("");
                }
            break;
        }
    }
}
