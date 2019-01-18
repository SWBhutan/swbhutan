package com.example.sonam.sw_bhutan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SuccessfulStories extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_successful_stories, container,false);


        List<String> list = new ArrayList<>();
        list.add("innoBhutan");
        list.add("SungJab");

        List<String> desc = new ArrayList<>();
        desc.add("");
        desc.add("");


        List<String> img = new ArrayList<>();
        img.add(Integer.toString(R.drawable.innobhutan));
        img.add(Integer.toString(R.drawable.sungjab));

        RecyclerView recyclerView = view.findViewById(R.id.successful_stories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(list,img,desc));

        return view;
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mCardView;
        private TextView mtitle;
        private TextView mdescription;
        private ImageView img;





        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.ss_card_view,container,false));

            mCardView = itemView.findViewById(R.id.ss_cardView);
            mtitle = itemView.findViewById(R.id.ss_title);
            img = itemView.findViewById(R.id.ss_image);
            mdescription = itemView.findViewById(R.id.ss_description);

        }
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>
    {

        private  List<String> mlist;
        public RecyclerViewAdapter(List<String> list, List<String> desc, List<String> img){
            this.mlist = list;
            this.mlist = img;
            this.mlist = desc;

        }
        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
            recyclerViewHolder.mtitle.setText(mlist.get(i));
            recyclerViewHolder.img.setImageResource(Integer.parseInt(mlist.get(i)));
            recyclerViewHolder.mdescription.setText((mlist.get(i)));
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }

}
