#include <jni.h>
#include <string>

extern "C"
jstring
Java_ifnot_xx_hello_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "点击屏幕任何地方跳转";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring
Java_ifnot_xx_hello_Main22Activity_stringHello__(
        JNIEnv* env,
        jobject){
        std::string hello = "it's good!";
        return env->NewStringUTF(hello.c_str());
}
