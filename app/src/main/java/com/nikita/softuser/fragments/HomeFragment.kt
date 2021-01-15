package com.nikita.softuser.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikita.softuser.Database
import com.nikita.softuser.R
import com.nikita.softuser.adapter.UserAdapter
import com.nikita.softuser.model.user


class HomeFragment : Fragment() {
    private lateinit var rvStudents: RecyclerView
    private var database= Database()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home2, container, false)
        rvStudents=view.findViewById(R.id.rvStudents)
        loaduserAdapter()
        return view
    }

    private fun loaduserAdapter(){
        val array = database.returnuser()
        val adapter=UserAdapter(array,this)
        rvStudents.layoutManager=LinearLayoutManager(view?.context,LinearLayoutManager.VERTICAL,false)
        rvStudents.adapter=adapter
    }



}
