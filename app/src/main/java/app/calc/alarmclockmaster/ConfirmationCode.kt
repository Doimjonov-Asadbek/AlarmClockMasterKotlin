package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import app.calc.alarmclockmaster.models.ApiClient
import app.calc.alarmclockmaster.models.SignUp
import retrofit2.Call

class ConfirmationCode : AppCompatActivity() {

    private var verify = ""
    private var token = ""
    private var email = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_confirmation_code)

        token = intent.getStringExtra("token").toString()
        verify = intent.getStringExtra("verify").toString()
        email = intent.getStringExtra("email").toString()

        val viewConfirmationBack = findViewById<View>(R.id.viewConfirmationBack)
        val btnConfirmation = findViewById<Button>(R.id.btnConfirmation)
        val edtConfirmationCode = findViewById<EditText>(R.id.edtConfirmationCode)

        edtConfirmationCode.filters = arrayOf(InputFilter.LengthFilter(6))

        viewConfirmationBack.setOnClickListener {
            onBackPressed()
        }

        btnConfirmation.setOnClickListener {
            if (edtConfirmationCode.text.toString().isEmpty()) {
                edtConfirmationCode.error = "Kodni kiriting"
            }
            else if (edtConfirmationCode.text.toString().length < 6){
                edtConfirmationCode.error = "Kodni kiriting"
            }
            else {
                val verify = SignUp(email,token)
                val verifyUser: Call<SignUp> = ApiClient.userService.verifyUser(verify)
                verifyUser.enqueue(object : retrofit2.Callback<SignUp> {
                    override fun onResponse(call: Call<SignUp>, response: retrofit2.Response<SignUp>) {
                        if (response.isSuccessful) {
                            val token = response.body()!!.token
                            val sharedPreferences:SharedPreferences = getSharedPreferences("SharedPreference", MODE_PRIVATE)
                            val user = sharedPreferences.edit().putString("token", token).apply()
                            val intent = Intent(this@ConfirmationCode, ClockActivity::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            edtConfirmationCode.error = "Kodni kiriting"
                        }
                    }
                    override fun onFailure(call: Call<SignUp>, t: Throwable) {
                        Toast.makeText(this@ConfirmationCode, "Internet bilan bog'lanishda xatolik", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}