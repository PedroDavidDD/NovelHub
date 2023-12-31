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
    val qualification: Float,
    val synopsis: String?,
    var fechaEstreno: Date?,
    val readingContent: String?
) : Parcelable {

    // Constructor sin argumentos requerido por Firebase
    constructor() : this(
        id = 0,
        title = null,
        chapter = null,
        day = null,
        img = null,
        tagName = null,
        nameBook = null,
        coverBook = null,
        authorBook = null,
        qualification = 0f,
        synopsis = null,
        fechaEstreno = null,
        readingContent = null
    )


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
        parcel.readFloat(),
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
        parcel.writeFloat(qualification)
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