package pe.edu.utp.sm2test.conexionBD

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "UserDB"
        private const val TABLE_NAME = "usuarios"
        private const val KEY_ID = "id"
        private const val KEY_USERNAME = "NombreUsuario"
        private const val KEY_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_NAME ($KEY_ID integer primary key autoincrement, $KEY_USERNAME text not null, $KEY_PASSWORD text not null)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(username: String, password: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_USERNAME, username)
        values.put(KEY_PASSWORD, password)
        val insertedId = db.insert(TABLE_NAME, null, values)
        db.close()
        return insertedId
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $KEY_USERNAME = ? AND $KEY_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(username, password))
        val count = cursor.count
        cursor.close()
        return count > 0
    }
}