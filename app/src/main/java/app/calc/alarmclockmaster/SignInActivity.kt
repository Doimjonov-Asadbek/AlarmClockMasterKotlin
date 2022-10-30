package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_in)

        val txtSignRecoveryPassword = findViewById<TextView>(R.id.txtSignRecoveryPassword)
        val txtSignRegistration = findViewById<TextView>(R.id.txtSignRegistration)
        val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val edtSignEmail = findViewById<EditText>(R.id.edtSignEmail)
        val edtSignPassword = findViewById<EditText>(R.id.edtSignPassword)

        txtSignRecoveryPassword.setOnClickListener {
            val intent = Intent(this, RecoveryEmailCode::class.java)
            startActivity(intent)
        }

        txtSignRegistration.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnSignIn.setOnClickListener {
            if (edtSignEmail.text.toString().isEmpty()){
                edtSignEmail.error = "Emailni kiriting"
            }
            else if(edtSignPassword.text.toString().isEmpty()){
                edtSignPassword.error = "Parolni kiriting"
            }
            else if (edtSignPassword.text.toString().length < 4){
                edtSignPassword.error = "Parol kamida 4 ta belgidan iborat bo'lishi kerak"
            }
            else {
                val intent = Intent(this, ConfirmationCode::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}