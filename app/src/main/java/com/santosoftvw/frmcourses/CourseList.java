package com.santosoftvw.frmcourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        TableLayout tbl = (TableLayout) findViewById(R.id.tableLayout2);

        TextView txtRoll1 = (TextView) findViewById(R.id.textRoll1);
        TextView txtCourse1 = (TextView) findViewById(R.id.textCourse1);
        TextView txtCourse2 = (TextView) findViewById(R.id.textCourse2);

        Intent intent = this.getIntent();
        HashMap<String, ArrayList<String>> courses = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("courses");
        int idx = 0;
        for(Map.Entry<String, ArrayList<String>> e : courses.entrySet()){
            ArrayList<String> list = e.getValue();
            if(idx==0){
                txtRoll1.setText(e.getKey().toString());
                txtCourse1.setText(list.get(0).toString());
                txtCourse2.setText(list.get(1).toString());
            }
            else{
                TableRow tRow = new TableRow(this);
                tRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                TextView txtRoll = new TextView(this);
                txtRoll.setText(e.getKey().toString());
                txtRoll.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                txtRoll.setGravity(Gravity.CENTER);
                TextView txtCourse_1 = new TextView(this);
                txtCourse_1.setText(list.get(0).toString());
                txtCourse_1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                txtCourse_1.setGravity(Gravity.CENTER);
                TextView txtCourse_2 = new TextView(this);
                txtCourse_2.setText(list.get(1).toString());
                txtCourse_2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                txtCourse_2.setGravity(Gravity.CENTER);

                tRow.addView(txtRoll);
                tRow.addView(txtCourse_1);
                tRow.addView(txtCourse_2);

                tbl.addView(tRow, new TableLayout.LayoutParams());
            }
            idx++;
        }

        Button chartBtn = (Button) findViewById(R.id.button3);
        chartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), ChartActivity.class);
                startActivity(intent1);
            }


        });

        Button barChartBtn = (Button) findViewById(R.id.button4);
        barChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), BarChartActivity.class);
                startActivity(intent1);
            }


        });

        Button lineChartBtn = (Button) findViewById(R.id.button5);
        lineChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), LineChartActivity.class);
                startActivity(intent1);
            }


        });

    }
}