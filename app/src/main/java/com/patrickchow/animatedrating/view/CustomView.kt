package com.patrickchow.animatedrating.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.patrickchow.animatedrating.R
import com.patrickchow.animatedrating.activity.MainActivity
import com.patrickchow.animatedrating.fragment.DialogFragmentAdd

class CustomView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs){

    constructor(context: Context): this(context, null)

    init{
        //Get the attributes from attrs.xml
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val textSize = typedArray.getDimension(R.styleable.CustomView_textSize, 16f)
        typedArray.recycle()

        //Give the button attributes and gives it an onClickListener to input text views into the LinearLayout
        val buttonParams = Button(context)
        buttonParams.text = "ADD"
        buttonParams.textSize = textSize
        buttonParams.textAlignment = Button.TEXT_ALIGNMENT_CENTER
        buttonParams.setOnClickListener {

            addView(createTextView("It Worked"))
        }

        //Sets the LinearLayout to be vertical and add the button to create views
        orientation = VERTICAL
        addView(buttonParams)
    }

    //Used for testing to add a TextView to the linear layout
    fun createTextView(text: String):TextView{
        val myTextView = TextView(context)
        myTextView.text = text
        return myTextView
    }


}