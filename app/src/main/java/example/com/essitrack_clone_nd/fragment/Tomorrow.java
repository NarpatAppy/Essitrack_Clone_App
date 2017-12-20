package example.com.essitrack_clone_nd.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.adapter.RecyclerviewAdapter;
import example.com.essitrack_clone_nd.bean.Recyclerview;
import example.com.essitrack_clone_nd.util.AllData;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tomorrow extends Fragment{
    private List<Recyclerview> tracklist;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;

    String filterText;

    public Tomorrow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.recyclerview, container, false);
        tracklist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycle);
        init();
        prepareListData();
        Log.e("on=-=-======","on Create View======================");
        return view;
    }
    private void init() {

        recyclerviewAdapter=new RecyclerviewAdapter(tracklist);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager LLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(LLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewAdapter);
    }
    private Boolean checkTommarowDate(String dateString){
        boolean result=false;
            Calendar tomorrow=Calendar.getInstance();
            tomorrow.add(Calendar.DAY_OF_YEAR,1);
            String date=(tomorrow.get(Calendar.DAY_OF_MONTH)<10?"0"+tomorrow.get(Calendar.DAY_OF_MONTH):tomorrow.get(Calendar.DAY_OF_MONTH))
                    +"-"+(tomorrow.get(Calendar.MONTH)<9?"0"+(tomorrow.get(Calendar.MONTH)+1):tomorrow.get(Calendar.MONTH)+1)+"-"+tomorrow.get(Calendar.YEAR);
            if (date.equals(dateString))

                result= true;
            Log.e("date check====","date============"+date+"-------------"+dateString);
        return result;
    }

    private void prepareListData() {
        tracklist.addAll(AllData.getAllDummyData());
        for(int i=0;i<tracklist.size();i++)
        {
            Recyclerview recyclerview=tracklist.get(i);
            if(!checkTommarowDate(recyclerview.getDdate()))
            {tracklist.remove(i);i--;}
        }

        recyclerviewAdapter.notifyDataSetChanged();
    }

}
