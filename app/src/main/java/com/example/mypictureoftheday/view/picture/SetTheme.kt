package com.example.mypictureoftheday.view.picture

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mypictureoftheday.R
import com.example.mypictureoftheday.databinding.FragmentPictureOfTheDayBinding
import com.example.mypictureoftheday.view.MainActivity

class SetTheme : Fragment(), View.OnClickListener {

    private lateinit var parentActivity: MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentActivity = (context as MainActivity)
    }

    var _binding: FragmentPictureOfTheDayBinding? = null
    val binding: FragmentPictureOfTheDayBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPictureOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMainTheme.setOnClickListener(this)
        binding.btnThemeGreen.setOnClickListener(this)
        binding.btnThemeRed.setOnClickListener(this)

        when (parentActivity.getCurrentTheme()) {
            1 -> binding.radioGroup.check(R.id.btnMainTheme)
            2 -> binding.radioGroup.check(R.id.btnThemeGreen)
            3 -> binding.radioGroup.check(R.id.btnThemeRed)

        }

    }

    override fun onClick(v: View?) {
        when (v.id) {
            R.id.main_theme -> {
                parentActivity.setCurrentTheme(MainTheme)
                parentActivity.recreate() // применяем для всей активити и для всех дочерних фрагментов
            }
            R.id.green_theme -> {
                parentActivity.setCurrentTheme(MyGreenTheme)
                parentActivity.recreate()
            }
            R.id.red_theme -> {
                parentActivity.setCurrentTheme(MyRedTheme)
                parentActivity.recreate()
            }
        }
    }
}