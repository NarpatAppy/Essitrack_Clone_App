package example.com.essitrack_clone_nd;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import example.com.essitrack_clone_nd.adapter.ConnectionDetector;
import example.com.essitrack_clone_nd.fragment.Bookmarks;
import example.com.essitrack_clone_nd.fragment.Dashboard;
import example.com.essitrack_clone_nd.fragment.Faq;
import example.com.essitrack_clone_nd.fragment.Orders;
import example.com.essitrack_clone_nd.fragment.Settings;

public class MainActivity extends AppCompatActivity {
    public static LinearLayout dashboard;
    public static LinearLayout bookmarks;
    public static LinearLayout orders;
    public static ProgressBar progress;
    RelativeLayout main;
    Boolean isInternetConneted = false;
    TextView tvOrders,tvBookmarks,tvDashboard,appbar_title;
    public static  ImageView dashImg, cartImg, bookmarkImg, notify,help,settings;
    private static final String colorPrimary = "#0087CF";
    private static final String tabSelectedColor = "#07C5FA";
    public Typeface gotham_book, gotham_medium, gotham_bold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        checkInternet();


        orders.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                orders.setElevation(100);
                setUpOrders();
                bookmarks.setElevation(0);
                dashboard.setElevation(0);
            }
        });
        bookmarks.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                bookmarks.setElevation(50);
                setUpBookmark();
                dashboard.setElevation(0);
                orders.setElevation(0);
            }
        });
        dashboard.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                dashboard.setElevation(50);
                setUpDashboard();
                orders.setElevation(0);
                bookmarks.setElevation(0);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                setUpHelp();
                setElevationZero();
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                Intent intent=new Intent(MainActivity.this,NotificationActivity.class);
                startActivity(intent);
                setElevationZero();
                setDeselectedIconsForTabs();
                setNoColor();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                checkInternet();
                setUpSetting();
                setElevationZero();
            }
        });



    }
    public void checkInternet(){
        ConnectionDetector connectionDetector=new ConnectionDetector(getApplicationContext());

        isInternetConneted = connectionDetector.isConnectingToInternet();

        if (isInternetConneted){
            setUpOrders();
        }
        else{
            Snackbar snackbar = Snackbar
                    .make(main, "No internet connection!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    });
            snackbar.setActionTextColor(Color.RED);

            View sbView = snackbar.getView();
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);

            snackbar.show();
        }
    }

    public void init() {

        gotham_book = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getAssets(), "fonts/gothambold1.ttf");

        dashboard =  findViewById(R.id.dashboard);
        orders =  findViewById(R.id.orders);
        bookmarks =  findViewById(R.id.bookmarks);

        progress =  findViewById(R.id.progress);

        tvOrders =  findViewById(R.id.tvOrders);
        tvBookmarks = findViewById(R.id.tvBookmarks);
        tvDashboard =  findViewById(R.id.tvDashboard);

        dashImg =  findViewById(R.id.dashImg);
        cartImg =  findViewById(R.id.cartImg);
        bookmarkImg =  findViewById(R.id.bookmarkImg);


        notify = findViewById(R.id.notify);
        help = findViewById(R.id.help);
        settings =  findViewById(R.id.settings);
        appbar_title =  findViewById(R.id.title_text);

        main =  findViewById(R.id.mainactivity);



    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void setUpOrders() {
        appbar_title.setText("Orders");
        appbar_title.setTypeface(gotham_bold);

        tvOrders.setTypeface(gotham_medium);
        tvBookmarks.setTypeface(gotham_book);
        tvDashboard.setTypeface(gotham_book);
        orders.setElevation(100);

        cartImg.setImageResource(R.drawable.cart_selected);
        bookmarkImg.setImageResource(R.drawable.bookmark_not_selected);
        dashImg.setImageResource(R.drawable.dash_board_not_selected);

        orders.setBackgroundColor(Color.parseColor(tabSelectedColor));
        dashboard.setBackgroundColor(Color.parseColor(colorPrimary));
        bookmarks.setBackgroundColor(Color.parseColor(colorPrimary));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Orders orders = new Orders();
        transaction.replace(R.id.place_holder, orders);
        transaction.commit();

    }
    void setUpBookmark(){
        appbar_title.setText("Bookmarks");
        appbar_title.setTypeface(gotham_bold);

        tvOrders.setTypeface(gotham_book);
        tvBookmarks.setTypeface(gotham_medium);
        tvDashboard.setTypeface(gotham_book);

        bookmarkImg.setImageResource(R.drawable.bookmark_selected);
        dashImg.setImageResource(R.drawable.dash_board_not_selected);
        cartImg.setImageResource(R.drawable.cart_not_selected);

        bookmarks.setBackgroundColor(Color.parseColor(tabSelectedColor));
        dashboard.setBackgroundColor(Color.parseColor(colorPrimary));
        orders.setBackgroundColor(Color.parseColor(colorPrimary));

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Bookmarks bookmarks = new Bookmarks();
        transaction.replace(R.id.place_holder, bookmarks);
        transaction.commit();

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void setUpDashboard(){

        appbar_title.setText("Dashboard");

        tvOrders.setTypeface(gotham_book);
        tvBookmarks.setTypeface(gotham_book);
        tvDashboard.setTypeface(gotham_medium);

        dashImg.setImageResource(R.drawable.dash_board_selected);
        cartImg.setImageResource(R.drawable.cart_not_selected);
        bookmarkImg.setImageResource(R.drawable.bookmark_not_selected);

        dashboard.setBackgroundColor(Color.parseColor(tabSelectedColor));
        orders.setBackgroundColor(Color.parseColor(colorPrimary));
        bookmarks.setBackgroundColor(Color.parseColor(colorPrimary));
        dashboard.setElevation(50);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Dashboard dashboard = new Dashboard();
        transaction.replace(R.id.place_holder, dashboard);
        transaction.commit();

    }

    void setUpHelp(){
        appbar_title.setText("FAQ");
        appbar_title.setTypeface(gotham_bold);
        setDeselectedIconsForTabs();
        setNoColor();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Faq faq = new Faq();
        transaction.replace(R.id.place_holder, faq);
        transaction.commit();

    }
    void setUpSetting(){
        appbar_title.setText("Settings");
        appbar_title.setTypeface(gotham_bold);
        setDeselectedIconsForTabs();
        setNoColor();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Settings settings = new Settings();
        transaction.replace(R.id.place_holder, settings);
        transaction.commit();

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setElevationZero(){
        dashboard.setElevation(0);
        orders.setElevation(0);
        bookmarks.setElevation(0);
    }
    private void setDeselectedIconsForTabs(){
        dashImg.setImageResource(R.drawable.dash_board_not_selected);
        cartImg.setImageResource(R.drawable.cart_not_selected);
        bookmarkImg.setImageResource(R.drawable.bookmark_not_selected);
    }
    public static void setNoColor() {

        dashboard.setBackgroundColor(Color.parseColor(colorPrimary));
        orders.setBackgroundColor(Color.parseColor(colorPrimary));
        bookmarks.setBackgroundColor(Color.parseColor(colorPrimary));

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void orders_df() {

        dashboard.setBackgroundColor(Color.parseColor(colorPrimary));
        orders.setBackgroundColor(Color.parseColor(tabSelectedColor));
        bookmarks.setBackgroundColor(Color.parseColor(colorPrimary));
        orders.setElevation(100);
        bookmarks.setElevation(0);
        dashboard.setElevation(0);
        cartImg.setImageResource(R.drawable.cart_selected);
        bookmarkImg.setImageResource(R.drawable.bookmark_not_selected);
        dashImg.setImageResource(R.drawable.dash_board_not_selected);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
