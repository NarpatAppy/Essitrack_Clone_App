package example.com.essitrack_clone_nd.helper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import example.com.essitrack_clone_nd.IntroActivity;

/**
 * Created by Appy-Sales on 20-12-2017.
 */

public class SharedPref {

    Context _context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "intro_slider-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public SharedPref(Context context) {
        this._context = context;
        sharedPreferences = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }


    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setPref(String key,String value)
    {
        editor.putString(key,value);
        editor.apply();
    }
    public String getPref(String key)
    {
        return sharedPreferences.getString(key,"");
    }

    public void removePrefs()
    {
        editor.clear();
        editor.commit();

        Intent intent=new Intent(_context, IntroActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        _context.startActivity(intent);

    }

}
