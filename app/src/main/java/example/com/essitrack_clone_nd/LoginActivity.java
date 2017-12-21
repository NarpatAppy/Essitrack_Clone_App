package example.com.essitrack_clone_nd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import example.com.essitrack_clone_nd.helper.SharedPref;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    public static ProgressBar progressBar1;
    public static Button sign_in;
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPref=new SharedPref(this);

        sign_in =  findViewById(R.id.sign_in);
        username =  findViewById(R.id.username);
        password =  findViewById(R.id.password);
        progressBar1 = findViewById(R.id.progressBar1);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_UserName = username.getText().toString();
                String str_Password = password.getText().toString();

                if (str_UserName.length()>0 & str_Password.length()>0){

                    if (str_UserName.equals("admin") && str_Password.equals("admin"))
                    {
                        sharedPref.setPref("loginstatus","login");
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "Details does not belongs to any account", Toast.LENGTH_LONG).show();
                    }
                }else if (str_UserName.length()==0){

                    Toast.makeText(getApplicationContext(),
                            "Please enter your User Name!", Toast.LENGTH_LONG).show();

                }else if (str_Password.length()==0){

                    Toast.makeText(getApplicationContext(),
                            "Please enter your Password!", Toast.LENGTH_LONG).show();
                }else{


                }


            }
        });
    }
}
