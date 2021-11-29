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

public class StudentDetailsActivity extends AppCompatActivity {

    TextView nameTv, idTv,phoneTv,addressTv;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle position = getIntent().getExtras();
        Student student = Model.instance.getAllStudents().get(position.getInt("pos"));

        nameTv = findViewById(R.id.details_name_tv);
        idTv = findViewById(R.id.details_id_tv);
        phoneTv = findViewById(R.id.details_phone_tv);
        addressTv = findViewById(R.id.details_address_tv);
        cb = findViewById(R.id.main_cb);

        nameTv.setText(student.getName());
        idTv.setText(student.getId());
        phoneTv.setText(student.getPhone());
        addressTv.setText(student.getAddress());
        cb.setChecked(student.isFlag());

        Button editBtn = findViewById(R.id.main_save_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit();
            }
        });

    }

    private void Edit(){

        Intent intent = new Intent(StudentDetailsActivity.this, EditStudentDetailsActivity.class);
        Bundle position = getIntent().getExtras();
        intent.putExtra("pos", position.getInt("pos"));
        startActivity(intent);
    }
}