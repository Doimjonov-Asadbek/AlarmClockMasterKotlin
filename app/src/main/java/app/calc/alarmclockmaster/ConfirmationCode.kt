package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ConfirmationCode : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_confirmation_code)

        val viewConfirmationBack = findViewById<View>(R.id.viewConfirmationBack)

        viewConfirmationBack.setOnClickListener {
            onBackPressed()
        }

    }
}