package com.example.hexit.ui.picker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hexit.R
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener

class PickerFragment : Fragment(), ColorListener {

    private lateinit var pickerPresenter: PickerPresenter
    private lateinit var colorPickerView: ColorPickerView
    private lateinit var colorDisplay: LinearLayout
    private lateinit var colorLabel: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pickerPresenter =
            ViewModelProviders.of(this).get(PickerPresenter::class.java)
        val root = inflater.inflate(R.layout.fragment_picker, container, false)
        setUpViews(root)
        colorPickerView.colorListener = this
        return root
    }

    override fun onColorSelected(color: Int, fromUser: Boolean) {
        colorDisplay.setBackgroundColor(color)
        colorLabel.text = Integer.toHexString(color)
    }

    private fun setUpViews(root: View) = with(root) {
        colorPickerView = findViewById(R.id.color_picker_view)
        colorDisplay = findViewById(R.id.found_color_view)
        colorLabel = findViewById(R.id.color_found_label)
    }
}
