package example.com.essitrack_clone_nd.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.adapter.RecyclerviewAdapter;
import example.com.essitrack_clone_nd.bean.Recyclerview;
import example.com.essitrack_clone_nd.util.AllData;

/**
 * A simple {@link Fragment} subclass.
 */
public class Hot extends Fragment {
    private List<Recyclerview> tracklist;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    ImageView bookmark;



    public Hot() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.recyclerview, container, false);
        tracklist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycle);
        bookmark=view.findViewById(R.id.ivStar);
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

    private void prepareListData() {
        tracklist.addAll(AllData.getAllDummyData());
        for (int i = 0; i < tracklist.size(); i++) {
            Recyclerview recyclerview = tracklist.get(i);
            if (!recyclerview.isBoomarked()) {
                tracklist.remove(i);

                i--;
            }

        }
        if (tracklist.size() > 0)
            recyclerviewAdapter.notifyDataSetChanged();
        else
        {
            Toast.makeText(getActivity(), "There are currently no bookmarks!", Toast.LENGTH_SHORT).show();
        }
    }


}

