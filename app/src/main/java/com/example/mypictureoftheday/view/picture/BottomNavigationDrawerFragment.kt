package com.example.mypictureoftheday.view.picture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mypictureoftheday.R
import com.example.mypictureoftheday.databinding.BottomNavigationLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private var _binding: BottomNavigationLayoutBinding? = null
    val binding: BottomNavigationLayoutBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_one -> {
                    Log.d("@@@", "На экран 1")
                }
                R.id.navigation_two -> {
                    Log.d("@@@", "На экран 2")
                }
            }
            dismiss()
            true
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BottomNavigationDrawerFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}