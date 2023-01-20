package com.yahmeds.healthcare

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.yahmeds.healthcare.adapters.ImageSliderAdapter
import com.yahmeds.healthcare.adapters.offerAdapter
import com.yahmeds.healthcare.fragments.DashBoardFragment
import me.relex.circleindicator.CircleIndicator

class DashBoardActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        val firstFragment = DashBoardFragment()
        setCurrentFragment(firstFragment)
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}