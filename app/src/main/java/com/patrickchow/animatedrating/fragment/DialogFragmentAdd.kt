package com.patrickchow.animatedrating.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.dialog_fragment.view.*
import androidx.fragment.app.FragmentActivity
import com.patrickchow.animatedrating.view.CustomView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_fragment.*


class DialogFragmentAdd : DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //Inflate the xml in order to get the views
        val view = inflater.inflate(com.patrickchow.animatedrating.R.layout.dialog_fragment, container)

        return view
    }
}