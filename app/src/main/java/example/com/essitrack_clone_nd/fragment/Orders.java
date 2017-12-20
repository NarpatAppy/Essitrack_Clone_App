package example.com.essitrack_clone_nd.fragment;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.adapter.RecyclerviewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Orders extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    RecyclerviewAdapter recyclerviewAdapterList[]=new RecyclerviewAdapter[6];

    SearchView searchView;

    public Typeface gotham_book, gotham_medium, gotham_bold;
    ViewPagerAdapter adapter;
    public Orders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.orders, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gotham_book = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getContext().getAssets(), "fonts/gothambold1.ttf");

        viewPager = view.findViewById(R.id.viewpager);
        tabLayout =  view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        searchView = view.findViewById(R.id.etSearch);
        setupViewPager(viewPager);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //recyclerviewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if(recyclerviewAdapterList[viewPager.getCurrentItem()]!=null)
                    recyclerviewAdapterList[viewPager.getCurrentItem()].getFilter().filter(query);
                return false;
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {

        adapter= new ViewPagerAdapter(getChildFragmentManager());
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(Color.parseColor("#3c5166"),Color.parseColor("#0087CF"));
        Today today=new Today();
        today.orders=this;
        today.position=0;
        adapter.addFragment(today, "TODAY'S");
        All all=new All();
        all.orders=this;
        all.position=1;
        adapter.addFragment(all, "ALL");
        Inprogress inprogress=new Inprogress();
        inprogress.orders=this;
        inprogress.position=2;
        adapter.addFragment(inprogress, "IN PROGRESS");
        Completed completed=new Completed();
        completed.orders=this;
        completed.position=3;
        adapter.addFragment(completed, "COMPLETED");
        Lateorders lateorders=new Lateorders();
        lateorders.orders=this;
        lateorders.position=4;
        adapter.addFragment(lateorders, "DELAYED");
        Cancelled cancelled=new Cancelled();
        cancelled.orders=this;
        cancelled.position=5;
        adapter.addFragment(cancelled, "CANCELLED");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("data======","position=-==================="+position);
                if(recyclerviewAdapterList[position]!=null)
                    recyclerviewAdapterList[position].getFilter().filter(searchView.getQuery().toString());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    class ViewPagerAdapter extends FragmentPagerAdapter  {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
