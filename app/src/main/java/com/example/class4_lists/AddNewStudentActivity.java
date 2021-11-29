package com.example.class4_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class4_lists.model.Model;
import com.example.class4_lists.model.Student;

public class AddNewStudentActivity extends AppCompatActivity {

    TextView nameEditText, IDEditText,phoneEditText,addressEditText;
    CheckBox cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        nameEditText = findViewById(R.id.main_name_et);
        IDEditText = findViewById(R.id.main_id_et);
        phoneEditText = findViewById(R.id.main_phone_et);
        addressEditText = findViewById(R.id.main_address_et);
        cb = findViewById(R.id.main_cb);

        Button saveBtn = findViewById(R.id.main_save_btn);
        Button cancelBtn = findViewById(R.id.main_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View v){
                cancel();
            }
        });
    }

    private void save() {
        String name = nameEditText.getText().toString();
        String id = IDEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String address= addressEditText.getText().toString();
        boolean flag = cb.isChecked();

        Student s=new Student(name,id,phone,address,false);
        Model.instance.addStudent(s);

        startActivity(new Intent(this,StudentListRvActivity.class));

    }
    private void cancel() {
        startActivity(new Intent(this,StudentListRvActivity.class));
    }


}