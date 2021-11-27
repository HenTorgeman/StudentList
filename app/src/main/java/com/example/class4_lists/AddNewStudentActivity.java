package com.example.class4_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class AddNewStudentActivity extends AppCompatActivity {

    TextView nameEditText, IDEditText;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        nameEditText = findViewById(R.id.main_name_et);
        IDEditText = findViewById(R.id.main_address_et);
        cb = findViewById(R.id.details_checkBox);
        Button saveBtn = findViewById(R.id.details_edit_btn);
        Button cencelBtn = findViewById(R.id.main_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String name = nameEditText.getText().toString();
        String id = IDEditText.getText().toString();
        boolean flag = cb.isChecked();

        if ((name != null && id != null && flag == true))
            Log.d("TAG", "save success - saved Name and ID");
        else
            Log.d("TAG", "save failed - Name, ID or CheckBox is empty");

    }

}