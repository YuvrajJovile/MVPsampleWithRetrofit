package com.techkei.thirumaran.retrofit.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Thirumaran on 3/11/2018
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    /*public T data;
    String TAG = getClass().getSimpleName();

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(T data){
        this.data = data;
        populateData(data);

    }

    public abstract void onBindViewHolder(DesignLabViewHolder holder, int position);

    protected abstract void populateData(T data);*/

    public T data;
    String TAG = getClass().getSimpleName();

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setData(T data) {
        this.data = data;
        populateData(data);
    }


    public abstract void onClick(View view);

    protected abstract void populateData(T data);


}