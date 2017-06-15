package ifnot.xx.hello

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        title = Hello.greetings("hello go")
        tv.text = stringHello()
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

    external fun stringHello(): String
}
