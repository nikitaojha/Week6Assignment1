package com.nikita.softuser.model

import android.os.Parcel
import android.os.Parcelable

data class user(
         val  userId: Int?=null,
         val Name: String?=null,
         val Image: String?=null,
         val Address: String?=null,
         val Gender: String?=null,
         val age:String?=null
 ): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()


    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(Name)
        parcel.writeString(Image)
        parcel.writeString(Address)
        parcel.writeString(Gender)
        parcel.writeString(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<user> {
        override fun createFromParcel(parcel: Parcel): user {
            return user(parcel)
        }

        override fun newArray(size: Int): Array<user?> {
            return arrayOfNulls(size)
        }
    }
}
