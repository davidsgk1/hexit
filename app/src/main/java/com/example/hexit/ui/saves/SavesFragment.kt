package com.example.hexit.ui.saves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hexit.R

class SavesFragment : Fragment() {

    private lateinit var savesPresenter: SavesPresenter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        savesPresenter =
                ViewModelProviders.of(this).get(SavesPresenter::class.java)
        val root = inflater.inflate(R.layout.fragment_saves, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        savesPresenter.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
