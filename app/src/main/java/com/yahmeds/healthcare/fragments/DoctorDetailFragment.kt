package com.yahmeds.healthcare.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.adapters.CalendarAdapter
import com.yahmeds.healthcare.dataclass.CalendarDateModel
import com.yahmeds.healthcare.utils.HorizontalItemDecoration
import java.text.SimpleDateFormat
import java.util.*

class DoctorDetailFragment : Fragment() {
    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: CalendarAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()
    private lateinit var recyclerView:RecyclerView
    private lateinit var tv_date_month:TextView
    private lateinit var iv_calendar_next:ImageView
    private lateinit var iv_calendar_previous:ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.yahmeds.healthcare.R.layout.doctor_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iv_calendar_next = view.findViewById(R.id.iv_calendar_next)
        iv_calendar_previous = view.findViewById(R.id.iv_calendar_previous)
        tv_date_month = view.findViewById(R.id.tv_date_month)
        recyclerView = view.findViewById(R.id.recyclerView)
        val mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        setUpAdapter()
        setUpClickListener()
        setUpCalendar()
    }
    /**
     * Set up click listener
     */
    private fun setUpClickListener() {
        iv_calendar_next.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }
        iv_calendar_previous.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar()
            else
                setUpCalendar()
        }
    }


    /**
     * Setting up adapter for recyclerview
     */
    private fun setUpAdapter() {
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.single_calendar_margin)
        recyclerView.addItemDecoration(HorizontalItemDecoration(spacingInPixels))
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        adapter = CalendarAdapter { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)
        }
        recyclerView.adapter = adapter
    }

    /**
     * Function to setup calendar for every month
     */
    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()
        tv_date_month.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setData(calendarList)
        Log.i("prabal","hello_hello")
    }
}