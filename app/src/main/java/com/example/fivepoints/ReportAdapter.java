package com.example.fivepoints;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {

    private ArrayList<EmployeeActivity.Report> reports;

    public ReportAdapter(ArrayList<EmployeeActivity.Report> reports) {
        this.reports = reports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_report, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmployeeActivity.Report report = reports.get(position);
        
        holder.tvTitle.setText(report.getTitle());
        holder.tvDescription.setText(report.getDescription());
        holder.tvStatus.setText(report.getStatus());
        holder.tvDate.setText(report.getDate());
        
        // تغيير لون الحالة حسب النوع
        switch (report.getStatus()) {
            case "قيد الانتظار":
                holder.tvStatus.setTextColor(holder.itemView.getContext().getResources()
                        .getColor(android.R.color.holo_orange_dark));
                break;
            case "قيد المعالجة":
                holder.tvStatus.setTextColor(holder.itemView.getContext().getResources()
                        .getColor(android.R.color.holo_blue_dark));
                break;
            case "تم الحل":
                holder.tvStatus.setTextColor(holder.itemView.getContext().getResources()
                        .getColor(android.R.color.holo_green_dark));
                break;
            default:
                holder.tvStatus.setTextColor(holder.itemView.getContext().getResources()
                        .getColor(android.R.color.darker_gray));
        }
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        TextView tvStatus;
        TextView tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvReportTitle);
            tvDescription = itemView.findViewById(R.id.tvReportDescription);
            tvStatus = itemView.findViewById(R.id.tvReportStatus);
            tvDate = itemView.findViewById(R.id.tvReportDate);
        }
    }
}
