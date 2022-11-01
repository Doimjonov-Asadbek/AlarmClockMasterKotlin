package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Begona : AppCompatActivity() {

    private lateinit var userList: ArrayList<ListData>
    private lateinit var listAdapter: ListAdapter
    private lateinit var listView: ListView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_clock)

        val sharedPreferences: SharedPreferences = getSharedPreferences("SharedPreference", MODE_PRIVATE)
        val token = sharedPreferences.getString("token", "").toString()

        userList = ArrayList()
        listView = findViewById(R.id.listView)

        val settings = findViewById<View>(R.id.settings)
        val actionButton = findViewById<FloatingActionButton>(R.id.ActionButton)

        settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        actionButton.setOnClickListener {
            allClock()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("InflateParams")
    private fun allClock() {
        val inflater = LayoutInflater.from(this)
        val v = inflater.inflate(R.layout.add_list, null)
        val spinnerClock = v.findViewById<TimePicker>(R.id.spinnerClock)

        val comment = v.findViewById<EditText>(R.id.comment)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
            userList.add(ListData(clock, commentText, switchs))
            listAdapter = ListAdapter(this, userList)
            listView.adapter = listAdapter
        }
        addDialog.setNegativeButton("Bekor qilish") { _, _ -> }
        addDialog.show()
    }
}




