package vn.edu.poly.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_BIRTHDAY;
import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_CLASS;
import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_HOME;
import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_ID;
import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_NAME;
import static vn.edu.poly.sqlitedemo.SqliteHelper.SV_TABLE;

public class StudentDAO {


    private SqliteHelper sqliteHelper;


    public StudentDAO(Context context){
        sqliteHelper = new SqliteHelper(context);
    }


    public List<Student> getAllStudents() {

        String query_all = "SELECT * FROM " + SV_TABLE;

        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();


        // doc du lieu vao luu vao bien con tro Cursor
        Cursor cursor = sqLiteDatabase.rawQuery(query_all, null);

        List<Student> array_students = new ArrayList<>();

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                // neu doc het du lieu thi thoai khoi vong while
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    String student_id = cursor.getString(cursor.getColumnIndex(SV_ID));
                    String student_name = cursor.getString(cursor.getColumnIndex(SV_NAME));
                    String student_hometown = cursor.getString(cursor.getColumnIndex(SV_HOME));
                    String student_birthday = cursor.getString(cursor.getColumnIndex(SV_BIRTHDAY));
                    String student_class_id = cursor.getString(cursor.getColumnIndex(SV_CLASS));

                    Student student = new Student();
                    student.student_id = student_id;
                    student.student_name = student_name;
                    student.student_hometown = student_hometown;
                    student.student_birthday = student_birthday;
                    student.student_class_id = student_class_id;

                    array_students.add(student);

                    // di chuyen toi vi tri tiep theo
                    cursor.moveToNext();
                }

            }
        }
        // dong lai cac ket noi, tranh bi treo ung dung
        cursor.close();
        sqLiteDatabase.close();

        return array_students;

    }


    public long insertStudent(Student student) {

        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SV_ID, student.student_id);
        contentValues.put(SV_NAME, student.student_name);
        contentValues.put(SV_HOME, student.student_hometown);
        contentValues.put(SV_BIRTHDAY, student.student_birthday);
        contentValues.put(SV_CLASS, student.student_class_id);

        // them gia tri vao bang SV_TABLE
        long result = sqLiteDatabase.insert(SV_TABLE, null, contentValues);

        sqLiteDatabase.close();

        return result;

    }

    public int updateStudent(Student student) {

        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SV_ID, student.student_id);
        contentValues.put(SV_NAME, student.student_name);
        contentValues.put(SV_HOME, student.student_hometown);
        contentValues.put(SV_BIRTHDAY, student.student_birthday);
        contentValues.put(SV_CLASS, student.student_class_id);

        // cap nhat du lieu Student

        int result = sqLiteDatabase.update
                (SV_TABLE, contentValues, SV_ID + "=?", new String[]{student.student_id});

        sqLiteDatabase.close();

        return result;
    }

    public int delStudent(String student_id) {
        SQLiteDatabase sqLiteDatabase = sqliteHelper.getReadableDatabase();

        int result =
                sqLiteDatabase.delete(SV_TABLE, SV_ID + "=?", new String[]{student_id});

        return result;
    }


}
