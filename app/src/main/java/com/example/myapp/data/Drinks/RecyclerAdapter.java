package com.example.myapp.data.Drinks;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.UI.Fragments.OrderFragment;
import com.example.myapp.UI.ViewModels.AdapterViewModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private List<Drink> items;
    LayoutInflater inflater;
    FragmentCommunication communication;
    AdapterViewModel viewModel;
    boolean isFav=false;
    float populatity;
    View editpop;


    public RecyclerAdapter(){

    }

    public RecyclerAdapter(FragmentCommunication communication, List<Drink> drinks) {

        Log.d("dsa", drinks.toString());
        if(drinks.size()!=0) {
            if (drinks.get(0).getPopularity() == 0) {

                isFav = true;
            } else {
                isFav = false;
            }

            this.communication = communication;
            if(this.items!=null){
                this.items.clear();
            }

            this.items = drinks;
        }

    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d("csa",populatity+"");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, null);

        editpop= view.findViewById(R.id.pop);

        if(isFav){

            editpop.setAlpha(0.0f);
        }
        else {

        }

        return new ViewHolder(view,communication);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        final Drink current = items.get(position);


        if(!isFav){

            Log.d("rasmus",(float)current.getPopularity()/10+"");
            //editpop.setAlpha(0);
        }
        int curren = current.getPopularity();
        Log.d("curren",curren+"");

        holder.title.setText(current.getTitle());
        holder.price.setText(current.getPrice());
        holder.image.setImageResource(current.getImage());
        holder.pop.setAlpha((float)current.getPopularity()/10);


        OrderFragment fragment = new OrderFragment();
        Bundle bundle = new Bundle();

        bundle.putString("Title",items.get(position).getTitle());
        bundle.putString("Price",items.get(position).getPrice());
        bundle.putInt("Image",items.get(position).getImage());
        fragment.setArguments(bundle);
    }

    @Override
    public int getItemCount() {
        if(items!=null){
            return items.size();
        }
        return 0;

    }

    public void setDrinks(List<Drink> drinks){

        items.clear();

        this.items=drinks;
        this.notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title, price;
        private ImageView image;
        private TextView pop;
        private FragmentCommunication communicatoren;

        public ViewHolder(final View view,FragmentCommunication communication) {
            super(view);
            communicatoren=communication;
            title = view.findViewById(R.id.titles);
            price = view.findViewById(R.id.prices);
            image = view.findViewById(R.id.imageView);
            pop = view.findViewById(R.id.pop);
            image.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            viewModel =new AdapterViewModel();


            //viewModel.setBundle(items.get(getBindingAdapterPosition()).getTitle(),items.get(getBindingAdapterPosition()).getPrice(),items.get(getBindingAdapterPosition()).getImage(),items.get(getBindingAdapterPosition()).getPricetag());
            viewModel.setBundle1(items.get(getBindingAdapterPosition()).getTitle(),items.get(getBindingAdapterPosition()).getPrice(),items.get(getBindingAdapterPosition()).getImage(),items.get(getBindingAdapterPosition()).getPricetag(),items.get(getBindingAdapterPosition()).getClubId());

            //communicatoren.respons(items.get(getBindingAdapterPosition()).getTitle(),items.get(getBindingAdapterPosition()).getPrice(),items.get(getBindingAdapterPosition()).getImage());

        }


    }
}
