package com.example.orderfruit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfruit.Dashboard_Activity;
import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputLayout;

public class User_Login_Activity extends AppCompatActivity {
    TextInputLayout user_login_layout,user_password_layout;
    EditText user_login_et,user_password_et;
    String login,password;
    Button login_btn;
    TextView new_user,forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        user_login_layout=findViewById(R.id.user_login_layout);
        user_password_layout=findViewById(R.id.user_password_layout);

        user_login_et=findViewById(R.id.user_login_et);
        user_password_et=findViewById(R.id.user_password_et);
        login_btn=findViewById(R.id.login_btn);
        new_user=findViewById(R.id.new_user_tv);
        forget_password=findViewById(R.id.forget_password);


        SQLiteData sqLiteData=new SQLiteData(User_Login_Activity.this);

        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login=user_login_et.getText().toString().trim();
                password=user_password_et.getText().toString().trim();

                if(login.isEmpty())
                {
                    user_login_layout.setError("Please Provide username");
                }
                else if(!login.isEmpty())
                {
                    boolean checkuser=sqLiteData.checkUser(login);
                    if(checkuser==true)
                    {
                        boolean checkLogin=sqLiteData.login(login,password);
                        if(checkLogin==true)
                        {
                            String isLogin="Login";
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("Login",isLogin);
                            editor.apply();

                            Toast.makeText(User_Login_Activity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(User_Login_Activity.this, Dashboard_Activity.class);
                            intent.putExtra("IsLogin",login);
                            startActivity(intent);
                            sqLiteData.UpdateLogin(login,1);
                        }
                        else
                        {
                            Toast.makeText(User_Login_Activity.this, "Wrong Username and Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(User_Login_Activity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                    }

                }
                else if(password.isEmpty())
                {
                    user_password_layout.setError("Please Provide password");
                }

            }
        });

        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Login_Activity.this,User_Registration_Activity.class);
                startActivity(intent);
            }
        });

        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Login_Activity.this,User_Forget_Password.class);
                startActivity(intent);
            }
        });






    }
    @Override
    public void finish() {
        finishAffinity();
    }
}