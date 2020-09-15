package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_tsr_ywh_nkh_tyc_wrk.Interface.ItemClickListner;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtProductName, txtProductPrice, txtProductQuantity;
    ItemClickListner itemClickListner;
    public CartViewHolder(View itemView) {
        super(itemView);

        txtProductName = itemView.findViewById(R.id.cartProductName);
        txtProductPrice = itemView.findViewById(R.id.cartProductPrice);
        txtProductQuantity = itemView.findViewById(R.id.cartProductQuantity);


    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view, getAdapterPosition(), false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner){
        this.itemClickListner = itemClickListner;
    }


}
