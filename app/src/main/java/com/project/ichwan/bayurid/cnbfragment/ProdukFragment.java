package com.project.ichwan.bayurid.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.ichwan.bayurid.R;
import com.project.ichwan.bayurid.produk.AddProdukActivity;

public class ProdukFragment extends Fragment {

    public ProdukFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_produk, container, false);

        view.findViewById(R.id.btn_add_produk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddProdukActivity.class));
            }
        });

        return view;
    }
}