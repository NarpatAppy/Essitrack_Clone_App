package example.com.essitrack_clone_nd.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.adapter.ExpandableListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Faq extends Fragment {
    public static Faq fragment;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String,List<String>> listChildData;
    public static Faq newInstance() {
        fragment = new Faq();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Faq() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.faq, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        expandableListView=view.findViewById(R.id.lvExp);

        pripareListData();

        expandableListAdapter = new ExpandableListAdapter(getActivity(),listDataHeader,listChildData);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return false;
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    private void pripareListData() {
        listDataHeader = new ArrayList<String>();
        listChildData = new HashMap<String, List<String>>();
        // Adding Header Data
        listDataHeader.add("How do I search for an Order?");

        listDataHeader.add("How do I view the details of a given Order?");

        listDataHeader.add("There are too many Orders showing up in the Order List. How can I track specific Order(s)?");

        listDataHeader.add("How can I remove an Order from my Bookmarks tab?");
        listDataHeader.add("I want to be informed about the real time status of the Order. Is this possible?");
        listDataHeader.add("I do not wish to receive anymore notifications about Order status. How can I switch off these notifications?");

        listDataHeader.add("I want to know if any of my Orders will be delayed. Is there any way to view such Orders");
        listDataHeader.add("Can I install the Essitrack Application on multiple Mobile devices?");

        //Adding Header Data
        List<String> Important_Order = new ArrayList<String>();
        Important_Order.add("To search for an Order, go to the Orders tab and type in the Order # or Reference # in the search box at the top of the screen. ");

        List<String> view_Order = new ArrayList<String>();
        view_Order.add("In the Orders tab, tap on the Order you are interested in. You can view details of the Order in the screen that opens.");

        List<String> My_Order = new ArrayList<String>();
        My_Order.add("To track specific Order(s), search for the Order using Order # or Reference #. Tap on the star icon on the right hand side of the order. Go to the Bookmarks tab to view all orders that have been starred.");

        List<String> Remove_Order = new ArrayList<String>();
        Remove_Order.add("To remove a Bookmark, simply tap on the star icon next to the Order Status.");

        List<String> Switch_Off_Notification = new ArrayList<String>();
        Switch_Off_Notification.add("Yes, whenever an Order is updated, you will be informed about the change in status through a Essitrack notification.");

        List<String> Order_Status = new ArrayList<String>();
        Order_Status.add("To turn off notifications, go to the Settings in the Menu and tap on Notifications. Tap again to turn on the Notifications.");

        List<String> Late_Delivery = new ArrayList<String>();
        Late_Delivery.add("A summary of delayed Orders can be viewed in the Delayed Orders tab in the dashboard. In the Orders screen, an Order marked by a red band on the left is a delayed Order. The Order detail screen will also have a “Delayed” indicator.");

        List<String> Essitrack_Installation = new ArrayList<String>();
        Essitrack_Installation.add("Yes, it is possible to install the Essitrack application on multiple mobile devices, as long as these devices are Android(OS version Jellybean 4.1 and above)or iOS mobile phones(OS version 8.4 and above)");



        listChildData.put(listDataHeader.get(0), Important_Order); // Header, Child data
        listChildData.put(listDataHeader.get(1), view_Order);
        listChildData.put(listDataHeader.get(2), My_Order);
        listChildData.put(listDataHeader.get(3), Remove_Order);
        listChildData.put(listDataHeader.get(4), Switch_Off_Notification);
        listChildData.put(listDataHeader.get(5), Order_Status);

        listChildData.put(listDataHeader.get(6), Late_Delivery);
        listChildData.put(listDataHeader.get(7), Essitrack_Installation);



    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
