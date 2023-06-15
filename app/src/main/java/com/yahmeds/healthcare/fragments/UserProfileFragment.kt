package com.yahmeds.healthcare.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.databinding.UserProfileFragmentBinding

class UserProfileFragment : Fragment() {

    private lateinit var userProfileBinding: UserProfileFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.user_profile_fragment, container, false);
        return userProfileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}