package com.project.ichwan.bayurid.cnbfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.ichwan.bayurid.LoginActivity;
import com.project.ichwan.bayurid.R;

public class HomeFragment extends Fragment {

    FirebaseUser user;
    FirebaseAuth auth;
    TextView usernames;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.f_home, container, false);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(getActivity(),LoginActivity.class));
        }
        usernames = view.findViewById(R.id.get_username);
        return view;
    }

    public void putArguments(Bundle args){
        if (user != null){
            String user = args.getString("username");
            usernames.setText(user);
        }
    }

}