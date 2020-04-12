package com.example.sendthro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import kotlin.sequences.USequencesKt;

public class CalendarFragment extends Fragment {
    private FirebaseAuth mAuth;
    MaterialCalendarView materialCalendarView;
    TextView newEvent;
    ImageView plussign;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendafragment, container, false);

        mAuth = FirebaseAuth.getInstance();

        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton4);
        FloatingActionButton smsfab = (FloatingActionButton) view.findViewById(R.id.smsfab);
        FloatingActionButton wtsfab = (FloatingActionButton) view.findViewById(R.id.wtsfab);
        FloatingActionButton emailfab = (FloatingActionButton) view.findViewById(R.id.emailfab);

        final RelativeLayout wtslayout = (RelativeLayout) view.findViewById(R.id.wtslayout);
        final RelativeLayout smslayout = (RelativeLayout) view.findViewById(R.id.smslayout);
        final RelativeLayout emaillayout = (RelativeLayout) view.findViewById(R.id.emaillayout);
        materialCalendarView = view.findViewById(R.id.calendarView);
        newEvent = view.findViewById(R.id.newEvent);
        plussign = view.findViewById(R.id.plussign);


        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(1900, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.setDateSelected(CalendarDay.today(), true);


        //New Event Creation
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Intent newevent = new Intent(getActivity(), AddEventActivity.class);
                startActivity(newevent);
            }
        });

        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newevent = new Intent(getActivity(), AddEventActivity.class);
                startActivity(newevent);
            }
        });

        plussign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newevent = new Intent(getActivity(), AddEventActivity.class);
                startActivity(newevent);
            }
        });
        //-------------------//

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

