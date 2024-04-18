package com.example.smartattendance;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class DataTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datatable);

        TableView tableView = findViewById(R.id.table_data_view);
        String[] header = {"ID", "Name","Email", "Status", "Time"};
        String[][] data = {{"1234", "Meng", "mma05@nyit.edu", "Present", "11:00:00"}, {"1234", "Meng", "mma05@nyit.edu", "Absent", "11:00:00"}, {"1234", "Meng", "mma05@nyit.edu", "Present", "11:00:00"}};

        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,header));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this, data));



    }
}
