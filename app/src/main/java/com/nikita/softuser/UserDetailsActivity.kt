package com.nikita.softuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nikita.softuser.model.user
import de.hdodenhof.circleimageview.CircleImageView

class UserDetailsActivity : AppCompatActivity() {
   private lateinit var imgProfile: CircleImageView
    private lateinit var tvuserName: TextView
    private lateinit var tvuserage: TextView
    private lateinit var tvuseraddress: TextView
    private lateinit var tvusergender: TextView
    private lateinit var delete: ImageView
    private lateinit var tvuserid: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        imgProfile=findViewById(R.id.imgProfile)
        tvuserName=findViewById(R.id.tvuserName)
        tvuserage=findViewById(R.id.tvuserage)
        tvuseraddress=findViewById(R.id.tvuseraddress)
        tvusergender=findViewById(R.id.tvusergender)
        delete=findViewById(R.id.delete)
        tvuserid=findViewById(R.id.tvuserid)

        val intent=intent.getParcelableExtra<user>("profile")
        if (intent!=null){
            val profileId = intent.userId
            val Name=intent.Name
            val Address=intent.Address
            val Age=intent.age
            val Gender=intent.Gender
            val Image=intent.Image

            tvuserName.text=Name
            tvuserage.text=Age.toString()
            tvuseraddress.text=Address
            tvusergender.text=Gender
            tvuserid.text=profileId.toString()
            Glide.with(this@UserDetailsActivity)
                .load(Image)
                .into(imgProfile)


        }
    }
}