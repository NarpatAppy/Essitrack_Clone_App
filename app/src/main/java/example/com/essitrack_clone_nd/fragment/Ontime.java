package example.com.essitrack_clone_nd.fragment;


import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import example.com.essitrack_clone_nd.MainActivity;
import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.bean.Recyclerview;

import static android.content.ContentValues.TAG;
import static example.com.essitrack_clone_nd.util.AllData.getAllDummyData;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ontime extends Fragment {
    private PieChart mChart;
    public Typeface gotham_book, gotham_medium, gotham_bold;

    public static TextView your_orders_text,tvProgress,tvCompleted;
    public static TextView ontime_completed;
    public static TextView ontime_inprogress;
    public static TextView ontime_total;

    public static LinearLayout completed;
    public static LinearLayout in_progress;

    public static ViewPager mViewPager;

    public static LinearLayout dashboard;
    public static LinearLayout orders;
    public static LinearLayout bookmarks;

    //Inserting values for the chart
//    private float[] yData = new float[3];
    private float[] yData = new float[2];
    //    private String[] xData={" "," "," "};
    private String[] xData = {" ", " "};

    public static final int[] COMPLETED_COLOR = {Color.rgb(97,186,79)};    //blue
    public static final int[] INPROGRESS_COLOR = {Color.rgb(195,204,74)};   //Nblue

    private RelativeLayout main_layout;

    int v,countInProgress,countCompleted;


    public Ontime() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View parent = inflater.inflate(R.layout.fragment_ontime, container, false);
        return parent;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        tvProgress=  view.findViewById(R.id.tvProgress);
        tvCompleted=  view.findViewById(R.id.tvCompleted);
        your_orders_text=  view.findViewById(R.id.your_orders_text);
        ontime_completed =  view.findViewById(R.id.ontime_completed);
        ontime_inprogress =  view.findViewById(R.id.ontime_inprogress);
        ontime_total =  view.findViewById(R.id.ontime_total);
        completed =  view.findViewById(R.id.completed);
        in_progress =  view.findViewById(R.id.in_progress);

        gotham_book = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getContext().getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getContext().getAssets(), "fonts/gothambold1.ttf");
        ontime_completed.setTypeface(gotham_medium);
        ontime_inprogress.setTypeface(gotham_medium);
        ontime_total.setTypeface(gotham_medium);
        main_layout =  view.findViewById(R.id.main_layout);
        tvProgress.setTypeface(gotham_medium);
        tvCompleted.setTypeface(gotham_medium);

        completed.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                MainActivity.orders_df();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Orders orders = new Orders();
                transaction.replace(R.id.place_holder, orders);
                transaction.commit();

            }
        });

        in_progress.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                MainActivity.orders_df();

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Orders orders = new Orders();
                transaction.replace(R.id.place_holder, orders);
                transaction.commit();

            }
        });
        try
        {
            getCount();
            ontime_inprogress.setText(String.valueOf(countInProgress));
            ontime_completed.setText(String.valueOf(countCompleted));
            v=countInProgress+countCompleted;
            ontime_total.setText(String.valueOf(v));
            int perCompleted = countCompleted * 100 / v;
            int perCountDelay = countInProgress* 100 / v;
            yData[0] = perCompleted;
            yData[1] = perCountDelay;


        }catch (RuntimeException e){
            Log.d(TAG, e.toString());

        }
        mChart =  view.findViewById(R.id.chart1);

        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(0, 0, 0, 0);
        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(20);

        mChart.setHoleRadius(50f);
        mChart.setTransparentCircleRadius(52f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        Legend l = mChart.getLegend();
        l.setEnabled(false);
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);


        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if (e == null)
                    return;

            }

            @Override
            public void onNothingSelected() {

            }
        });
        setData();

    }
    private void setData() {
        List<PieEntry> yVals1 = new ArrayList<PieEntry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new PieEntry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < xData.length; i++) {
            xVals.add(xData[i]);
        }


        //create pie
        PieDataSet dataset = new PieDataSet(yVals1, "");
        dataset.setSliceSpace(2);
        dataset.setSelectionShift(5);

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : COMPLETED_COLOR)
            colors.add(c);

        for (int c : INPROGRESS_COLOR)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataset.setColors(colors);


        PieData data = new PieData(dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);
        mChart.setExtraOffsets(0, 0, 0, 0);
        mChart.setData(data);

        mChart.highlightValue(null);

        mChart.invalidate();


    }
    private void getCount() {

        List<Recyclerview> l=getAllDummyData();
        for (int i=1;i<l.size();i++)
        {
            if (l.get(i).getStatus().equals("Completed"))
            {
                countCompleted++;
            }
            else if (l.get(i).getStatus().equals("In Progress")){
                countInProgress++;
            }

        }
        Log.e("Completed Count======>","======>"+countCompleted);
        Log.e("InProgress Count======>","======>"+countInProgress);

    }


}
