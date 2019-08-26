package com.patrickchow.animatedrating.view

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
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
        var ratingValue = 5
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

        val image1 = ImageView(context)
        animateVectorDrawable(R.drawable.avd_anim, image1)

        val image2 = ImageView(context)
        animateVectorDrawable(R.drawable.avd_anim, image2)

        val image3 = ImageView(context)
        animateVectorDrawable(R.drawable.avd_anim, image3)

        val image4 = ImageView(context)
        animateVectorDrawable(R.drawable.avd_anim, image4)

        val image5 = ImageView(context)
        animateVectorDrawable(R.drawable.avd_anim, image5)

        image1.setOnClickListener {
            animateVectorDrawable(R.drawable.avd_anim, image1)
            animateVectorDrawable(R.drawable.avd_anim_empty, image2)
            animateVectorDrawable(R.drawable.avd_anim_empty, image3)
            animateVectorDrawable(R.drawable.avd_anim_empty, image4)
            animateVectorDrawable(R.drawable.avd_anim_empty, image5)

            ratingValue = 1
        }

        image2.setOnClickListener {
            animateVectorDrawable(R.drawable.avd_anim, image1)
            animateVectorDrawable(R.drawable.avd_anim, image2)
            animateVectorDrawable(R.drawable.avd_anim_empty, image3)
            animateVectorDrawable(R.drawable.avd_anim_empty, image4)
            animateVectorDrawable(R.drawable.avd_anim_empty, image5)

            ratingValue = 2
        }

        image3.setOnClickListener {
            animateVectorDrawable(R.drawable.avd_anim, image1)
            animateVectorDrawable(R.drawable.avd_anim, image2)
            animateVectorDrawable(R.drawable.avd_anim, image3)
            animateVectorDrawable(R.drawable.avd_anim_empty, image4)
            animateVectorDrawable(R.drawable.avd_anim_empty, image5)

            ratingValue = 3
        }

        image4.setOnClickListener {
            animateVectorDrawable(R.drawable.avd_anim, image1)
            animateVectorDrawable(R.drawable.avd_anim, image2)
            animateVectorDrawable(R.drawable.avd_anim, image3)
            animateVectorDrawable(R.drawable.avd_anim, image4)
            animateVectorDrawable(R.drawable.avd_anim_empty, image5)

            ratingValue = 4
        }

        image5.setOnClickListener {
            animateVectorDrawable(R.drawable.avd_anim, image1)
            animateVectorDrawable(R.drawable.avd_anim, image2)
            animateVectorDrawable(R.drawable.avd_anim, image3)
            animateVectorDrawable(R.drawable.avd_anim, image4)
            animateVectorDrawable(R.drawable.avd_anim, image5)

            ratingValue = 5
        }

        val ll_test = LinearLayout(context)
        ll_test.layoutParams

        //Sets the LinearLayout to be vertical and add the button to create views
        orientation = VERTICAL
        addView(et_word)
        addView(button_add)
        addView(image1)
        addView(image2)
        addView(image3)
        addView(image4)
        addView(image5)
    }

    //Used for testing to add a TextView to the linear layout
    fun createTextView(text: String):TextView{
        val myTextView = TextView(context)
        myTextView.text = text
        return myTextView
    }

    //Animates the animated vector drawable
    private fun animateVectorDrawable(id: Int, view: ImageView){
        val animatedVectorDrawable = ContextCompat.getDrawable(context, id)
        view.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as Animatable).start()
    }


}