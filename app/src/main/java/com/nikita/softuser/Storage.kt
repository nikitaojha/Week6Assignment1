package com.nikita.softuser

import android.widget.Toast
import com.nikita.softuser.model.user



private var listStudent = arrayListOf<user>()
var loggedIn: user? = null
class Storage {
    fun appendStudent(student: user){
        listStudent.add(student)
        println(listStudent.size)
    }
    fun returnStudent():ArrayList<user>{
        return listStudent
    }
    fun deleteStudent(student: user){
        listStudent.remove(student)
    }
    public fun setLoggedIn(id: user){
        println(id)
        loggedIn = id
    }
    public fun getLoggedIn(): user? {
        return loggedIn
    }
}