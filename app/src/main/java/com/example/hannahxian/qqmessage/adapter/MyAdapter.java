package com.example.hannahxian.qqmessage.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hannahxian.qqmessage.Interfs.OnRecycleViewItemClickListner;
import com.example.hannahxian.qqmessage.R;
import com.example.hannahxian.qqmessage.bean.Goods;

/**
 * Created by hannahxian on 2016/12/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    public Goods[] goodses;

    private OnRecycleViewItemClickListner listner = null;

    public MyAdapter(Goods[] goodses) {
        this.goodses = goodses;
    }

    public void setClickListner(OnRecycleViewItemClickListner listner){
        this.listner = listner;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.goodsdisplay,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        v.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Goods goods = goodses[position];
        holder.name.setText(goods.getName());
        holder.price.setText("   $"+String.valueOf(goods.getPrice()));
        holder.description.setText(goods.getDescription());

        holder.itemView.setTag(goods.toString());
    }

    @Override
    public int getItemCount() {
        return goodses.length;
    }

    @Override
    public void onClick(View v) {
        if(listner != null){
            listner.OnItemClick(v,v.getTag().toString());
        }
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private  TextView price;
        private  TextView description;
        public MyViewHolder(View itemView) {
            super(itemView);

            this.name = (TextView)itemView.findViewById(R.id.name);
            this.price = (TextView)itemView.findViewById(R.id.price);
            this.description = (TextView)itemView.findViewById(R.id.description);
        }
    }
}
