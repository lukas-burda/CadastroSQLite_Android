package com.aula.cadastrosqlite.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aula.cadastrosqlite.R;
import com.aula.cadastrosqlite.adapter.ItemAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItems;
    FloatingActionButton fabAdd;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItems = findViewById(R.id.rvItems);
        fabAdd = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ItemAdapter(this);

        rvItems.setLayoutManager(layout);
        rvItems.setAdapter(adapter);

        fabAdd.setOnClickListener(v->{
            startActivity(new Intent(this, FormActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}