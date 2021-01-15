package com.nikita.softuser.fragments

import android.media.Image
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.nikita.softuser.Database
import com.nikita.softuser.R
import com.nikita.softuser.model.user

class AddstudentsFragment : Fragment() {

    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var etaddress: EditText
    private lateinit var etImage: EditText
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var radioothers: RadioButton
    private lateinit var btnsave: Button
    private var gender =""


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_addstudents, container, false)
        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        etaddress = view.findViewById(R.id.etaddress)
        radioMale = view.findViewById(R.id.radioMale)
        radioFemale = view.findViewById(R.id.radioFemale)
        radioothers = view.findViewById(R.id.radioOthers)
        btnsave = view.findViewById(R.id.btnsave)

        radioMale.setOnClickListener {
            gender = "Male"
        }
        radioFemale.setOnClickListener {
            gender = "Female"
        }
        radioothers.setOnClickListener {
            gender = "Others"
        }
        btnsave.setOnClickListener {
            if (validateInput()) {
                var fullname = etfullname.text.toString()
                var ProfileImage = etImage.text.toString()
                var age = etage.text.toString()
                var address = etaddress.text.toString()
                Database().appenduser(user(fullname, ProfileImage, age, address, gender))
                Toast.makeText(view?.context, "Student Added", Toast.LENGTH_LONG).show()
                etfullname.setText("")
                etImage.setText("")
                etaddress.setText("")
                etage.setText("")
                etfullname.requestFocus()

            } else {
                Toast.makeText(view?.context, "Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

    private fun validateInput(): Boolean {
        var res : Boolean = true
        when {
            TextUtils.isEmpty(etfullname.text) -> {
                etfullname.error = "Please enter your full name"
                etfullname.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etImage.text) -> {
                etImage.error = "This field should not be empty"
                etImage.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etaddress.text) -> {
                etaddress.error = "Please enter your address"
                etaddress.requestFocus()
                res = false
            }
            TextUtils.isEmpty(etage.text) -> {
                etage.error = "please enter your age"
                etage.requestFocus()
                res = false
            }
        }

        return res

    }
}



