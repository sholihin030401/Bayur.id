package com.project.ichwan.bayurid.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.project.ichwan.bayurid.R;
import com.project.ichwan.bayurid.mitra.AddMitraActivity;
import com.project.ichwan.bayurid.mitra.MitraAdapter;
import com.project.ichwan.bayurid.mitra.MitraItem;

import java.util.ArrayList;

public class MitraFragment extends Fragment {

    RecyclerView recyclerView;
    public static final String EXTRA_MITRA = "extra_mitra_item";
    MitraItem mitraItem;
    ArrayList<MitraItem> item;

    public MitraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_mitra, container, false);

        view.findViewById(R.id.btn_add_mitra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddMitraActivity.class));
            }
        });

        Bundle bundle = this.getArguments();
        if (bundle != null){
            mitraItem = bundle.getParcelable(EXTRA_MITRA);
        }

        recyclerView = view.findViewById(R.id.rv_mitra);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MitraAdapter adapter = new MitraAdapter(item);
        recyclerView.setAdapter(adapter);
        FirebaseRecyclerOptions<MitraItem> options = new FirebaseRecyclerOptions.Builder<MitraItem>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("mitra"),MitraItem.class)
                .build();

        return view;
    }
}