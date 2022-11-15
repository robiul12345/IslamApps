package com.namazshikkha.islamapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListCostomAdapter extends ArrayAdapter<ListModel> {
    private Context context;
    private ArrayList<ListModel> arrayList;

    public ListCostomAdapter(@NonNull Context context, ArrayList<ListModel> arrayList) {
        super(context, R.layout.namaj_nieat_list);
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.namaj_nieat_list, parent, false);

        TextView title = convertView.findViewById(R.id.textView_id);
        ListModel item = arrayList.get(position);
        title.setText(item.getName());

      return convertView;
    }

    @Override
    public int getCount() {
     return arrayList.size();
    }
}
