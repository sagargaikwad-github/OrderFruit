package com.example.orderfruit.user;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfruit.R;
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.Registration.RegistrationModel;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputLayout;

import java.nio.file.FileVisitOption;
import java.util.ArrayList;

public class User_Forget_Password extends AppCompatActivity {
    TextInputLayout phone_layout, name_layout;
    EditText phone_et, name_et;
    Button find_btn;
    TextView backtologin_tv, username_password_display_tv;
    String getPhone, getName;

    CommonDB commonDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_forget_password);

        phone_layout = findViewById(R.id.forget_login_layout);
        phone_et = findViewById(R.id.forget_login_et);

        name_layout = findViewById(R.id.forget_name_layout);
        name_et = findViewById(R.id.forget_name_et);

        find_btn = findViewById(R.id.find_account);

        backtologin_tv = findViewById(R.id.back_to_login);
//        username_password_display = findViewById(R.id.display_info);

        commonDB = CommonDB.getDB(this);

      //  SQLiteData sqLiteData = new SQLiteData(this);

        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPhone = phone_et.getText().toString().trim();
                getName = name_et.getText().toString().trim();

                boolean checkAccount = commonDB.registrationDAO().checkAccount(getPhone, getName);


                boolean checkuser = commonDB.registrationDAO().checkUser(getPhone);

                if (getPhone.isEmpty()) {
                    phone_layout.setError("Please Enter Your Phone");
                } else if (getName.isEmpty()) {
                    name_layout.setError("Please Provide Name");
                } else if (checkuser == false) {
                    Toast.makeText(User_Forget_Password.this, "User not exist with this number", Toast.LENGTH_SHORT).show();
                } else if (checkAccount == false) {
                    Toast.makeText(User_Forget_Password.this, "Name does not match", Toast.LENGTH_SHORT).show();
                } else {
                  //  Cursor getacc = sqLiteData.getAccount(getPhone, getName);

                    ArrayList<RegistrationModel> arrayList = (ArrayList<RegistrationModel>) commonDB.registrationDAO().getAccount(getPhone, getName);

                    // if (!(getacc==null)) {
                    //Cursor acc = sqLiteData.checkAccount(getPhone, getName);
                    //   if (getacc.moveToFirst()) {
//                            do {
                    String a = arrayList.get(0).getPhone();
                    String c = arrayList.get(0).getPassword();
                    //username_password_display.setText("Id are :" + a + "\n" + "Password are :" + c);

                    AlertDialog alertDialog = new AlertDialog.Builder(User_Forget_Password.this)
                            .setTitle("Id and Password are,")
                            .setPositiveButton("ok", null)
                            .setMessage("Username : " + a + "\n" + "Password : " + c)
                            .show();
                    //  } while (getacc.moveToNext());

                    //}
                    // }
                }

            }
        });
        backtologin_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Forget_Password.this, User_Login_Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void finish() {
        super.finish();
    }
}


//else {
//                    boolean checkForgetAccount = sqLiteData.checkForgetAccount(getPhone, getPhone);
//                   Cursor checkAccount=sqLiteData.checkAccount(getPhone,getName);

