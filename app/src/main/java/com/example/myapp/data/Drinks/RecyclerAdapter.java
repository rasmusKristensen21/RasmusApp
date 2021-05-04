package com.example.myapp.data.Drinks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.UI.Fragments.OrderFragment;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<Drink> items;
    LayoutInflater inflater;
    FragmentCommunication communication;

    public RecyclerAdapter(List<Drink> items, FragmentCommunication communication) {
        this.items = items;
        this.communication = communication;

    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, null);
        return new ViewHolder(view,communication);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        final Drink current = items.get(position);
        holder.title.setText(current.getTitle());
        holder.price.setText(current.getPrice());
        holder.image.setImageResource(current.getImage());

        OrderFragment fragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Title",items.get(position).getTitle());
        bundle.putString("Price",items.get(position).getPrice());
        bundle.putInt("Image",items.get(position).getImage());
        fragment.setArguments(bundle);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, price;
        private ImageView image;
        private FragmentCommunication communicatoren;

        public ViewHolder(final View view,FragmentCommunication communication) {
            super(view);
            communicatoren=communication;
            title = view.findViewById(R.id.titles);
            price = view.findViewById(R.id.prices);
            image = view.findViewById(R.id.imageView);
            image.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            communicatoren.respons(items.get(getBindingAdapterPosition()).getTitle(),items.get(getBindingAdapterPosition()).getPrice(),items.get(getBindingAdapterPosition()).getImage());

        }


    }
}