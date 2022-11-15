package com.namazshikkha.islamapps;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.CLIPBOARD_SERVICE;

public class ALLSMSListCostomAdapter extends RecyclerView.Adapter<ALLSMSListCostomAdapter.myViewHolder> {
    private String[] data;
     Context context;

    public ALLSMSListCostomAdapter(String[] data, Context context) {
        this.data = data;
        this.context = context;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sms_text_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        String mydata=data[position];


        holder.copy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ClipboardManager myClipboard = (ClipboardManager)context.getSystemService(CLIPBOARD_SERVICE);
                String text = mydata;
                ClipData myClip = ClipData.newPlainText("text",text );
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(context, "Copy", Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView.setText(mydata);
        holder.share_brn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,mydata);
                intent.setType("text/plain");
                intent=Intent.createChooser(intent,"share text");
                holder.itemView.getContext().startActivity(intent);

            }
        });



    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        Button share_brn,copy_btn;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textSms);
            share_brn = itemView.findViewById(R.id.share_btn);
            copy_btn = itemView.findViewById(R.id.copy_btn);
        }
    }

}
