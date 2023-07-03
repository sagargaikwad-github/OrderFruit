package com.example.orderfruit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputLayout;

public class User_Login_Activity extends AppCompatActivity {
    TextInputLayout user_login_layout,user_password_layout;
    EditText user_login_et,user_password_et;
    String username,password;
    Button login_btn;
    TextView new_user_tv,forget_password_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        user_login_layout=findViewById(R.id.user_login_layout);
        user_password_layout=findViewById(R.id.user_password_layout);

        user_login_et=findViewById(R.id.user_login_et);
        user_password_et=findViewById(R.id.user_password_et);
        login_btn=findViewById(R.id.login_btn);
        new_user_tv=findViewById(R.id.new_user_tv);
        forget_password_tv =findViewById(R.id.forget_password);


        //sqLiteData=new SQLiteData(User_Login_Activity.this);
        CommonDB commonDB = CommonDB.getDB(this);

        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=user_login_et.getText().toString().trim();
                password=user_password_et.getText().toString().trim();

                if(username.isEmpty())
                {
                    user_login_layout.setError("Please Provide username");
                }
                else if(!username.isEmpty())
                {
                   // boolean checkuser=sqLiteData.checkUser(login);
                    boolean checkuser=commonDB.registrationDAO().validUser(username);

                    if(checkuser==true)
                    {
                        boolean checkLogin=commonDB.registrationDAO().login(username,password);

                        if(checkLogin==true)
                        {
                            String isLogin="Login";
                            SharedPreferences.Editor editor=sharedPreferences.edit();
                            editor.putString("Login",isLogin);
                            editor.apply();

                            Toast.makeText(User_Login_Activity.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(User_Login_Activity.this, Dashboard_Activity.class);
                            intent.putExtra("IsLogin",username);
                            startActivity(intent);
                            //sqLiteData.UpdateLogin(username,1);
                            commonDB.registrationDAO().updateLogin(username,1);
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

        new_user_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Login_Activity.this,User_Registration_Activity.class);
                startActivity(intent);
            }
        });

        forget_password_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Login_Activity.this,User_Forget_Password.class);
                startActivity(intent);
            }
        });






    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(User_Login_Activity.this)
                .setMessage("Do You Want to exit ? ")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}