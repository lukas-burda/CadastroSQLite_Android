package com.aula.cadastrosqlite.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.cadastrosqlite.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView tvfieldone, tvfieldtwo, tvfieldthree;
    ImageButton ibedit, ibdelete;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        tvfieldone = itemView.findViewById(R.id.tvfieldone);
        tvfieldtwo = itemView.findViewById(R.id.tvfieldtwo);
        tvfieldthree = itemView.findViewById(R.id.tvfieldtrhee);

        ibedit = itemView.findViewById(R.id.ibedit);
        ibdelete = itemView.findViewById(R.id.ibdelete);

    }
}
