package com.namazshikkha.islamapps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.namazshikkha.islamapps.AllSura.SuraArRohomanActivity;
import com.namazshikkha.islamapps.AllSura.SuraYesainActivity;
import com.namazshikkha.islamapps.FiveNamajNieat.JanajaNamajActivity;

import java.util.List;

public class CostomAdapter extends RecyclerView.Adapter<CostomAdapter.MyViewHolder> {

    Context context;
    List<ModelClass> modelClassList;

    public CostomAdapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelClass item = modelClassList.get(position);

        holder.imageView.setImageResource(item.getImage());
        holder.textView.setText(item.getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(context, NamajNieatActivity.class);
                        intent.putExtra("title", item.getName());
                        context.startActivity(intent);
                        break;
                    case 1:
                        context.startActivity(new Intent(context, FiveNamajTasbi.class));

                        break;
                    case 2:
                        context.startActivity(new Intent(context, Kalima.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context, SuraActivity.class));
                        break;
                    case 4:
                        context.startActivity(new Intent(context, SuraHasor.class));
                        break;
                    case 5:
                        context.startActivity(new Intent(context, RojaAndTarabiNamaj.class));
                        break;
                    case 6:
                        context.startActivity(new Intent(context, AiatulKurceActivity.class));
                        break;
                    case 7:
                        context.startActivity(new Intent(context, JanajaNamajActivity.class));
                        break;

                    case 8:
                        context.startActivity(new Intent(context, Oju.class));
                        break;
                    case 9:
                        context.startActivity(new Intent(context, Dowa70Activity.class));
                        break;
                    case 10:
                        context.startActivity(new Intent(context, NmajPic.class));
                        break;
                    case 11:
                        context.startActivity(new Intent(context, JumaNamajActivity.class));
                        break;

                    case 12:
                        context.startActivity(new Intent(context, SuraYesainActivity.class));
                        break;
                    case 13:
                        context.startActivity(new Intent(context, SuraArRohomanActivity.class));
                        break;
                    case 14:
                        context.startActivity(new Intent(context, DuaProtidinActivity.class));
                        break;
                    case 15:
                        context.startActivity(new Intent(context, EidActivity.class));
                        break;

                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        CardView layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView2);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
