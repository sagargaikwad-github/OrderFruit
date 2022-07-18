package com.example.orderfruit.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class User_Registration_Activity extends AppCompatActivity {
    EditText name_et, phone_et, password1_et, password2_et;
    Button register_btn;
    String getName,getPhone,getPassword1,getPassword2;
    TextInputLayout nameLayout, phoneLayout, password1Layout, password2Layout;
    TextView already_a_user_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        name_et = findViewById(R.id.reg_name_et);
        nameLayout = findViewById(R.id.name_et_layout);
        phone_et = findViewById(R.id.reg_phone_et);
        phoneLayout = findViewById(R.id.phone_et_layout);

        password1_et = findViewById(R.id.confirmpass_et);
        password1Layout = findViewById(R.id.confirmpass_et_layout);

        password2_et= findViewById(R.id.confirmpass_et_2);
        password2Layout = findViewById(R.id.confirmpass_et_layout_2);

        register_btn = findViewById(R.id.register_btn);
        already_a_user_tv=findViewById(R.id.already_a_user);

        SQLiteData sqLiteData = new SQLiteData(this);

        SharedPreferences User_Registration;
        User_Registration=getSharedPreferences("Registration",MODE_PRIVATE);





        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getName = name_et.getText().toString().trim();
                getPhone = phone_et.getText().toString().trim();
                getPassword1 = password1_et.getText().toString().trim();
                getPassword2 = password2_et.getText().toString().trim();

                if (getName.isEmpty()) {
                    nameLayout.setError("Name Cannot be empty");
                } else if (getPhone.isEmpty() || !getPhone.equals(Patterns.PHONE)) {
                    if (getPhone.isEmpty()) {
                        phoneLayout.setError("Phone Number Required");
                    }
                    else
                    {
                        phonevalid();
                    }
                }



            }

            private void phonevalid() {
                if(Patterns.PHONE.matcher(getPhone).matches() && getPhone.length()>9 && getPhone.length()<11)
                    {
                      checkPassword();
                      phoneLayout.setError(null);
                    }
                   else {
                        phoneLayout.setError("Wrong Phone");
                        phoneLayout.requestFocus();
                    }
                }

            private void checkPassword() {
                if(!getPassword1.equals(getPassword2))
                {
                    password2Layout.setError("Password Does Not Match");
                }
                else
                {
                    Boolean ab=sqLiteData.checkUser(getPhone);
                    if(ab==true)
                    {
                        Toast.makeText(User_Registration_Activity.this, "User Already exist", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        passwordvalid();
                    }
                }
            }

            private void passwordvalid() {
                if(getPassword1.length()<8 && getPassword2.length()<8)
                {
                    password1Layout.setError("Password Must be 8 Characters");
                    password2Layout.setError("Password Must be 8 Characters");
                }
                else
                {
                    sqLiteData.new_user(getName,getPhone,getPassword2);
                    Intent intent=new Intent(User_Registration_Activity.this,User_Login_Activity.class);
                    startActivity(intent);

                    String isRegister="Register";
                    SharedPreferences.Editor myEdit=User_Registration.edit();
                    myEdit.putString("Register",isRegister);
                    myEdit.apply();


                    Toast.makeText(User_Registration_Activity.this, "Record Added Sucessfully", Toast.LENGTH_SHORT).show();
                }
            }

        });
        already_a_user_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(User_Registration_Activity.this,User_Login_Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(User_Registration_Activity.this)
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