package com.appsa4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int mCount= 0;
    private TextView mShowCount;
    private int secondCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitytoast);
        mShowCount= (TextView) findViewById(R.id.show_count);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();

    }

    public void countUp(View view) {
        EditText limitInput = findViewById(R.id.input_limit);
        if(!limitInput.getText().toString().isEmpty()) {
            int limit = Integer.parseInt(limitInput.getText().toString());
            if(mCount >= limit)  {
                Toast.makeText(this, "Telah mencapai limit", Toast.LENGTH_LONG).show();
                return;
            }
        }
        int next = mCount;
        mCount = secondCount;
        secondCount = next + mCount;
        if (mShowCount != null) {
            mShowCount.setTextColor(getColor());
            mShowCount.setText(Integer.toString(next));
        }
    }

    public void reset(View view) {
        mCount = 0;
        secondCount = 1;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public int getColor() {
        int getNumber = Integer.parseInt(mShowCount.getText().toString());
        if(getNumber % 4 == 0) {
            return ContextCompat.getColor(this, R.color.black);
        } else if (getNumber % 4 == 1){
            return ContextCompat.getColor(this, R.color.blue);
        } else if (getNumber % 4 == 2) {
            return ContextCompat.getColor(this, R.color.black);
        } else {
            return ContextCompat.getColor(this, R.color.blue);
        }
    }
}