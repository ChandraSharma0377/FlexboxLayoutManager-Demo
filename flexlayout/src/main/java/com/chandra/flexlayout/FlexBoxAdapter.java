package com.chandra.flexlayout;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class FlexBoxAdapter extends RecyclerView.Adapter<FlexBoxAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FlexItemDto> arrayList = new ArrayList<>();

    public FlexBoxAdapter(Context context, ArrayList<FlexItemDto> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public FlexBoxAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rcv_flex_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FlexBoxAdapter.ViewHolder holder, final int position) {
        holder.name.setText(arrayList.get(position).getLabel());
        if (arrayList.get(position).isSelect()) {
            holder.name.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_select));
        } else {
            holder.name.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_unselect));
        }
        holder.name.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arrayList.get(position).setSelect(isChecked);
                if (isChecked) {
                    holder.name.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_select));
                    Toast.makeText(context, "You checked the " + arrayList.get(position).getLabel(), Toast.LENGTH_LONG).show();
                } else {
                    holder.name.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_unselect));
                    Toast.makeText(context, "You Un checked the " + arrayList.get(position).getLabel(), Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox name;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);

        }
    }

    public ArrayList<String> getSelectedDataList() {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isSelect()) {
                temp.add(arrayList.get(i).getLabel());
            }
        }
        return temp;
    }
}
