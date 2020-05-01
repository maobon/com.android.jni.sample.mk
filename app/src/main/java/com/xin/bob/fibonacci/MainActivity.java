package com.xin.bob.fibonacci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xin.bob.fibonacci.utils.Fibonacci;

/**
 * 传统的ndk-build命令 编译出so文件 然后再Java代码中引入编译出的so文件
 * jni 文件夹中放置C的源码 Android.mk 和 Application.mk 使用ndk-build编译成so文件后调用
 * Android模式下 需要右键link一下Android.mk的文件路径 这样Android就可以正确识别native的方法了 不会报红了
 * 但是cmake方式没有使用ndk-build命令编译so包的过程 直接运行 直接打包进apk 直接就可以运行了
 * <p>
 * 调用ndk-build命令 需要再jni目录的上一级目录打开cmd窗口 执行ndk-build 生成so包
 * 生成出两个文件夹 libs和obj 将libs名称改为jniLibs即可 然后就在JAVA代码中引用库就可以了
 */
public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("calculator");
    }

    private static final int param = 99999999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.sample_text);
        TextView tv2 = (TextView) findViewById(R.id.sample_text2);

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
    }

    public native int calculate(int param);
}
