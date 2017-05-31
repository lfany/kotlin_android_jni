#include <jni.h>
#include <string>

extern "C"
jstring
Java_ifnot_xx_hello_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "xxxxxxxxxx";
    return env->NewStringUTF(hello.c_str());
}

jstring
Java_ifnot_xx_hello_MainActivity_string_hello__(
        JNIEnv* env,
        jobject){
        std::string hello = "it's good!";
        return env->NewStringUTF(hello.c_str());
}
