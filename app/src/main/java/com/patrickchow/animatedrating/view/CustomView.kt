package com.patrickchow.animatedrating.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.patrickchow.animatedrating.R
import com.patrickchow.animatedrating.activity.MainActivity
import com.patrickchow.animatedrating.fragment.DialogFragmentAdd
import kotlinx.android.synthetic.main.activity_main.view.*

class CustomView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs){

    constructor(context: Context): this(context, null)

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

        //Give the button attributes and gives it an onClickListener to input text views into the LinearLayout
        val buttonParams = Button(context)
        buttonParams.text = "ADD"
        buttonParams.textAlignment = Button.TEXT_ALIGNMENT_CENTER
        buttonParams.setOnClickListener {
            ll_list_of_words.addView(createTextView("It Worked"))
        }

        //Sets the LinearLayout to be vertical and add the button to create views
        orientation = VERTICAL
        addView(et_word)
        addView(buttonParams)
    }

    //Used for testing to add a TextView to the linear layout
    fun createTextView(text: String):TextView{
        val myTextView = TextView(context)
        myTextView.text = text
        return myTextView
    }


}