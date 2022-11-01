package app.calc.alarmclockmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import app.calc.alarmclockmaster.models.ApiClient
import app.calc.alarmclockmaster.models.SignIn
import com.google.gson.JsonObject
import retrofit2.Call

class SignInActivity : AppCompatActivity() {

    var json: JsonObject? = null

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
                val signin = SignIn(
                    edtSignEmail.text.toString(),
                    edtSignPassword.text.toString()
                )

                val signIn: Call<SignIn> = ApiClient.userService.signIn(signin)
                signIn.enqueue(object : retrofit2.Callback<SignIn> {
                    override fun onResponse(call: Call<SignIn>, response: retrofit2.Response<SignIn>) {
                        if (response.code() == 200){
                            val user = response.body()
                            if (user != null){
                                val intent = Intent(this@SignInActivity,ClockActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                        if (response.code() == 400){
                            val message = json?.get("error")?.asString
                            if (message == "password is incorrect"){
                                edtSignPassword?.error = "Parol noto'g'ri"
                            }
                            if(message == "email is incorrect"){
                                edtSignEmail?.error = "Bunday pochta mavjud emas"
                            }
                            if (message == "email is not verified"){
                                AlertDialog.Builder(this@SignInActivity)
                                    .setTitle("Hisobingizni tasdiqlang !")
                                    .setMessage("Hisobingiz tasdiqlanmagan. Tasdiqlash uchun kodni kiriting")
                                    .setPositiveButton("OK"){dialog, which ->
                                        dialog.dismiss()
                                    }
                                    .show()
                            }
                        }
                    }
                    override fun onFailure(call: Call<SignIn>, t: Throwable) {
                        Toast.makeText(this@SignInActivity,"Nimadir xato ketti", Toast.LENGTH_SHORT).show()
                    }
                })

            }
        }
    }
}