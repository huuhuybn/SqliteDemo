package vn.edu.poly.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private StudentDAO studentDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDAO = new StudentDAO(MainActivity.this);


        Student student = new Student();

        student.student_id = "01410";
        student.student_id = "abc";
        student.student_name = "Huy Nguyen";
        student.student_hometown = "Bac Ninh";
        student.student_birthday = "010101";
        student.student_class_id = "SEO410";
        long result = studentDAO.insertStudent(student);

        if (result > 0) {
            // them thanh cong
        } else {
            //them ko thanh cong
        }


        studentDAO.delStudent("01410");

        student.student_name = "Quynh Nguyen";
        studentDAO.updateStudent(student);


        List<Student> students = studentDAO.getAllStudents();

        Log.e("size", students.size() + "");





    }

}
