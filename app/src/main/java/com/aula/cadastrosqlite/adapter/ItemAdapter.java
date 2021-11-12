package com.aula.cadastrosqlite.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.cadastrosqlite.R;
import com.aula.cadastrosqlite.UI.FormActivity;
import com.aula.cadastrosqlite.database.dao.ItemDAO;
import com.aula.cadastrosqlite.database.database.ItemDB;
import com.aula.cadastrosqlite.entities.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {

    Context context;
    List<Item> listaItens;
    ItemDAO dao;

    public ItemAdapter(Context context) {
        this.context = context;
        dao = ItemDB.getInstance(context).getItemDAO();
        listaItens  = dao.GetAll();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        ItemViewHolder itemviewholder = new ItemViewHolder(itemView);
        return itemviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = listaItens.get(position);
        ItemViewHolder itemviewholder =(ItemViewHolder) holder;

        itemviewholder.tvfieldone.setText(item.getFieldone()+"");
        itemviewholder.tvfieldtwo.setText(item.getFieldtwo()+"");
        itemviewholder.tvfieldthree.setText(item.getFieldthree()+"");

        itemviewholder.ibdelete.setOnClickListener(v -> {
            new AlertDialog.Builder(context).setTitle("DeleteItem").setMessage("Confirm Delete?").setNegativeButton("Cancel",null).setPositiveButton("Yes",(dialogInterface, i) -> {
                dao.Delete(item);
                Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show();
                updateDataSet();
            }).show();

        });

        itemviewholder.ibedit.setOnClickListener(v->{
            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("item",item);
            context.startActivity(editarIntent);
        });


    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public void updateDataSet(){
        listaItens.clear();
        listaItens = dao.GetAll();
        notifyDataSetChanged();
    }
}
