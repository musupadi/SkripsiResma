package com.destinyapp.skripsiresma.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.destinyapp.skripsiresma.MainActivity;
import com.destinyapp.skripsiresma.Model.ModelLaguWajib;
import com.destinyapp.skripsiresma.R;

import java.util.ArrayList;

public class AdapterLaguWajib extends RecyclerView.Adapter<AdapterLaguWajib.CategoryViewHolder> {
    private Context context;
    private ArrayList<ModelLaguWajib> listWajib;

    private ArrayList<ModelLaguWajib> getListWajib() {
        return listWajib;
    }

    public void setListWajib(ArrayList<ModelLaguWajib> listWajib) {
        this.listWajib = listWajib;
    }

    public AdapterLaguWajib(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_wajib, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListWajib().get(position).getNamaLagu());
        categoryViewHolder.tvName.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent goInput = new Intent(context, MainActivity.class);
                goInput.putExtra("DetailExtra","Wajib");
                goInput.putExtra("NamaLagu",getListWajib().get(position).getNamaLagu());
                goInput.putExtra("Lirik",getListWajib().get(position).getLirik());
                goInput.putExtra("Lagu",getListWajib().get(position).getLagu());
                context.startActivities(new Intent[]{goInput});
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListWajib().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView layoutCardView;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNamaLagu);
        }
    }
}

