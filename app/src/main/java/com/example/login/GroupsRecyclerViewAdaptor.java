package com.example.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupsRecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<String> groups;

    public GroupsRecyclerViewAdaptor(ArrayList<String> groups) {

        this.groups = groups;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new GroupViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_group, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final String branchName = groups.get(position);
        GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
        groupViewHolder.textViewGroupName.setText(branchName);
    }

    private OnGroupNameClickListener onGroupNameClickListener;

    @Override
    public int getItemCount() {

        return groups.size();
    }

    public interface OnGroupNameClickListener {

        void onGroupNameClick(View view, String branchName);
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewGroupName;

        public GroupViewHolder(@NonNull View itemView) {

            super(itemView);
            this.textViewGroupName = itemView.findViewById(R.id.textViewGroupName);

            itemView.setOnClickListener(v -> onGroupNameClickListener.onGroupNameClick(itemView, groups.get(getAdapterPosition())));
        }
    }

    public void setOnGroupNameClickListener(final OnGroupNameClickListener onGroupNameClickListener) {

        this.onGroupNameClickListener = onGroupNameClickListener;
    }
}
