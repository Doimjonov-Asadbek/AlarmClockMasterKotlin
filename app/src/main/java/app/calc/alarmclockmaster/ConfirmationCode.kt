package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.Button
import android.widget.EditText

class ConfirmationCode : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_confirmation_code)

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
                val intent = Intent(this, ClockActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}