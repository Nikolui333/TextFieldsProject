package com.example.textfieldsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.textfieldsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnKeyListener {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val items = listOf("Rostov-on-Don", "New York", "Los Angeles", "Tokyo")

        val adapter = ArrayAdapter(this, R.layout.item, items)

        binding?.autoComplete?.setAdapter(adapter)

        binding?.add?.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        binding?.result?.text = binding?.autoComplete?.text
        binding?.autoComplete?.text?.clear()
    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {
            R.id.autoComplete -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.result?.text = binding?.autoComplete?.text
                    binding?.autoComplete?.setText("")
                    return true
                }

            }
        }

        return false
    }
}