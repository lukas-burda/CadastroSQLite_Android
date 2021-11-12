package com.aula.cadastrosqlite.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aula.cadastrosqlite.R;
import com.aula.cadastrosqlite.database.dao.ItemDAO;
import com.aula.cadastrosqlite.database.database.ItemDB;
import com.aula.cadastrosqlite.entities.Item;

public class FormActivity extends AppCompatActivity {

    EditText etfieldone, etfieldtwo, etfieldthree;
    Button bsave;

    ItemDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etfieldone = findViewById(R.id.etfieldone);
        etfieldtwo = findViewById(R.id.etfieldtwo);
        etfieldthree = findViewById(R.id.etfieldthree);
        bsave = findViewById(R.id.bSave);

        dao = ItemDB.getInstance(this).getItemDAO();

        Item edtItem;
        Intent intent = getIntent();

        if(intent.hasExtra("item")){
            edtItem = (Item) intent.getSerializableExtra("item");
            etfieldone.setText(edtItem.getFieldone()+"");
            etfieldtwo.setText(edtItem.getFieldtwo());
            etfieldthree.setText(edtItem.getFieldthree());

       } else {
            edtItem = null;
        }

        bsave.setOnClickListener(v->{
            try {
                if(etfieldthree.getText().toString().isEmpty()){
                    etfieldthree.setText("");
                };
                if(etfieldtwo.getText().toString().isEmpty()){
                    etfieldtwo.setText("");
                };
                if(etfieldone.getText().toString().isEmpty()){
                    etfieldone.setText("");
                }
            }
            finally {
                Item item = new Item(
                        0,
                        etfieldone.getText().toString(),
                        etfieldtwo.getText().toString(),
                        etfieldthree.getText().toString()
                );
                if(edtItem==null){
                    dao.Insert(item);
                }else{
                    item.setId(edtItem.getId());
                    dao.Update(item);
                }
                Toast.makeText(this, "Was saved!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}