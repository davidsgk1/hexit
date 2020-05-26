package com.example.hexit.ui.picker.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hexit.R
import com.example.hexit.ui.picker.adapter.PickerCollectionAdapter.Companion.ARG_OBJECT

class BarSliderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bar_slider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}