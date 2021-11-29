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
Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student_details);

        Bundle position = getIntent().getExtras();
        student= Model.instance.getAllStudents().get(position.getInt("pos"));

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

                save(position);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cacnel(position);
            }
        });

    }

    public void cacnel(Bundle position){
        startActivity(new Intent(this,StudentDetailsActivity.class));
    }

    public void save(Bundle position){

        student= Model.instance.getAllStudents().get(position.getInt("pos"));

        student.setName(nameEt.getText().toString());
        student.setId(idEt.getText().toString());
        student.setPhone(phoneEt.getText().toString());
        student.setAddress(addressEt.getText().toString());
        student.setFlag(cb.isChecked());
        cacnel(position);   //Just to dont repet redirectio page.
    }

}