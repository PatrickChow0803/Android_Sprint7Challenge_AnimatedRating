package com.patrickchow.animatedrating.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.patrickchow.animatedrating.R

class CustomView (context: Context, attrs: AttributeSet?): LinearLayout(context, attrs){

    constructor(context: Context): this(context, null)



    init{

        //Get the attributes from attrs.xml
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView)
        val textSize = typedArray.getDimension(R.styleable.CustomView_textSize, 16f)
        val textWeight = typedArray.getFloat(R.styleable.CustomView_layout_weight, 2f)
        val listItems = typedArray.getTextArray(R.styleable.CustomView_android_entries)
        typedArray.recycle()

        val buttonLayoutParams = LayoutParams(0, LayoutParams.WRAP_CONTENT, textWeight)

        val myTextView = TextView(context)
        myTextView.text = "HELLO"

        val buttonParams = Button(context)
        buttonParams.text = "ADD"
        buttonParams.textSize = textSize
        buttonParams.textAlignment = Button.TEXT_ALIGNMENT_CENTER
        buttonParams.setOnClickListener {
            myTextView.text = "It worked"
        }



        //Sets the LinearLayout to be verical and add in the views
        orientation = VERTICAL
        addView(buttonParams)
        addView(myTextView)
    }

}