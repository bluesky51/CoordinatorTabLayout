package com.sky.sky.printtext.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sky.sky.printtext.R;
import com.sky.sky.printtext.callback.OnClickListener;

import java.util.List;

/**
 * Created by BlueSky on 17/2/3.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private OnClickListener onClickListener;
    private List<String> stringList;
    private  Context context;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(List<String> stringList, Context context) {
        this.stringList = stringList;
        this.context = context;
        inflater =LayoutInflater.from(context);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.textView.setText(stringList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                    onClickListener.onClickListener(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView ;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
