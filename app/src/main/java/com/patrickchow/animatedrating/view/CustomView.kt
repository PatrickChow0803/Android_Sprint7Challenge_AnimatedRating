package com.patrickchow.animatedrating.view

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.DialogFragment
import com.patrickchow.animatedrating.R
import com.patrickchow.animatedrating.activity.MainActivity
import com.patrickchow.animatedrating.fragment.DialogFragmentAdd
import kotlinx.android.synthetic.main.activity_main.view.*

class CustomView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs){

    constructor(context: Context): this(context, null)

    companion object{
        var myList = mutableListOf<TextView>()
    }

    init{
        //Get the attributes from attrs.xml
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val maximumRating = typedArray.getInt(R.styleable.CustomView_maximumRating, 5)
        val startingRating = typedArray.getInt(R.styleable.CustomView_startingRating, 1)
        val textSize = typedArray.getFloat(R.styleable.CustomView_textSize, 20f)
        typedArray.recycle()

        val name = TextView(context)

        //Creates an EditText to be used to add to the List
        val et_word = EditText(context)
        et_word.textSize = textSize
        et_word.hint = "Enter here"

        val button_add = Button(context)
        button_add.text = "Add"

        button_add.setOnClickListener {
            myList.add(createTextView(et_word.text.toString()))
            val testing = et_word.text.toString()
            Log.i("this", "$testing")
        }

        val image = ImageView(context)
        image.setImageResource(R.drawable.ic_launcher_background)
        image.setOnClickListener {

        }

        //Sets the LinearLayout to be vertical and add the button to create views
        orientation = VERTICAL
        addView(et_word)
        addView(button_add)
        addView(image)
    }

    //Used for testing to add a TextView to the linear layout
    fun createTextView(text: String):TextView{
        val myTextView = TextView(context)
        myTextView.text = text
        return myTextView
    }


}