package com.yahmeds.healthcare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HospitalListFragment :Fragment() {

   /* fun newInstance(): {
        val args = Bundle()

        val fragment = ()
        fragment.arguments = args
        return fragment
    }*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.yahmeds.healthcare.R.layout.hospital_introduction_fragment, container, false)
    }
}