package ifnot.xx.hello

import android.content.Intent
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : android.support.v7.app.AppCompatActivity() {

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sample_text.text = stringFromJNI()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                startActivity(Intent(this, Main22Activity::class.java))
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }

    external fun stringFromJNI(): String

}
