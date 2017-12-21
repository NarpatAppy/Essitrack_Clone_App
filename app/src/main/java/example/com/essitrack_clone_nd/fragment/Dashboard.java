package example.com.essitrack_clone_nd.fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dashboard extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public Typeface gotham_book, gotham_medium, gotham_bold;



    public Dashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gotham_book = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getContext().getAssets(), "fonts/gothambold1.ttf");



        viewPager =  view.findViewById(R.id.viewpager);


        tabLayout =  view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(Color.parseColor("#3c5166"),Color.parseColor("#0087CF"));
        adapter.addFragment(new Ontime(), "ONTIME ORDERS");
        adapter.addFragment(new Late(), "DELAYED ORDERS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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
