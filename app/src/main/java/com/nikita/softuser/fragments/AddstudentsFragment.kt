package com.nikita.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.nikita.softuser.R

class AddstudentsFragment : Fragment() {
    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var etaddress: EditText
    private lateinit var tvgender: TextView
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var radioothers: RadioButton
    private lateinit var btnsave: Button



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_addstudents, container, false)
        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        etaddress = view.findViewById(R.id.etaddress)
        tvgender = view.findViewById(R.id.tvgender)
        radioMale = view.findViewById(R.id.radioMale)
        radioFemale = view.findViewById(R.id.radioFemale)
        radioothers = view.findViewById(R.id.radioOthers)
        btnsave = view.findViewById(R.id.btnsave)



    }
}


