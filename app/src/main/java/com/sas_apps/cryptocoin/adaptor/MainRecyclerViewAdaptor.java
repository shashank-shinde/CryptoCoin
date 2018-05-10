package com.sas_apps.cryptocoin.adaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.sas_apps.cryptocoin.R;
import com.sas_apps.cryptocoin.model.CoinMarketCapResponse;

import java.util.List;


public class MainRecyclerViewAdaptor extends RecyclerView.Adapter<MainRecyclerViewAdaptor.MainViewHolder>{


    private List<CoinMarketCapResponse> responseList;

    public MainRecyclerViewAdaptor(List<CoinMarketCapResponse> responseList) {
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textName.setText(responseList.get(position).getName());
        holder.textPriceINR.setText(String.format("₹ %s",responseList.get(position).getPriceInr()));
        holder.textPriceUSD.setText(String.format("$ %s",responseList.get(position).getPriceUsd()));
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        TextView textName,textPriceINR,textPriceUSD;

        public MainViewHolder(View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.textView_coinName);
            textPriceINR=itemView.findViewById(R.id.textView_valueINR);
            textPriceUSD=itemView.findViewById(R.id.textView_valueUSD);
        }
    }
}
