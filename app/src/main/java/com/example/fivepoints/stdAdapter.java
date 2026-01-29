package com.example.fivepoints;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class stdAdapter extends RecyclerView.Adapter<stdAdapter.ViewHolder> {



     private ArrayList<Students> listStd;

    public  stdAdapter(ArrayList<Students> listStd)
    {
        this.listStd = listStd;
    }


    @NonNull
    @Override
    public stdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_std, parent, false);
        return new stdAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull stdAdapter.ViewHolder holder, int position) {


        holder.tvname.setText(this.listStd.get(position).getsName());
        holder.tvsbd.setText(this.listStd.get(position).getsBd());


        Picasso.get().load(this.listStd.get(position).sImage).into(holder.ivsimg);
        holder.delstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setTitle("حذف مكان");
                alert.setMessage("هل انت متاكد من الحذف؟");
                alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {


                    public void onClick(DialogInterface dialog, int which) {
                        listStd.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                alert.show();




            }
        });


    }

    @Override
    public int getItemCount() {
        return this.listStd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView tvname,tvsbd;
       ImageView ivsimg,delstd;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvname);
            tvsbd = itemView.findViewById(R.id.tvsbd);
            ivsimg = itemView.findViewById(R.id.ivsimg);
            delstd = itemView.findViewById(R.id.delstd);


        }
    }
}
