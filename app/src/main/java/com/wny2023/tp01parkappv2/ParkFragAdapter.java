package com.wny2023.tp01parkappv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wny2023.tp01parkappv2.databinding.RecyclerItemParkBinding;

import java.util.ArrayList;

public class ParkFragAdapter extends RecyclerView.Adapter<ParkFragAdapter.VH> {

    Context context;
    ArrayList<ItemRecycler> items;

    public ParkFragAdapter(Context context, ArrayList<ItemRecycler> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(RecyclerItemParkBinding.inflate(LayoutInflater.from(context),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ItemRecycler item =items.get(position);
        holder.binding.tvParkName.setText(item.parkName);
        holder.binding.tvParkAddr.setText(item.addrPark);
        holder.binding.tvParkEquip.setText(item.parkEquip);
        holder.binding.tvParkPlant.setText(item.parkPlant);
        holder.binding.tvUrlSite.setText(item.urlSite);
        Glide.with(context).load(item.imgPark).into(holder.binding.ivPark);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        RecyclerItemParkBinding binding;

        public VH(@NonNull RecyclerItemParkBinding binding) {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
