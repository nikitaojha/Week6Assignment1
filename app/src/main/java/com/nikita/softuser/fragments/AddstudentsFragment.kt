package com.nikita.softuser.fragments

import android.media.Image
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.nikita.softuser.R
import com.nikita.softuser.Storage
import com.nikita.softuser.model.user

class AddstudentsFragment : Fragment() {
    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var etaddress: EditText
    private lateinit var tvgender: TextView
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var radioothers: RadioButton
    private lateinit var btnsave: Button
    var res: Boolean = true
    private var Gender = "Not specified"


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

        radioMale.setOnClickListener {
            Gender = "Male"
        }
        radioFemale.setOnClickListener {
            Gender = "Female"
        }
        radioothers.setOnClickListener {
            Gender = "Others"
        }
        btnsave.setOnClickListener {
            if (validateInput()) {
                var Name = etfullname.text.toString()
                var age = etage.text.toString()
                var Address = etaddress.text.toString()
                Storage().appendStudent(user(Name, age, Address, Gender))
                Toast.makeText(view?.context, "Student Added SuccessFully", Toast.LENGTH_LONG).show()
                etfullname.setText("")
                etaddress.setText("")
                etage.setText("")


            } else {
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun validateInput(): Boolean {
        when {
            TextUtils.isEmpty(etfullname.text) -> {
                etfullname.error = "This field should not be empty"
                etfullname.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etaddress.text) -> {
                etaddress.error = "This field should not be empty"
                etaddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etage.text) -> {
                etage.error = "This field should not be empty"
                etage.requestFocus()
                res = false

            }
        }
        return res
    }
    }
}


