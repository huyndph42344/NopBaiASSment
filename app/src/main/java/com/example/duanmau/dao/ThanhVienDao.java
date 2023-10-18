package com.example.duanmau.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.model.ThanhVien;

import java.util.ArrayList;

public class ThanhVienDao {
    private DBHelper dbHelper;

    public ThanhVienDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public ArrayList<ThanhVien> getalltv() {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        ArrayList<ThanhVien> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM THANHVIEN", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new ThanhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));

            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insert(String tensach, int tienthue, int maloai) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSach", tensach);
        values.put("GiaThue", tienthue);
        values.put("MaLoai", maloai);
        long check = db.insert("Sach", null, values);
        if (check == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean update(int masach, String tensach, int giathue, int maloai) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenSach", tensach);
        values.put("GiaThue", giathue);
        values.put("MaLoai", maloai);
        long check = db.update("Sach", values, "MaSach = ?", new String[]{String.valueOf(masach)});
        if (check == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int delete(int masach) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from PhieuMuon where MaSach = ?", new String[]{String.valueOf(masach)});
        if (cursor.getCount() != 0) {
            return -1;
        }

        long check = db.delete("Sach", "Masach = ?", new String[]{String.valueOf(masach)});
        if (check == -1) {
            return 0;
        } else {
            return 1;
        }

    }
}

