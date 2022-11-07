    package app.calc.alarmclockmaster

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.ProgressBar
    import android.widget.TextView
    import android.widget.Toast
    import androidx.appcompat.app.AlertDialog
    import app.calc.alarmclockmaster.models.ApiClient
    import app.calc.alarmclockmaster.models.SignIn
    import com.google.gson.Gson
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
            val gson = Gson()
            val signProgress = findViewById<ProgressBar>(R.id.signProgress)

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