package com.example.myapplicationdrawer

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(private val context: Context):
    SQLiteOpenHelper(context,DATABASE_NAME,null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME="UserDatabase.db"
        private const val DATABASE_VERSION=1
        private const val TABLE_NAME="data"
        private const val COLOUMN_ID="id"
        private const val COLOUMN_USERNAME="username"
        private const val COLOUMN_PASSWORD="password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createtablequery=("CREATE TABLE $TABLE_NAME("+
                "$COLOUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "$COLOUMN_USERNAME TEXT,"+
                "$COLOUMN_PASSWORD TEXT)")
        if (db != null) {
            db.execSQL(createtablequery)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val droptablequery="DROP TABLE IF EXISTS $TABLE_NAME"
        if (db != null) {
            db.execSQL(droptablequery)
        }
        onCreate(db)
    }
    fun insertUser(username:String,password:String): Long {
        val values=ContentValues().apply {
            put(COLOUMN_USERNAME,username)
            put(COLOUMN_PASSWORD,password)
        }
        val db=writableDatabase
        return db.insert(TABLE_NAME,null,values)

    }
    fun readUser(username:String,password:String):Boolean{
        val db=readableDatabase
        val selection="$COLOUMN_USERNAME=? AND $COLOUMN_PASSWORD=?"
        val selectionArgs= arrayOf(username,password)
        val cursor=db.query(TABLE_NAME,null,selection,selectionArgs,null,null,null)
        val userExist= cursor.count>0
        cursor.close()
        return userExist
    }
    fun getUserDetails(username: String): Cursor {
        val db = readableDatabase
        val selection = "$COLOUMN_USERNAME=?"
        val selectionArgs = arrayOf(username)
        return db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null)
    }

}