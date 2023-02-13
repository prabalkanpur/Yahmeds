package com.yahmeds.healthcare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.adapters.ImageSliderAdapter
import com.yahmeds.healthcare.adapters.offerAdapter
import me.relex.circleindicator.CircleIndicator


class DashBoardFragment : Fragment() {
    lateinit var viewPagerAdapter: ImageSliderAdapter
    private lateinit var card_hospital:CardView
    private lateinit var card_doctor:CardView
    lateinit var indicator: CircleIndicator
    lateinit var viewpager: ViewPager
    private val images = arrayOf<Int>(
        com.yahmeds.healthcare.R.drawable.image1,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1
    )
    lateinit var offerAdapter: offerAdapter
    lateinit var indicator2: CircleIndicator
    lateinit var viewpager2: ViewPager
    private val images2 = arrayOf<Int>(
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.btm_header,
        com.yahmeds.healthcare.R.drawable.image1
    )



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.yahmeds.healthcare.R.layout.dashboard_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card_hospital = view.findViewById(R.id.card_hospital)
        card_doctor = view.findViewById(R.id.card_doctor)
        viewpager = view.findViewById(R.id.viewpager)
        viewPagerAdapter = ImageSliderAdapter(requireContext(), images)
        viewpager.adapter = viewPagerAdapter
        indicator = view.findViewById(R.id.indicator) as CircleIndicator
        indicator.setViewPager(viewpager)
        viewpager2 = view.findViewById(R.id.viewpager2)
        offerAdapter = offerAdapter(requireContext(), images2)
        viewpager2.adapter = offerAdapter
        indicator2 = view.findViewById(R.id.indicator2) as CircleIndicator
        indicator2.setViewPager(viewpager2)
        card_doctor.setOnClickListener(View.OnClickListener {

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.flFragment, DoctorListFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        card_hospital.setOnClickListener(View.OnClickListener {

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.flFragment, HospitalFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

    }
}