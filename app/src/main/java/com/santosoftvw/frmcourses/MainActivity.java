package com.santosoftvw.frmcourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtSemester = (EditText) findViewById(R.id.editTextSemester);
        EditText txtSection = (EditText) findViewById(R.id.editTextSection);
        EditText txtRoll = (EditText) findViewById(R.id.editTextRoll);
        EditText txtCourse1 = (EditText) findViewById(R.id.editTextCourse1);
        EditText txtCourse2 = (EditText) findViewById(R.id.editTextCourse2);

        Button btnSave = (Button) findViewById(R.id.button);
        Button btnSend = (Button) findViewById(R.id.button2);

        ArrayList<String> listCourses = new ArrayList<String>();
        HashMap<String, ArrayList<String>> courses = new HashMap<String, ArrayList<String>>();

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*String msg = "Roll No: "+txtRoll.getText().toString()+" Semester: "+txtSemester.getText().toString()
                        +" Section: "+txtSection.getText().toString()+" Course Enrolled: "+txtCourse1.getText().toString()
                        +" Course Enrolled: "+txtCourse2.getText().toString();
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
                toast.setMargin(50, 50);
                toast.show();*/
                listCourses.add(txtCourse1.getText().toString());
                listCourses.add(txtCourse2.getText().toString());

                courses.put(txtRoll.getText().toString(),listCourses);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CourseList.class);
                intent.putExtra("courses", courses);
                startActivity(intent);
            }
        });

    }
}