package com.destinyapp.skripsiresma.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destinyapp.skripsiresma.MainActivity;
import com.destinyapp.skripsiresma.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {

    CardView wajib;
    public Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wajib = (CardView)view.findViewById(R.id.card_wajib);
        wajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(getActivity(), MainActivity.class);
                goInput.putExtra("Wajib","wajib");
                getActivity().startActivities(new Intent[]{goInput});
            }
        });
    }

}
