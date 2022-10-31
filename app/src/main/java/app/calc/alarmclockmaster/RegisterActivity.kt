package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import app.calc.alarmclockmaster.models.ApiClient
import app.calc.alarmclockmaster.models.SignUp
import retrofit2.Call

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

            val signUp = SignUp(
                edtRegisterEmail.text.toString(),
                edtRegisterPassword.text.toString()
            )

            val register: Call<SignUp> = ApiClient.userService.signUp(signUp)
            register.enqueue(object : retrofit2.Callback<SignUp> {
                override fun onResponse(call: Call<SignUp>, response: retrofit2.Response<SignUp>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@RegisterActivity, response.body()!!.token, Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<SignUp>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

    }
}