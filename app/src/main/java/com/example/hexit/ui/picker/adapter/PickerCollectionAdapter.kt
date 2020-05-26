package com.example.hexit.ui.picker.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hexit.ui.picker.fragment.BarSliderFragment
import com.example.hexit.ui.picker.fragment.CirclePickerFragment
import com.example.hexit.ui.picker.fragment.ImageUploadFragment

class PickerCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> buildCirclePickerFragment()
        1 -> buildBarSliderFragment()
        2 -> buildCustomImageFragment()
        else -> CirclePickerFragment() //TODO: Address with an error screen perhaps?
    }

    private fun buildCirclePickerFragment(): Fragment {
        val fragment = CirclePickerFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_OBJECT, CIRCLE_PICKER_TITLE)
        }
        return fragment
    }

    private fun buildBarSliderFragment(): Fragment {
        val fragment = BarSliderFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_OBJECT, BAR_SLIDER_TITLE)
        }
        return fragment
    }

    private fun buildCustomImageFragment(): Fragment {
        val fragment = ImageUploadFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_OBJECT, CUSTOM_IMAGE_TITLE)
        }
        return fragment
    }

    companion object {
        const val ARG_OBJECT = "object"
        const val CIRCLE_PICKER_TITLE = "Circle Picker"
        const val BAR_SLIDER_TITLE = "RGB Slider"
        const val CUSTOM_IMAGE_TITLE = "Custom Image"
    }
}