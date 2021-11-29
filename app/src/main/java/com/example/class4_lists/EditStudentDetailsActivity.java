package com.example.class4_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class4_lists.model.Model;
import com.example.class4_lists.model.Student;

public class EditStudentDetailsActivity extends AppCompatActivity {

    EditText nameEt, idEt,phoneEt,addressEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student_details);

        Bundle position = getIntent().getExtras();
        Student student= Model.instance.getAllStudents().get(position.getInt("pos"));

        nameEt = findViewById(R.id.main_name_et);
        idEt = findViewById(R.id.main_id_et);
        phoneEt = findViewById(R.id.main_phone_et);
        addressEt = findViewById(R.id.main_address_et);
        cb = findViewById(R.id.main_cb);

        nameEt.setText(student.getName());
        idEt.setText(student.getId());
        phoneEt.setText(student.getPhone());
        addressEt.setText(student.getAddress());
        cb.setChecked(student.isFlag());

        Button saveBtn = findViewById(R.id.main_save_btn);
        Button cancelBtn = findViewById(R.id.main_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save(student);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacnel();
            }
        });

    }


    public void save(Student student){

        student.setAddress(addressEt.toString());
        student.setPhone(phoneEt.toString());
        student.setName(nameEt.toString());
        student.setId(idEt.toString());
        student.setFlag(cb.isChecked());
        cacnel();   //Just to dont repet redirectio page.
    }


    public void cacnel(){
        startActivity(new Intent(this,StudentDetailsActivity.class));


    }
}