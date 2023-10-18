package com.example.duanmau.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duanmau.database.DBHelper;
import com.example.duanmau.model.Sach;

import java.util.ArrayList;

public class ThongKeDao {

    private DBHelper dbHelper;
    public ThongKeDao(Context context){
        dbHelper = new DBHelper(context);
    }
    public ArrayList<Sach> getTop10(){
        ArrayList<Sach> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SACH.maSach, SACH.tenSach, COUNT(*) AS soLuong\n" +
                "FROM SACH\n" +
                "JOIN PHIEUMUON ON SACH.maSach = PHIEUMUON.maSach\n" +
                "GROUP BY SACH.maSach, SACH.tenSach\n" +
                "ORDER BY soLuong DESC\n" +
                "LIMIT 10;\n",null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new Sach(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return list;

    }
    public int getDoanhThu(String Start, String End){
        Start = Start.replace("/","");
        End = End.replace("/","");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(tienThue) FROM PHIEUMUON WHERE substr(ngay,7) || substr(ngay,4,2) || substr(ngay,1,2) BETWEEN ? and ?",new String[]{Start,End});
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
        return 0;
    }
}
