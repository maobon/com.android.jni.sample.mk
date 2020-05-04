#include<jni.h>
#include <android/log.h>

#define LOG_TAG "JNI_LOG"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

/**
 * Fibonacci calculate use C lang
 * @param n
 * @return
 */

JNIEXPORT jint JNICALL
Java_com_xin_bob_fibonacci_MainActivity_calculate(JNIEnv *env, jobject thiz, jint n) {

    LOGE("jni method is called");

    if (n <= 2) {
        return 1;
    }

    int n1 = 1, n2 = 1, sn = 0;
    for (int i = 0; i < n - 2; i++) {
        sn = n1 + n2;
        n1 = n2;
        n2 = sn;
    }

    return sn;
}

JNIEXPORT jstring JNICALL
Java_com_xin_bob_fibonacci_MainActivity_getStringFromC(JNIEnv *env, jobject thiz) {

    return (*env)->NewStringUTF(env, "string from C");
}