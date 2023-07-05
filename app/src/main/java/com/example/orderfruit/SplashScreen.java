package com.example.orderfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.orderfruit.user.User_Login_Activity;
import com.example.orderfruit.user.User_Registration_Activity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences User_Registration;
                User_Registration=getSharedPreferences("Registration",MODE_PRIVATE);
                String shared_pref=User_Registration.getString("Register"," ");


                SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
                String isLogin=sharedPreferences.getString("Login"," ");



                if(isLogin.contains("Login"))
                {
                    Intent intent1=new Intent(SplashScreen.this, Dashboard_Activity.class);
                    startActivity(intent1);
                    SplashScreen.this.finish();
                }
                else
                {
                    if(shared_pref.contains("Register"))
                    {
                        Intent intent1=new Intent(SplashScreen.this,User_Login_Activity.class);
                        startActivity(intent1);
                        SplashScreen.this.finish();
                    }
                    else
                    {
                        Intent intent1=new Intent(SplashScreen.this, User_Registration_Activity.class);
                        startActivity(intent1);
                        SplashScreen.this.finish();
                    }
                }

            }
           },1800);
    }

}