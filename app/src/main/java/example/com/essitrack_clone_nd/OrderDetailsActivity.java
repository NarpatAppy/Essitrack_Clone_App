package example.com.essitrack_clone_nd;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

public class OrderDetailsActivity extends AppCompatActivity {
    public Typeface gotham_book, gotham_medium, gotham_bold;
    TextView tvDeliverBy,entryOnLabel,order_track,order_refer,order_date,status_id,late_id,orderR,orderRR,orderL,orderLL,edging,edginge,sph;
    TextView cyl,add,axis,pr,pr1,pr2,pr3,pr4,pl,pl1,pl2,pl3,pl4;
    TextView customer_code, customer_name, entryOnVal;
    ImageView backBtn, bookMarkBtn;

    LinearLayout prodDet;
    ProgressBar progressBarod;
    ScrollView scrollView;
    double dpc;
    TextView tvDetails,tvCustomerCode,tvCustomerName,tvPrescription;
    private TextView pupilliaryDistanceLabel, monocularHeightLabel, pupDistR, monHR, pupDistL, monHL;
    private TextView descriptionHeader, descriptionVal;
    TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        init();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        bookMarkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void init(){
        progressBarod = findViewById(R.id.progressBar);

        gotham_book = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getAssets(), "fonts/gothambold1.ttf");

        entryOnVal =  findViewById(R.id.entryDate);
        entryOnVal.setTypeface(gotham_book);
        tvDetails=  findViewById(R.id.tvDetails);
        tvDetails.setTypeface(gotham_medium);
        tvCustomerCode=  findViewById(R.id.tvCustomerCode);
        tvCustomerCode.setTypeface(gotham_medium);
        pupilliaryDistanceLabel =  findViewById(R.id.pupilliaryDistance);
        pupilliaryDistanceLabel.setTypeface(gotham_book);
        monocularHeightLabel = findViewById(R.id.monocularHeight);
        monocularHeightLabel.setTypeface(gotham_book);
        pupDistR =  findViewById(R.id.pupDistR);
        monHR =  findViewById(R.id.monHR);
        pupDistL =  findViewById(R.id.pupDistL);
        monHL =  findViewById(R.id.monHL);
        descriptionHeader =  findViewById(R.id.descriptionHeader);
        descriptionHeader.setTypeface(gotham_medium);
        descriptionVal =  findViewById(R.id.descriptionVal);
        descriptionVal.setTypeface(gotham_book);
        title_text=  findViewById(R.id.title_text);
        title_text.setTypeface(gotham_bold);
        tvCustomerName=  findViewById(R.id.tvCustomerName);
        tvCustomerName.setTypeface(gotham_medium);
        tvPrescription=  findViewById(R.id.tvPrescription);
        tvPrescription.setTypeface(gotham_medium);
        bookMarkBtn =  findViewById(R.id.st2);


        order_track =  findViewById(R.id.order_tracking);
        order_track.setTypeface(gotham_book);
        tvDeliverBy=  findViewById(R.id.tvDeliverBy);
        tvDeliverBy.setTypeface(gotham_book);
        order_refer =  findViewById(R.id.order_reference);
        order_refer.setTypeface(gotham_medium);
        order_date =  findViewById(R.id.order_date);
        order_date.setTypeface(gotham_book);
        entryOnLabel=  findViewById(R.id.entryOnLabel);
        entryOnLabel.setTypeface(gotham_book);
        status_id =  findViewById(R.id.status_id);
        status_id.setTypeface(gotham_medium);
        late_id =  findViewById(R.id.late_id);
        orderR =  findViewById(R.id.orderR);
        orderR.setTypeface(gotham_medium);
        orderRR =  findViewById(R.id.orderRR);
        orderRR.setTypeface(gotham_book);
        orderL =  findViewById(R.id.orderL);
        orderL.setTypeface(gotham_medium);
        orderLL =  findViewById(R.id.orderLL);
        orderLL.setTypeface(gotham_book);
        edging =  findViewById(R.id.edging);
        edging.setTypeface(gotham_book);
        edginge =  findViewById(R.id.edginge);
        edginge.setTypeface(gotham_book);

        sph =  findViewById(R.id.sph);
        sph.setTypeface(gotham_book);
        cyl =  findViewById(R.id.cyl);
        cyl.setTypeface(gotham_book);
        add =  findViewById(R.id.add);
        add.setTypeface(gotham_book);
        axis =  findViewById(R.id.axis);
        axis.setTypeface(gotham_book);
        pr =  findViewById(R.id.pr);
        pr.setTypeface(gotham_book);
        pr1 =  findViewById(R.id.pr1);
        pr1.setTypeface(gotham_book);
        pr2 =  findViewById(R.id.pr2);
        pr2.setTypeface(gotham_book);
        pr3 =  findViewById(R.id.pr3);
        pr3.setTypeface(gotham_book);
        pr4 =  findViewById(R.id.pr4);
        pr4.setTypeface(gotham_book);
        pl =  findViewById(R.id.pl);
        pl.setTypeface(gotham_book);
        pl1 =  findViewById(R.id.pl1);
        pl1.setTypeface(gotham_book);
        pl2 =  findViewById(R.id.pl2);
        pl2.setTypeface(gotham_book);
        pl3 =  findViewById(R.id.pl3);
        pl3.setTypeface(gotham_book);
        pl4 =  findViewById(R.id.pl4);
        pl4.setTypeface(gotham_book);
        prodDet =  findViewById(R.id.prod_desc);
        customer_code =  findViewById(R.id.customercode);
        customer_code.setTypeface(gotham_book);
        tvCustomerCode.setTypeface(gotham_medium);
        customer_name =  findViewById(R.id.customer_name);
        customer_name.setTypeface(gotham_book);
        backBtn =  findViewById(R.id.back_btn);
        scrollView =  findViewById(R.id.scrollBar);
    }
}
