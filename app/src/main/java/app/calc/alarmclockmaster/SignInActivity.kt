package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_in)

        val txtSignRecoveryPassword = findViewById<TextView>(R.id.txtSignRecoveryPassword)
        val txtSignRegistration = findViewById<TextView>(R.id.txtSignRegistration)

        txtSignRecoveryPassword.setOnClickListener {
            val intent = Intent(this, RecoveryEmailCode::class.java)
            startActivity(intent)
        }

        txtSignRegistration.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }



    }
}