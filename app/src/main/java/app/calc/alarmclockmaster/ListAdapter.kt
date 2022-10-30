package app.calc.alarmclockmaster

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi

@Suppress("NAME_SHADOWING")
class ListAdapter(private val context:Activity, private val list:ArrayList<ListData>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ViewHolder", "UseSwitchCompatOrMaterialCode", "InflateParams", "MissingInflatedId")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.list_view
            , null, true)

        val clock = rowView.findViewById(R.id.textClock) as TextView
        val comment = rowView.findViewById(R.id.comment) as TextView
        val switchs = rowView.findViewById(R.id.switch1) as Switch

        clock.text = list[position].Clock
        comment.text = list[position].comment
        switchs.text = ""

        return rowView
    }
}