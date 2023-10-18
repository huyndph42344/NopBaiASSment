package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;

public class ThuThuDao {
    private DBHelper dbHelper;

    public ThuThuDao(Context context) {
        dbHelper = new DBHelper(context);


    }

    public boolean chekcLogin(String user, String pass) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM THUTHU WHERE hoTen=? AND mayKhau =?", new String[]{user, pass});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;

        }
    }
    public boolean updateMK(String username, String oldPass, String newPass){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from ThuThu where hoTen = ? and matKhau = ?", new String[]{username,oldPass});
        if (cursor.getCount() > 0){
            ContentValues values = new ContentValues();
            values.put("matKhau", newPass);
            long check = db.update("ThuThu",values,"hoTen = ?",new String[]{username});
            if(check == -1){
                return false;
            }else {
                return true;
            }
        }
        return false;


    }
    public boolean Register(String username, String hoten, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maTT", username);
        values.put("hoTen", hoten);
        values.put("matKhau", password);

        long check = sqLiteDatabase.insert("THUTHU", null, values);
        if (check != 0) {
            return true;
        } else {
            return false;
        }

    }
}
