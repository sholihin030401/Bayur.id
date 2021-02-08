package com.project.ichwan.bayurid.mitra;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ichwan.bayurid.R;

import java.util.ArrayList;

public class MitraAdapter extends RecyclerView.Adapter<MitraAdapter.MitraHolder> {

    ArrayList<MitraItem> items;

    public MitraAdapter(ArrayList<MitraItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MitraAdapter.MitraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mitra_item,parent,false);

        return new MitraHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MitraAdapter.MitraHolder holder, int position) {
        MitraItem mitraItem = items.get(position);
        holder.name.setText(mitraItem.getNamamitra());
        holder.address.setText(mitraItem.getAlamatmitra());
    }

    @Override
    public int getItemCount() {
        //java.lang.NullPointerException: Attempt to invoke virtual method 'int java.util.ArrayList.size()' on a null object reference
        return items.size();
    }

    public class MitraHolder extends RecyclerView.ViewHolder {

        TextView name, address;

        public MitraHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nama_mitra);
            address = itemView.findViewById(R.id.alamat_mitra);
        }
    }
}
