package ifnot.xx.hello

import android.content.Intent
import android.view.MotionEvent
import com.getsentry.raven.android.Raven
import com.getsentry.raven.event.BreadcrumbBuilder
import com.getsentry.raven.event.Breadcrumbs
import com.getsentry.raven.event.Event
import com.getsentry.raven.event.EventBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : android.support.v7.app.AppCompatActivity() {

    init {
        System.loadLibrary("native-lib")
    }

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sample_text.text = stringFromJNI()

        Raven.init(baseContext)

        Raven.capture(EventBuilder()
                .withMessage("Exception caught")
                .withLevel(Event.Level.ERROR)
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_UP -> {
                startActivity(Intent(this, Main22Activity::class.java))
                Raven.capture("OnTouch Event")
                Breadcrumbs.record(
                        BreadcrumbBuilder().setMessage("User touched the window").build()
                )
                return true
            }
            else -> return super.onTouchEvent(event)
        }
    }

    external fun stringFromJNI(): String

}
