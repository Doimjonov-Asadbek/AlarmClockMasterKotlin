package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class RecoveryEmailCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_email_code)

        val viewRecoveryBack = findViewById<View>(R.id.viewRecoveryBack)
        val btnRecovery = findViewById<Button>(R.id.btnRecovery)

        viewRecoveryBack.setOnClickListener {
            onBackPressed()
        }

        btnRecovery.setOnClickListener {
            val intent = Intent(this, RecoveryPassword::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }
}