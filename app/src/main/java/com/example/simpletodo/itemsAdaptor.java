package com.example.simpletodo;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class itemsAdaptor extends RecyclerView.Adapter<itemsAdaptor.ViewHolder> {

    public interface OnLongClickListener {
        void onItemLongClicked(int position);
    }

    List<String> items;
    OnLongClickListener longClickListener;
    public itemsAdaptor(List<String> items, OnLongClickListener longClickListener) {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // use layout inflator to inflate a view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent, false);
        // wrap it inside a View Holder and return it
        return new ViewHolder(todoView);
    }

    //responsible for binding data to a perticular view holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Grab the items at the position
        String item = items.get(position);
        holder.bind(item);
        // Bind the item into the specified view Holder
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // container to provide easy acess to views that represent each row of the List
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        public void bind(String item) {
            tvItem.setText(item);
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //Notify te listener which position
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;

                }
            });
        }
    }
}
