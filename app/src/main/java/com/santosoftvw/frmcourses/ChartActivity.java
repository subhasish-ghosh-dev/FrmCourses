package com.santosoftvw.frmcourses;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        PieChart pieChart = (PieChart) findViewById(R.id.avgChart);

        ArrayList<PieEntry> avgMarks = new ArrayList<PieEntry>();
        avgMarks.add(new PieEntry(46.5f,"CSE2104"));
        avgMarks.add(new PieEntry(65.0f,"CSE2101"));
        avgMarks.add(new PieEntry(39.7f,"CSE2102"));
        avgMarks.add(new PieEntry(56.0f,"CSE2103"));
        avgMarks.add(new PieEntry(76.0f,"CSE2105"));
        avgMarks.add(new PieEntry(66.0f,"CSE2106"));

        PieDataSet pieDataSet = new PieDataSet(avgMarks,"Avergae Marks of 6 Subjects");
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        //RGB = 0-255
        Integer[] colors = {
                Color.rgb(223,90, 156),
                Color.rgb(45,150, 239),
                Color.rgb(63,240, 110),
                Color.rgb(99,184, 102),
                Color.rgb(87,211, 123),
                Color.rgb(234,250, 178)

        };

        int[] colors1 = {
                Color.rgb(23,190, 156),
                Color.rgb(245,50, 239),
                Color.rgb(253,40, 110),
                Color.rgb(199,84, 102),
                Color.rgb(187,111, 123),
                Color.rgb(34,50, 178)

        };
        //pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setColors(ColorTemplate.createColors(colors1));
        pieDataSet.setValueTextSize(14f);
        pieDataSet.setValueTextColors(Arrays.asList(colors));// ClassType Array is converetd into ArrayList of this Classtype
        //List<Integer> cols = Arrays.asList(colors);
        //pieChart.setUsePercentValues(false);
        //pieDataSet.setValueFormatter(new PercentFormatter(pieChart));
        pieDataSet.setSliceSpace(4f);
        pieChart.setEntryLabelColor(Color.rgb(123,134,156));
        pieChart.setEntryLabelTextSize(12f);
        pieChart.setDrawEntryLabels(true);
        pieChart.setVerticalScrollBarEnabled(true);
        pieChart.setHorizontalScrollBarEnabled(true);

        pieDataSet.setValueLinePart1OffsetPercentage(70.0f);
        pieDataSet.setValueLinePart1Length(0.4f);
        pieDataSet.setValueLinePart2Length(0.2f);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        Legend legend = pieChart.getLegend();
        legend.setWordWrapEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);

        pieChart.animateY(10000);




    }
}