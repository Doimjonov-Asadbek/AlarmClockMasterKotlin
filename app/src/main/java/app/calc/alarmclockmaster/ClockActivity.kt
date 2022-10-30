package app.calc.alarmclockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_clock)
    }
}