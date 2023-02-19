package com.yahmeds.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import com.yahmeds.healthcare.fragments.HospitalIntroductionFragment
import com.yahmeds.healthcare.fragments.HospitalRoonBookingFragment
import com.yahmeds.healthcare.fragments.HospitalSpecialitiesFragment

class HospitalDetailActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var frameLayout: FrameLayout? = null
    var fragment: Fragment? = null
    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_detail)


        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        frameLayout = findViewById<FrameLayout>(R.id.frameLayout)

        fragment = HospitalIntroductionFragment()
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.frameLayout, fragment as HospitalIntroductionFragment)
        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction!!.commit()
        //adding listener for tab select
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // creating cases for fragment
                when (tab.position) {
                    0 -> fragment = HospitalIntroductionFragment()
                    1 -> fragment = HospitalSpecialitiesFragment()
                    2 -> fragment = HospitalRoonBookingFragment()
                }
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(R.id.frameLayout, fragment!!)
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }
}
