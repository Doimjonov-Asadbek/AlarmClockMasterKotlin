package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_settings)

        val viewSettingsBack = findViewById<View>(R.id.viewSettingsBack)
        val btnLogOut = findViewById<Button>(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Hisobdan chiqmoqchimisiz?")
            builder.setPositiveButton("Ha") { _: DialogInterface, _: Int ->
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
            builder.setNegativeButton("Yo'q") { _: DialogInterface, _: Int -> }
            builder.show()
        }

        viewSettingsBack.setOnClickListener {
            onBackPressed()
        }
    }
}