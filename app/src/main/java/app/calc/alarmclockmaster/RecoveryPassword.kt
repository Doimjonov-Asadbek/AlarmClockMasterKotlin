package app.calc.alarmclockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RecoveryPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_password)

        val viewRecoveryBack = findViewById<View>(R.id.viewRecoveryBack)

        viewRecoveryBack.setOnClickListener {
            onBackPressed()
        }

    }
}