package example.com.essitrack_clone_nd.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import example.com.essitrack_clone_nd.LoginActivity;
import example.com.essitrack_clone_nd.MainActivity;
import example.com.essitrack_clone_nd.R;
import example.com.essitrack_clone_nd.helper.SharedPref;

/**
 * A simple {@link Fragment} subclass.
 */

public class Settings extends Fragment {
public LinearLayout logoutImg;
SharedPref sharedp;
    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.settings, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logoutImg=view.findViewById(R.id.logOut);
        sharedp = new SharedPref(getContext());
        logoutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedp.removePrefs();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                getActivity().finish();
            }
        });
    }
}
