package com.project.ichwan.bayurid.cnbfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.ichwan.bayurid.R;

public class ProfilFragment extends Fragment {

    TextView username;
    FirebaseUser mUser;
    FirebaseAuth mAuth;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_profil, container, false);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        username = view.findViewById(R.id.username_profile);

        return view;
    }

    public void putUsername(Bundle args){
        if (mUser != null){
            String user = args.getString("username");
            username.setText(user);
        }
    }
}