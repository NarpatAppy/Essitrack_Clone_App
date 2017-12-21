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
    TextView referenceno;
    ImageView backBtn, bookMarkBtn;

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

        gotham_book = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book.ttf");
        gotham_medium = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Medium.ttf");
        gotham_bold = Typeface.createFromAsset(getAssets(), "fonts/gothambold1.ttf");

        referenceno = findViewById(R.id.referenceno);
        bookMarkBtn =  findViewById(R.id.ivStar);
        backBtn =  findViewById(R.id.back_btn);
    }
}
