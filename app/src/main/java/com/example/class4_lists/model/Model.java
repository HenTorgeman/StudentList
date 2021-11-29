package com.example.class4_lists.model;

import android.view.Display;

import java.util.LinkedList;
import java.util.List;

public class Model {
    // Singleton
    public static final Model instance = new Model();

    List<Student> data = new LinkedList<Student>();


    //private constructor - אף אחד לא יכול ליצור אחד חדש כזה מבחוץ
    private Model() {
        //סתם לולאה כדי ליצור לנו DATA
        for (int i = 0; i < 3; i++) {
            Student s = new Student("name", "" + i,"","", false);
            data.add(s);
        }
    }


    public List<Student> getAllStudents() {
        return data;
    }

    public void addStudent(Student student) {
        data.add(student);
    }
}
