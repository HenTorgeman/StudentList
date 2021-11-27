package com.example.class4_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView nameTextView, IDTextView;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        nameTextView = findViewById(R.id.details_name_tv);
        IDTextView = findViewById(R.id.details_id_tv);
        cb = findViewById(R.id.checkBox);

        Button editBtn = findViewById(R.id.details_edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit();
            }
        });
    }

    private void Edit(){
        startActivity(new Intent(this, EditStudentDetailsActivity.class));
    }
}