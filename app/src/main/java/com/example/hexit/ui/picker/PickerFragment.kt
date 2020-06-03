package com.example.hexit.ui.picker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.hexit.R
import com.example.hexit.ui.picker.adapter.PickerCollectionAdapter
import com.example.hexit.ui.picker.adapter.PickerCollectionAdapter.Companion.CIRCLE_PICKER_TITLE
import com.example.hexit.ui.picker.adapter.PickerCollectionAdapter.Companion.CUSTOM_IMAGE_TITLE
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PickerFragment : Fragment() {

    private lateinit var pickerCollectionAdapter: PickerCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pickerCollectionAdapter = PickerCollectionAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = pickerCollectionAdapter
        viewPager.reduceDragSensitivity()
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = findTabTitleByPosition(position)
        }.attach()
    }

    private fun findTabTitleByPosition(position: Int) = when (position) {
        0 -> CIRCLE_PICKER_TITLE
        1 -> CUSTOM_IMAGE_TITLE
        else -> "Error Finding Page!"
    }

    private fun ViewPager2.reduceDragSensitivity() {
        val recyclerViewField = ViewPager2::class.java.getDeclaredField("mRecyclerView")
        recyclerViewField.isAccessible = true
        val recyclerView = recyclerViewField.get(this) as RecyclerView

        val touchSlopField = RecyclerView::class.java.getDeclaredField("mTouchSlop")
        touchSlopField.isAccessible = true
        val touchSlop = touchSlopField.get(recyclerView) as Int
        touchSlopField.set(recyclerView, touchSlop * 12)
    }
}
