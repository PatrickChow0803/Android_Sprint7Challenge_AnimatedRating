package com.patrickchow.animatedrating.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.patrickchow.animatedrating.R
import com.patrickchow.animatedrating.fragment.DialogFragmentAdd
import com.patrickchow.animatedrating.view.CustomView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add a textview into the list of words for testing
        val test = TextView(this)
        CustomView.myList.add(test)

        //When the add button is clicked, open up the dialog fragment
        button_add.setOnClickListener {
            val fm = supportFragmentManager
            val myFragment = DialogFragmentAdd()
            myFragment.show(fm, "DOES THIS WORK?")

            counter++
        }

        btn_refresh.setOnClickListener {

            val word = CustomView.myList[counter]
            ll_list_of_words.addView(word)

            val rating = "Rating is  ${CustomView.ratingValue}"
            val ratingView = TextView(this)
            ratingView.text = rating.toString()
            ll_list_of_words.addView(ratingView)
            super.onPostResume()
        }
    }
}



