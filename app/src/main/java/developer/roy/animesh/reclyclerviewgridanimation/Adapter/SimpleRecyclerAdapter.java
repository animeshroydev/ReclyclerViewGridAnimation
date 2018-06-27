package developer.roy.animesh.reclyclerviewgridanimation.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import developer.roy.animesh.reclyclerviewgridanimation.R;

/**
 * Created by animesh on 27/06/18.
 */

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    List<Integer> data;
    public SimpleRecyclerAdapter(){
        data = new ArrayList<>();
        for (int i = 0;i<=10; i++){
            data.add(i);
        }
    }


    @Override
    public SimpleRecyclerAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item,parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerAdapter.SimpleViewHolder holder, int position) {
        holder.textView.setText(String.valueOf(data.get(position)));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}

//The App is working Fine.... The card view Slides fro right... if you want to slide from left then... change 100% to -100% let me show you
