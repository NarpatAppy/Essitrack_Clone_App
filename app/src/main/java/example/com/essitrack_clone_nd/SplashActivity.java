package example.com.essitrack_clone_nd;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import example.com.essitrack_clone_nd.helper.SharedPref;

/**
 * Created by Appiness-Mob on 11/13/2017.
 */

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;

    SharedPref sharedPref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPref=new SharedPref(getApplicationContext());

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);


        if (getIntent().getBooleanExtra("EXIT",false)){
            finish();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                 /*
                 * if user login test is true on oncreate then redirect the user
                 * to result page
                 */
                Intent intent;
                String val=sharedPref.getPref("loginstatus");
                 if (val!=null && val.equals("login")){
                      intent=new Intent(getApplicationContext(),MainActivity.class);

                 }
                 else if (sharedPref.isFirstTimeLaunch()) {
                      intent = new Intent(getApplicationContext(),IntroActivity.class);

                 }else {
                      intent = new Intent(getApplicationContext(),LoginActivity.class);

                 }

                startActivity(intent);
                finish();

                }

        },SPLASH_TIME_OUT);
    }
}
