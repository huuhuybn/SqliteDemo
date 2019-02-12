package vn.edu.poly.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {


    public String CREATE_LOP = "CREATE TABLE Lop (IdLop NVACHAR PRIMARY KEY,TenLop NVACHAR,Nganh NVACHAR)";
    public String CREATE_SV = "CREATE TABLE Sinhvien (IdSv NVACHAR PRIMARY KEY, TenSv NVACHAR, NoiSinh NVACHAR, NgaySinh NVACHAR, IdLop NVACHAR)";


    public SqliteHelper(Context context) {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // tao bang lop
        sqLiteDatabase.execSQL(CREATE_LOP);
        // tao bang sinh vien
        sqLiteDatabase.execSQL(CREATE_SV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
