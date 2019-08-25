package com.patrickchow.animatedrating.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.patrickchow.animatedrating.R
import com.patrickchow.animatedrating.fragment.DialogFragmentAdd
import com.patrickchow.animatedrating.view.CustomView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //When the add button is clicked, open up the dialog fragment
        button_add.setOnClickListener {
            val fm = supportFragmentManager
            val myFragment = DialogFragmentAdd()
            myFragment.show(fm, "DOES THIS WORK?")
        }
    }

    
}
