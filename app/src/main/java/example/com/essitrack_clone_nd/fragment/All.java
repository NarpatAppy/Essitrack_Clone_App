package example.com.essitrack_clone_nd.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.OrderDetailsActivity;
import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.adapter.RecyclerviewAdapter;
import example.com.essitrack_clone_nd.bean.Recyclerview;
import example.com.essitrack_clone_nd.util.AllData;

/**
 * A simple {@link Fragment} subclass.
 */
public class All extends Fragment{
    private static final String TAG = "SearchView";
    private List<Recyclerview> tracklist;
    private RecyclerView recyclerView;
    private RecyclerviewAdapter recyclerviewAdapter;
    public int position;
    public String filterText;
    public Orders orders;
    public All()
    {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View parent  = inflater.inflate(R.layout.recyclerview, container, false);
        return parent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle);
        tracklist = new ArrayList<>();
        init();
        prepareListData();
    }
  SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {

      @Override
      public boolean onQueryTextChange(String query) {
          recyclerviewAdapter.getFilter().filter(query);
          // data set changed
          return false;
      }
      @Override
      public boolean onQueryTextSubmit(String query) {
          recyclerviewAdapter.getFilter().filter(query);
          return false;
      }

  };


    private void init() {

        recyclerviewAdapter=new RecyclerviewAdapter(tracklist);
        if(orders!=null)
            orders.recyclerviewAdapterList[position]=recyclerviewAdapter;
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager LLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(LLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewAdapter);

    }

    private void prepareListData() {
        tracklist.addAll(AllData.getAllDummyData());
        recyclerviewAdapter.notifyDataSetChanged();
    }
}
