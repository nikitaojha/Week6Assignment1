package com.nikita.softuser

import com.nikita.softuser.model.user

private  var listusers= arrayListOf<user>()
var loggedIn:user?=null
class Database {
    fun appenduser(User: user){
        listusers.add(User)
        println(listusers.size)
    }

    fun returnuser():ArrayList<user>{
        return listusers
    }

    fun deleteuser(User: user){
        listusers.remove(User)
    }

    public fun setLoggegIn(id: user?){
        println(id)
        loggedIn=id
    }

    public fun getloggedIn():user?{
        return loggedIn
    }
}



