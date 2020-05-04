package com.xin.bob.fibonacci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.xin.bob.fibonacci.utils.Fibonacci;


public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("calculator");
    }

    private static final int param = 10000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.sample_text);
        TextView tv2 = findViewById(R.id.sample_text2);

        // Clang calculate
        long start = System.currentTimeMillis();
        int result = calculate(param);
        long usedTime = System.currentTimeMillis() - start;
        tv.setText(result + " in " + usedTime + "ms");

        // Java calculate
        long start2 = System.currentTimeMillis();
        int result2 = Fibonacci.fibonacciNormal(param);
        long usedTime2 = System.currentTimeMillis() - start2;
        tv2.setText(result2 + " in " + usedTime2 + "ms");

        Toast.makeText(this, getStringFromC(), Toast.LENGTH_SHORT).show();
    }

    public native int calculate(int param);

    public native String getStringFromC();
}
