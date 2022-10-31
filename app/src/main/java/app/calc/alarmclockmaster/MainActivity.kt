package app.calc.alarmclockmaster

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val sharedPreferences:SharedPreferences = getSharedPreferences("SharedPreference", MODE_PRIVATE)
        val preference = sharedPreferences.getString("token","").toString()


        Handler().postDelayed({
            if (preference.isEmpty()) {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, ClockActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1000)
    }
}