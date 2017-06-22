package ifnot.xx.hello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import hello.Hello
import kotlinx.android.synthetic.main.activity_main2.*

class Main22Activity : AppCompatActivity() {

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = Hello.title("hello")
        tv.text = stringHello("Jni")

        tv2.text = Hello.greetings("go")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                finish()
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }

    external fun stringHello(name: String): String
}
