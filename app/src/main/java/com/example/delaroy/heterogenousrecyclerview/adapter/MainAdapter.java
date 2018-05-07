package com.example.delaroy.heterogenousrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.delaroy.heterogenousrecyclerview.ImageSlader;
import com.example.delaroy.heterogenousrecyclerview.R;
import com.example.delaroy.heterogenousrecyclerview.pojos.ImageSladerModel;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleHorizontal;
import com.example.delaroy.heterogenousrecyclerview.pojos.SingleVertical;

import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Object> dataAll;
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final int IMAGESLEDER = 3;

    public MainAdapter(Context context, ArrayList<Object> items,  ArrayList<Object> dataAll) {
        this.context = context;
        this.dataAll = dataAll;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case VERTICAL:
                view = inflater.inflate(R.layout.vertical, parent, false);
                holder = new VerticalViewHolder(view);
                break;
            case HORIZONTAL:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
            case IMAGESLEDER:
                view = inflater.inflate(R.layout.image_sleder, parent, false);
                holder = new ImageSlederViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.horizontal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == VERTICAL)
        {
            verticalView((VerticalViewHolder) holder, dataAll.get(position));
        }

        else if (holder.getItemViewType() == HORIZONTAL){
            horizontalView((HorizontalViewHolder) holder, dataAll.get(position));
        }

        else if (holder.getItemViewType() == IMAGESLEDER)
        {
            imageslederView((ImageSlederViewHolder) holder, dataAll.get(position));
        }

    }

    private void verticalView(VerticalViewHolder holder, Object singleVerticals) {
        ArrayList<SingleVertical> datavertical = (ArrayList<SingleVertical>) singleVerticals;
        VerticalAdapter adapter1 = new VerticalAdapter(datavertical);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        GridLayoutManager mLayoutManager = new GridLayoutManager(context, 2);
//        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setAdapter(adapter1);
    }


    private void horizontalView(HorizontalViewHolder holder, Object o) {
        ArrayList<SingleHorizontal> arrayList = (ArrayList<SingleHorizontal> )o;
        HorizontalAdapter adapter = new HorizontalAdapter(arrayList);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void imageslederView(ImageSlederViewHolder holder, Object o){
        ArrayList<ImageSladerModel> arrayList = (ArrayList<ImageSladerModel> )o;
        ImageSladerAdapter imageSlederHolder = new ImageSladerAdapter(context,arrayList);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(imageSlederHolder);
    }


    @Override
    public int getItemCount() {
        return dataAll.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (((ArrayList<?>)dataAll.get(position)).get(0) instanceof SingleVertical)
            return VERTICAL;
        if (((ArrayList<?>)dataAll.get(position)).get(0) instanceof SingleHorizontal)
            return HORIZONTAL;
        if (((ArrayList<?>)dataAll.get(position)).get(0) instanceof ImageSladerModel)
            return IMAGESLEDER;
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
            Button button = (Button) itemView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Data Baru bro "+getAdapterPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public class ImageSlederViewHolder extends  RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        ImageSlederViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.inner_recyclerView);
        }
    }

    public void addDataVertical(ArrayList<SingleVertical> data){
        dataAll.add(data);
    }

    public void addDataHorizontal(ArrayList<SingleHorizontal> data){
        dataAll.add(data);
    }

    public void addDataImagesSleder(ArrayList<ImageSladerModel> data){
        dataAll.add(data);
    }





}
