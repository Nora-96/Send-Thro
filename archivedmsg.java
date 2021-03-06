package com.example.sendthro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.annotation.Nullable;

public class archivedmsg extends Fragment {

    private FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archivedmsg, container, false);

        mAuth = FirebaseAuth.getInstance();

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton4);
        FloatingActionButton smsfab = (FloatingActionButton) view.findViewById(R.id.smsfab);
        FloatingActionButton wtsfab = (FloatingActionButton) view.findViewById(R.id.wtsfab);
        FloatingActionButton emailfab = (FloatingActionButton) view.findViewById(R.id.emailfab);

        final RelativeLayout wtslayout = (RelativeLayout) view.findViewById(R.id.wtslayout);
        final RelativeLayout smslayout = (RelativeLayout) view.findViewById(R.id.smslayout);
        final RelativeLayout emaillayout = (RelativeLayout) view.findViewById(R.id.emaillayout);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wtslayout.getVisibility() == View.VISIBLE && smslayout.getVisibility() == View.VISIBLE
                        && emaillayout.getVisibility() == View.VISIBLE) {

                    wtslayout.setVisibility(View.GONE);
                    smslayout.setVisibility(View.GONE);
                    emaillayout.setVisibility(View.GONE);
                } else {
                    wtslayout.setVisibility(View.VISIBLE);
                    smslayout.setVisibility(View.VISIBLE);
                    emaillayout.setVisibility(View.VISIBLE);
                }
            }
        });


        smsfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() == null) {
                    Intent NewUSer = new Intent(getActivity(), WelcomeActivity.class);
                    startActivity(NewUSer);
                } else {
                    Intent Do = new Intent(getActivity(), CreateSmsScheduleActivity.class);
                    startActivity(Do);
                }
            }
        });


        wtsfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() == null) {
                    Intent NewUSer = new Intent(getActivity(), WelcomeActivity.class);
                    startActivity(NewUSer);
                } else {
                    Intent Do = new Intent(getActivity(), Newmessage.class);
                    startActivity(Do);
                }
            }
        });


        emailfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() == null) {
                    Intent NewUSer = new Intent(getActivity(), WelcomeActivity.class);
                    startActivity(NewUSer);
                } else {
                    Intent Do = new Intent(getActivity(), Newmessage.class);
                    startActivity(Do);
                }
            }
        });
        return view;
    }

    }
