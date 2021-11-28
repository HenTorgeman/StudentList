package com.example.class4_lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.class4_lists.model.Model;
import com.example.class4_lists.model.Student;

import java.util.List;

public class StudentListRvActivity extends AppCompatActivity {

    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_rv);

        data = Model.instance.getAllStudents();

        RecyclerView list = findViewById(R.id.studentlist_rv);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        //תופס לנו לחיצה על תא ברשימה
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("Tag", "row was clicked " + position);
            }
        });

        Button addStudentBtn = findViewById(R.id.add_student_btn);
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(AddNewStudentActivity.class);
            }
        });

    }

    /*-------------------------------------------------------------------------------------------*/

    public void openActivity(Class activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    /*-------------------------------------------------------------------------------------------*/

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV;
        TextView idTV;
        CheckBox cb;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {

            super(itemView);

            nameTV = itemView.findViewById(R.id.listrow_name_tv);
            idTV = itemView.findViewById(R.id.listrow_id_tv);
            cb = itemView.findViewById(R.id.checkBox);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                    openActivity(StudentDetailsActivity.class);
                }
            });


        }
    }


    interface OnItemClickListener {
        void onItemClick(int position);
    }


    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        OnItemClickListener listener;

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);

            return new MyViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Student student = data.get(position);

            holder.nameTV.setText(student.getName());
            holder.idTV.setText(student.getId());
            holder.cb.setChecked(student.isFlag());

            holder.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    student.setFlag(holder.cb.isChecked());
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


}