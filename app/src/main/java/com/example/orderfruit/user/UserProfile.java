package com.example.orderfruit.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderfruit.R;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {
    ImageView AddNew_IV,UserProfile_IV;
    TextInputLayout NameLayout,PhoneLayout,AddressLayout,Address2Layout;
    TextInputEditText NameEditText,PhoneEditText,AddressEditText,Address2EditText;
    Button SaveBtn;

    String getName,getAddress,getAddress2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("User Profile");

        UserProfile_IV=findViewById(R.id.userProfileIV);
        AddNew_IV=findViewById(R.id.AddNew_IV);
        SaveBtn=findViewById(R.id.userProfileSaveBTN);

        NameLayout=findViewById(R.id.nameTLayout);
        NameEditText=findViewById(R.id.nameTBox);

        PhoneLayout=findViewById(R.id.phoneTLayout);
        PhoneEditText=findViewById(R.id.phoneTBox);

        AddressLayout=findViewById(R.id.addressTLayout);
        AddressEditText=findViewById(R.id.addressTBox);

        Address2Layout=findViewById(R.id.address2TLayout);
        Address2EditText=findViewById(R.id.address2TBox);

        Bundle b=getIntent().getExtras();
        String name=b.getString("User_Name");
        String phone=b.getString("User_Phone");
        String address1=b.getString("User_Address");
        String address2=b.getString("User_Address2");

        NameEditText.setText(name);
        PhoneEditText.setText(phone);
        AddressEditText.setText(address1);
        Address2EditText.setText(address2);

        AddNew_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 1);
            }
        });

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 getName=NameEditText.getText().toString();
                 getAddress=AddressEditText.getText().toString();
                 getAddress2=Address2EditText.getText().toString();

                if(getName==null || getName.isEmpty())
                {
                    NameLayout.setError("Please Provide Name");
                }
                else
                {
                    String getPhone=PhoneEditText.getText().toString();
                    getPhone(getPhone);
                }
            }
        });

    }

    private void getPhone(String getPhone) {
      if(getPhone.length()<9|| getPhone.length()>11)
      {
          PhoneLayout.setError("Phone Number Invalid");
      }
      else
      {
          Toast.makeText(this, "Profile Saved Sucessfully", Toast.LENGTH_SHORT).show();
          SQLiteData sqLiteData=new SQLiteData(this);
         sqLiteData.User_info(getName,getPhone, getAddress,getAddress2, null, null, null);



      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null)
        {
            Uri selectedImage=data.getData();
            UserProfile_IV.setImageURI(selectedImage);
        }
    }
}