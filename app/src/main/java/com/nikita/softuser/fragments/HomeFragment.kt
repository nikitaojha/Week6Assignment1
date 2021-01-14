package com.nikita.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikita.softuser.R
import com.nikita.softuser.Storage
import com.nikita.softuser.adapter.UserAdapter
import com.nikita.softuser.model.user


class HomeFragment : Fragment() {
    private lateinit var rvStudents: RecyclerView
    private var storage = Storage()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home2, container, false)

        rvStudents = view.findViewById(R.id.rvStudents)
        loadStudentsAdapter()

        return view

    }

    private fun loadStudentsAdapter() {
        val arr = storage.returnStudent()
        val adapter = UserAdapter(arr, this)
        rvStudents.layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
        rvStudents.adapter = adapter
    }
}



