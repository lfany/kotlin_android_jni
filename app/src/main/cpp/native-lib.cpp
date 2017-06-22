#include <jni.h>
#include <string>

extern "C"
jstring
Java_ifnot_xx_hello_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "From C++: 点击屏幕任何地方跳转";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
jstring
Java_ifnot_xx_hello_Main22Activity_stringHello(
        JNIEnv *env,
        jobject, jstring name) {
    std::string hello = "From C++: Hello from ";
    hello += env->GetStringUTFChars(name, JNI_FALSE);
    return env->NewStringUTF(hello.c_str());
}
