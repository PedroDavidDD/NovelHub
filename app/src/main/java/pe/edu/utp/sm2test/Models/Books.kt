package pe.edu.utp.sm2test.Models

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Books(
    val id: Int,
    val title: String?,
    val chapter: String?,
    val day: String?,
    val img: Int?,
    val tagName: String?,
    val nameBook: String?,
    val coverBook: Int?,
    val authorBook: String?,
    val qualification: Double,
    val synopsis: String?,
    val fechaEstreno: Date?,
    val readingContent: String?
) : Parcelable {



    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        Date(parcel.readLong()),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(chapter)
        parcel.writeString(day)
        parcel.writeValue(img)
        parcel.writeValue(tagName)
        parcel.writeString(nameBook)
        parcel.writeValue(coverBook)
        parcel.writeString(authorBook)
        parcel.writeDouble(qualification)
        parcel.writeString(synopsis)
        parcel.writeLong(fechaEstreno?.time ?: 0)
        parcel.writeString(readingContent)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Books> {
        override fun createFromParcel(parcel: Parcel): Books {
            return Books(parcel)
        }

        override fun newArray(size: Int): Array<Books?> {
            return arrayOfNulls(size)
        }
    }


}