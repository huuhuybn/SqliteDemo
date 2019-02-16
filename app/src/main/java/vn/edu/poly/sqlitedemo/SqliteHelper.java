package vn.edu.poly.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {


    public static final String LOP_TABLE = "Lop";

    public static final  String SV_TABLE = "SinhVien";

    public static final  String LOP_ID = "IdLop";
    public static final  String LOP_NAME = "TenLop";
    public static final  String LOP_MAJOR = "Nganh";

    public static final  String SV_ID = "IdSv";
    public static final  String SV_NAME = "TenSv";
    public static final  String SV_HOME = "NoiSinh";
    public static final  String SV_BIRTHDAY = "NgaySinh";
    public static final  String SV_CLASS = "IdLop";


    public String CREATE_LOP = "CREATE TABLE " + LOP_TABLE +
            " (" + LOP_ID + " NVACHAR PRIMARY KEY," + LOP_NAME + " NVACHAR," + LOP_MAJOR + " NVACHAR)";
    public String CREATE_SV = "CREATE TABLE " + SV_TABLE +
            " (" + SV_ID + " NVACHAR PRIMARY KEY, " + SV_NAME + " NVACHAR, " + SV_HOME + " NVACHAR, " + SV_BIRTHDAY + " NVACHAR, " + SV_CLASS + " NVACHAR)";


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
