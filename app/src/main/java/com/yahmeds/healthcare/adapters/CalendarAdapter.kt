package com.yahmeds.healthcare.adapters

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.dataclass.CalendarDateModel
import java.util.*
import kotlin.collections.ArrayList


class CalendarAdapter(private val listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit) :
    RecyclerView.Adapter<CalendarAdapter.MyViewHolder>() {
    private val list = ArrayList<CalendarDateModel>()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(calendarDateModel: CalendarDateModel) {
            val calendarDay = itemView.findViewById<TextView>(R.id.tv_calendar_day)
            val calendarDate = itemView.findViewById<TextView>(R.id.tv_calendar_date)
            val cardView = itemView.findViewById<CardView>(R.id.card_calendar)
            if (calendarDateModel.isSelected) {
                val formatter = SimpleDateFormat("yyyy-MM-dd")
                val date = Date()
                val current = formatter.format(date)
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.teal_700
                    )
                )
            } else {
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.black
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.black
                    )
                )
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
            }

            calendarDay.text = calendarDateModel.calendarDay
            calendarDate.text = calendarDateModel.calendarDate
            cardView.setOnClickListener {
                listener.invoke(calendarDateModel, adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_calendar_date, parent, false)
        Log.i("prabal","hello")
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }
}
