package com.slkk.rxjava_retrofig.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.slkk.rxjava_retrofig.R;
import com.slkk.rxjava_retrofig.modle.ZhuangbiImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by slkk on 2017/11/11.
 */

public class ZhuangbiListAdapter extends RecyclerView.Adapter {

    List<ZhuangbiImage> zhuangbiImages;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View grade_item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_item, parent, false);
        return new DebounceViewHolder(grade_item_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebounceViewHolder debounceHolder = (DebounceViewHolder) holder;
        ZhuangbiImage zhuangbiImage = zhuangbiImages.get(position);
        Glide.with(holder.itemView.getContext()).load(zhuangbiImage.image_url).into(debounceHolder.gvItemIv);
        debounceHolder.gvItemTv.setText(zhuangbiImage.description);

    }

    public void setImage(List<ZhuangbiImage> list) {
        this.zhuangbiImages = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return zhuangbiImages == null ? 0 : zhuangbiImages.size();
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
