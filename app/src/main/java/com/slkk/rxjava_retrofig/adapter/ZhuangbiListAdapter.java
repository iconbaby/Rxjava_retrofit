package com.slkk.rxjava_retrofig.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.modle.Stories;
import com.slkk.rxjava_retrofig.modle.ZhihuRootBean;
import com.slkk.rxjava_retrofig.modle.ZhuangbiImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by slkk on 2017/11/11.
 */

public class ZhuangbiListAdapter extends RecyclerView.Adapter {

    List<Stories> stories;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View grade_item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_item, parent, false);
        return new DebounceViewHolder(grade_item_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder debounceHolder = (DebounceViewHolder) holder;
        Glide.with(holder.itemView.getContext()).load(stories.get(position).getImages().get(0)).into(debounceHolder.gvItemIv);
        debounceHolder.gvItemTv.setText(stories.get(position).getTitle());

    }

    public void setImage(List<Stories> list) {
        this.stories = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stories == null ? 0 : stories.size();
    }

    class DebounceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gv_item_iv)
        ImageView gvItemIv;
        @BindView(R.id.gv_item_tv)
        TextView gvItemTv;

        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
