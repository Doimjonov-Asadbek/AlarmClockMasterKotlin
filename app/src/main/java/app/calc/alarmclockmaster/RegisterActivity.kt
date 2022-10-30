package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register)

        val txtRegisterSign = findViewById<TextView>(R.id.txtRegisterSign)
        val edtRegisterEmail = findViewById<EditText>(R.id.edtRegisterEmail)
        val edtRegisterPassword = findViewById<EditText>(R.id.edtRegisterPassword)
        val edtRegisterReturnPass = findViewById<EditText>(R.id.edtRegisterReturnPass)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            if (edtRegisterEmail.text.toString().isEmpty()){
                edtRegisterEmail.error = "Emailni kiriting"
            }
            else if (edtRegisterPassword.text.toString().isEmpty()){
                edtRegisterPassword.error = "Parolni kiriting"
            }
            else if (edtRegisterPassword.text.toString().length < 4){
                edtRegisterPassword.error = "Parol kamida 4 ta belgidan iborat bo'lishi kerak"
            }
            else if (edtRegisterReturnPass.text.toString().isEmpty()){
                edtRegisterReturnPass.error = "Parolni kiriting"
            }
            else if (edtRegisterPassword.text.toString() != edtRegisterReturnPass.text.toString()){
                edtRegisterReturnPass.error = "Parollar mos kelmadi"
            }
            else {
                val intent = Intent(this, ConfirmationCode::class.java)
                startActivity(intent)
                finish()
            }
        }

        txtRegisterSign.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}