package pe.edu.utp.sm2test.Models

import android.os.Parcel
import android.os.Parcelable


data class Tags(
    val tagID: Int?,
    val nameTag: String?,
    val imageTag: Int?
) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(tagID)
        parcel.writeString(nameTag)
        parcel.writeValue(imageTag)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tags> {
        override fun createFromParcel(parcel: Parcel): Tags {
            return Tags(parcel)
        }

        override fun newArray(size: Int): Array<Tags?> {
            return arrayOfNulls(size)
        }
    }


}