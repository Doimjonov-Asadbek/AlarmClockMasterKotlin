package app.calc.alarmclockmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_settings)

        val viewSettingsBack = findViewById<View>(R.id.viewSettingsBack)

        viewSettingsBack.setOnClickListener {
            onBackPressed()
        }

    }
}