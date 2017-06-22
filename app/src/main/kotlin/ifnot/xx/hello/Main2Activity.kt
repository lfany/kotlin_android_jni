package ifnot.xx.hello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import hello.Hello
import kotlinx.android.synthetic.main.activity_main2.*

class Main22Activity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(v?.context, when (v?.id) {
            btn_err.id -> Hello.reportError(btn_err.text.toString())
            btn_crash.id -> Hello.reportPainc(btn_crash.text.toString())

            else -> {
                null
            }
        } ?: "点击了", Toast.LENGTH_SHORT)
                .show()
    }

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = Hello.title("hello")
        tv.text = stringHello("Jni")

        tv2.text = Hello.greetings("go")

        btn_err.setOnClickListener(this)
        btn_crash.setOnClickListener(this)
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
