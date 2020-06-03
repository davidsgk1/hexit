package com.example.hexit.ui.picker.fragment

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hexit.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorListener
import java.io.FileNotFoundException

class ImageUploadFragment : Fragment(), ColorListener {

    private lateinit var addImageButton: FloatingActionButton
    private lateinit var colorPickerView: ColorPickerView
    private lateinit var colorDisplay: LinearLayout
    private lateinit var colorLabel: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_image_upload, container, false)
        setUpViews(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        addImageButton.setOnClickListener { onAddImageClicked() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            try {
                val imageUri = data.data ?: Uri.EMPTY
                val imageStream = context?.contentResolver?.openInputStream(imageUri)
                val selectedImage = BitmapFactory.decodeStream(imageStream)
                val drawable: Drawable =
                    BitmapDrawable(resources, selectedImage)
                colorPickerView.setPaletteDrawable(drawable)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    override fun onColorSelected(color: Int, fromUser: Boolean) {
        colorDisplay.setBackgroundColor(color)
        colorLabel.text = Integer.toHexString(color)
    }

    private fun setUpViews(root: View) = with(root) {
        colorPickerView = findViewById(R.id.custom_image_color_picker)
        colorDisplay = findViewById(R.id.found_color_view)
        colorLabel = findViewById(R.id.color_found_label)
        addImageButton = findViewById(R.id.add_custom_image_button)
    }

    private fun onAddImageClicked() {
        val photoPickerIntent = Intent(Intent.ACTION_PICK).setType("image/*")
        startActivityForResult(photoPickerIntent, 1001)
    }
}