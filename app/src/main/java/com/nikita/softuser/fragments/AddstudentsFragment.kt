package com.nikita.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import com.nikita.softuser.R

class AddstudentsFragment : Fragment() {
    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var etaddress: EditText
    private lateinit var radioMale : RadioButton
    private lateinit var radioFemale : RadioButton
    private lateinit var radioothers : RadioButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addstudents, container, false)
    }
}

