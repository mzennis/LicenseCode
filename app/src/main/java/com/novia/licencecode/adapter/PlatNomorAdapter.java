package com.novia.licencecode.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novia.licencecode.R;
import com.novia.licencecode.db.PlatNomor;

import java.util.List;

/**
 * Created by meta on 10/07/18.
 */
public class PlatNomorAdapter extends RecyclerView.Adapter<PlatNomorAdapter.ViewHolder> {

    private Context context;
    private List<PlatNomor> list;

    protected OnItemClickListener onItemClickListener;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PlatNomorAdapter(Context context) {
        this.context = context;
    }

    public void clear() {
        this.list.clear();
        notifyItemRangeRemoved(0, getItemCount());
    }

    public void addAll(List<PlatNomor> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(getView(viewGroup, i));
    }

    protected View getView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_platnomor, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PlatNomor item = list.get(i);
        viewHolder.area.setText(item.getArea());
        viewHolder.code.setText(item.getCode());
        viewHolder.country.setText(item.getCountry());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public PlatNomor getItem(int position) {
        return list.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView code, area, country;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.title);
            area = itemView.findViewById(R.id.desc);
            country = itemView.findViewById(R.id.country);

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
