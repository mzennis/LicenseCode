package com.novia.licencecode.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novia.licencecode.R;
import com.novia.licencecode.db.Samsat;

import java.util.List;

/**
 * Created by meta on 10/07/18.
 */
public class SamsatAdapter extends RecyclerView.Adapter<SamsatAdapter.ViewHolder> {

    private Context context;
    private List<Samsat> list;
    protected OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SamsatAdapter(Context context) {
        this.context = context;
    }

    public void clear() {
        this.list.clear();
        notifyItemRangeRemoved(0, getItemCount());
    }

    public void addAll(List<Samsat> list) {
        this.list = list;
    }

    public Samsat getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(getView(viewGroup, i));
    }

    protected View getView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_samsat, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Samsat item = list.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.address.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        private TextView name, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.title);
            address = itemView.findViewById(R.id.desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
