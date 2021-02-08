package com.project.ichwan.bayurid.produk;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukHolder> {
    @NonNull
    @Override
    public ProdukAdapter.ProdukHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProdukAdapter.ProdukHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProdukHolder extends RecyclerView.ViewHolder {
        public ProdukHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
