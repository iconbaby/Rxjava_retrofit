package com.slkk.rxjava_retrofig.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.modle.GankItem;

import java.util.List;

/**
 * Created by slkk on 2017/11/15.
 */

public class MapFragmentAdapter extends RecyclerView.Adapter {

    List<GankItem> images;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_item, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder dholder = (DebounceViewHolder) holder;
        dholder.gv_tv.setText(images.get(position).descreption.toString());
        Glide.with(dholder.gv_iv.getContext()).load(images.get(position).imgUrl).into(dholder.gv_iv);
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }

    class DebounceViewHolder extends RecyclerView.ViewHolder {
        ImageView gv_iv;
        TextView gv_tv;

        public DebounceViewHolder(View itemView) {
            super(itemView);
            gv_iv = itemView.findViewById(R.id.gv_item_iv);
            gv_tv = itemView.findViewById(R.id.gv_item_tv);
        }
    }

    private void setItem(List<GankItem> list) {
        this.images = list;
        notifyDataSetChanged();
    }
}
