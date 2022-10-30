package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RecoveryPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_password)

        val edtRecoveryPass = findViewById<EditText>(R.id.edtRecoveryPass)
        val edtRecoveryReturnPass = findViewById<EditText>(R.id.edtRecoveryReturnPass)
        val btnRecovery = findViewById<Button>(R.id.btnRecovery)

        btnRecovery.setOnClickListener {
            if (edtRecoveryPass.text.toString().isEmpty()) {
                edtRecoveryPass.error = "Parolni kiriting"
            }
            else if (edtRecoveryReturnPass.text.toString().isEmpty()) {
                edtRecoveryReturnPass.error = "Parolni kiriting"
            }
            else if (edtRecoveryPass.text.toString().length < 4) {
                edtRecoveryReturnPass.error = "Parol kamida 4 ta belgidan iborat bo'lishi kerak"
            }
            else if (edtRecoveryPass.text.toString() != edtRecoveryReturnPass.text.toString()) {
                edtRecoveryReturnPass.error = "Parollar mos kelmadi"
            }
            else {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }
}