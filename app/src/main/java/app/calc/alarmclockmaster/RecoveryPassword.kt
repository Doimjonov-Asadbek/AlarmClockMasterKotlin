package app.calc.alarmclockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RecoveryPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_password)
    }
}