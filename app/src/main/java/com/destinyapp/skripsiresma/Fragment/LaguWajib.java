package com.destinyapp.skripsiresma.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destinyapp.skripsiresma.Adapter.AdapterLaguWajib;
import com.destinyapp.skripsiresma.Model.LaguWajibData;
import com.destinyapp.skripsiresma.Model.ModelLaguWajib;
import com.destinyapp.skripsiresma.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaguWajib extends Fragment {


    RecyclerView rv;
    private ArrayList<ModelLaguWajib> List = new ArrayList<>();

    public LaguWajib() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lagu_wajib, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView)view.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        List.addAll(LaguWajibData.getListData());
        ShowData();

    }
    private void ShowData(){
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterLaguWajib adapterLaguWajib = new AdapterLaguWajib(getActivity());
        adapterLaguWajib.setListWajib(List);
        rv.setAdapter(adapterLaguWajib);
    }
}
