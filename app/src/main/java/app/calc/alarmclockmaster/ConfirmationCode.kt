package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ConfirmationCode : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_confirmation_code)

        val viewConfirmationBack = findViewById<View>(R.id.viewConfirmationBack)
        val btnConfirmation = findViewById<Button>(R.id.btnConfirmation)

        viewConfirmationBack.setOnClickListener {
            onBackPressed()
        }

        btnConfirmation.setOnClickListener {
            val intent = Intent(this, ClockActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }

    }
}