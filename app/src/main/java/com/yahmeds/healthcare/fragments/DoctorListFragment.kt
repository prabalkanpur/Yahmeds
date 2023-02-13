package com.yahmeds.healthcare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.adapters.DoctorListAdapter
import com.yahmeds.healthcare.adapters.HospitalListAdapter
import com.yahmeds.healthcare.adapters.ImageSliderAdapter
import com.yahmeds.healthcare.dataclass.HospitalListModel
import me.relex.circleindicator.CircleIndicator

class DoctorListFragment:Fragment() {
    lateinit var viewPagerAdapter: ImageSliderAdapter
    private lateinit var card_hospital: CardView
    lateinit var indicator: CircleIndicator
    lateinit var viewpager: ViewPager
    private val images = arrayOf<Int>(
        com.yahmeds.healthcare.R.drawable.image1,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.yahmeds.healthcare.R.layout.doctor_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //

        viewpager = view.findViewById(R.id.viewpager)
        viewPagerAdapter = ImageSliderAdapter(requireContext(), images)
        viewpager.adapter = viewPagerAdapter
        indicator = view.findViewById(R.id.indicator) as CircleIndicator
        indicator.setViewPager(viewpager)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recycle_hospital_list)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<HospitalListModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(HospitalListModel(R.drawable.doctors))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = DoctorListAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

    }
}