package com.nikita.softuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nikita.softuser.Database
import com.nikita.softuser.R
import com.nikita.softuser.fragments.HomeFragment
import com.nikita.softuser.model.user
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter (
        val lstUsers : ArrayList<user>,
        val context: HomeFragment

        ) : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var database= Database()

    class  UserViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imgProfile: CircleImageView
        val imgdelete: ImageView
        val tvName : TextView
        val tvage : TextView
        val tvaddress : TextView
        val tvgender : TextView

        init {
            imgdelete = view.findViewById(R.id.imgdelete)
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvage = view.findViewById(R.id.tvage)
            tvaddress = view.findViewById(R.id.tvaddress)
            tvgender  = view.findViewById(R.id.tvgender)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.studentprofile,parent,false)
        return UserViewHolder(view)
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val User=lstUsers[position]
        holder.tvName.text=User.Name
        holder.tvage.text= User.Age.toString()
        holder.tvaddress.text=User.Address
        holder.tvgender.text=User.Gender

        holder.imgdelete.setOnClickListener {
            database.deleteuser(User)
            notifyItemRemoved(position)
        }

        Glide.with(context)
                .load(User.userImage)
                .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return lstUsers.size
    }
}