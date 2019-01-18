package com.example.sonam.sw_bhutan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button upcoming = (Button) view.findViewById(R.id.button_upcoming_events);
        Button ss = (Button) view.findViewById(R.id.button_successful_stories);
        Button htp = (Button) view.findViewById(R.id.button_how_to_pitch);
        Button idea = (Button) view.findViewById(R.id.button_ideas);

        upcoming.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v)
            {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.home_fragment ,new upcoming_events());
                fr.commit();
            }

        });
        ss.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                FragmentTransaction fr1=getFragmentManager().beginTransaction();
                fr1.replace(R.id.home_fragment ,new SuccessfulStories());
                fr1.commit();
            }
        });


        htp.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                FragmentTransaction fr2=getFragmentManager().beginTransaction();
                fr2.replace(R.id.home_fragment ,new how_to_pitch());
                fr2.commit();
            }
        });

        idea.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                FragmentTransaction fr3=getFragmentManager().beginTransaction();
                fr3.replace(R.id.home_fragment ,new ideas());
                fr3.commit();
            }
        });


        return view;
    }

}
