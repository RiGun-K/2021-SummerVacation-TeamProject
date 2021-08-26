package com.example.teamprojectt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recycler_item,parent,false);

        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        Item item= items.get(position);
        vh.tvName.setText(item.getName());
        vh.tvDate.setText(item.getDate());
        vh.tvMsg.setText(item.getMsg());

        Glide.with(context).load(item.getImgPath()).into(vh.iv);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
