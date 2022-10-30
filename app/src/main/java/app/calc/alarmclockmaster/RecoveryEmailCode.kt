package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText

class RecoveryEmailCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_email_code)

        val viewRecoveryBack = findViewById<View>(R.id.viewRecoveryBack)
        val btnRecovery = findViewById<Button>(R.id.btnRecovery)
        val edtRecoveryCode = findViewById<EditText>(R.id.edtRecoveryCode)

        edtRecoveryCode.filters = arrayOf(InputFilter.LengthFilter(6))

        viewRecoveryBack.setOnClickListener {
            onBackPressed()
        }

        btnRecovery.setOnClickListener {
            if (edtRecoveryCode.text.toString().isEmpty()) {
                edtRecoveryCode.error = "Kodni kiriting"
            }
            else if (edtRecoveryCode.text.toString().length < 6){
                edtRecoveryCode.error = "Kodni kiriting"
            }
            else {
                val intent = Intent(this, RecoveryPassword::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}