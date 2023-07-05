package com.example.orderfruit.user;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderfruit.Dashboard_Activity;
import com.example.orderfruit.R;
import com.example.orderfruit.RoomDB.CommonDB;
import com.example.orderfruit.RoomDB.Registration.RegistrationModel;
import com.example.orderfruit.model.SQLiteData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {
    ImageView AddNew_IV, UserProfile_IV;
    TextInputLayout NameLayout, PhoneLayout, AddressLayout, Address2Layout;
    TextInputEditText NameEditText, PhoneEditText, AddressEditText, Address2EditText;
    Button SaveBtn;
    String phone;
    byte[] img1;

    String getName, getAddress, getAddress2;

    CommonDB commonDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        UserProfile_IV = findViewById(R.id.userProfileIV);
        AddNew_IV = findViewById(R.id.AddNew_IV);
        SaveBtn = findViewById(R.id.userProfileSaveBTN);

        NameLayout = findViewById(R.id.nameTLayout);
        NameEditText = findViewById(R.id.nameTBox);

        PhoneLayout = findViewById(R.id.phoneTLayout);
        PhoneEditText = findViewById(R.id.phoneTBox);

        AddressLayout = findViewById(R.id.addressTLayout);
        AddressEditText = findViewById(R.id.addressTBox);

        Address2Layout = findViewById(R.id.address2TLayout);
        Address2EditText = findViewById(R.id.address2TBox);

        Bundle b = getIntent().getExtras();
        String name = b.getString("User_Name");
        phone = b.getString("User_Phone");
        String address1 = b.getString("User_Address");
        String address2 = b.getString("User_Address2");


        NameEditText.setText(name);
        PhoneEditText.setText(phone);
        AddressEditText.setText(address1);
        Address2EditText.setText(address2);

        Toolbar nav_toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(nav_toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        actionBar.setDisplayHomeAsUpEnabled(true);

        SQLiteData sqLiteData = new SQLiteData(UserProfile.this);

        commonDB=CommonDB.getDB(this);

        ArrayList<RegistrationModel> arrayList = (ArrayList<RegistrationModel>) commonDB.registrationDAO().userData();

//        Cursor res = sqLiteData.search(phone);
//        if (res.moveToFirst()) {
//            do {
        byte[] bytes = arrayList.get(0).getImage();
//                if (bytes != null) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        UserProfile_IV.setImageBitmap(bitmap);
//                }
//
//            } while (res.moveToNext());
//        } else {
//            Toast.makeText(UserProfile.this, "Data Not Found", Toast.LENGTH_SHORT).show();
//        }


        AddNew_IV.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                } else {
                    Intent gallartintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(gallartintent, 1);

                }
            }
        });

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getName = NameEditText.getText().toString();
                getAddress = AddressEditText.getText().toString();
                getAddress2 = Address2EditText.getText().toString();

                if (getName == null || getName.isEmpty()) {
                    NameLayout.setError("Please Provide Name");
                } else {
                    String getPhone = PhoneEditText.getText().toString();
                    UpdateProfile(getPhone);


                }
            }
        });

    }

    private void UpdateProfile(String getPhone) {
        if (getPhone.length() < 9 || getPhone.length() > 11) {
            PhoneLayout.setError("Phone Number Invalid");
        } else {
            Toast.makeText(this, "Profile Saved Sucessfully", Toast.LENGTH_SHORT).show();
            SQLiteData sqLiteData = new SQLiteData(this);
            //sqLiteData.User_info(getName, getPhone, getAddress, getAddress2, null, null, null);

            BitmapDrawable drawable = (BitmapDrawable) UserProfile_IV.getDrawable();
            Bitmap bitmap1 = drawable.getBitmap();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            bitmap1.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            byte[] img11 = byteArrayOutputStream.toByteArray();

            // SQLiteData sqlIteData = new SQLiteData(UserProfile.this);

            commonDB.registrationDAO().updateProfileData(getName, getPhone, getAddress, getAddress2, img11);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, 1);
                } else {
                    Toast.makeText(UserProfile.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
                //Uri selectedImage = data.getData();
                // UserProfile_IV.setImageURI(selectedImage);

                Uri selectedImage = data.getData();

                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                if (selectedImage != null) {
                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        String picturePath = cursor.getString(columnIndex);
                        Bitmap bv = (BitmapFactory.decodeFile(picturePath));
                        cursor.close();


                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        // bv.compress(Bitmap.CompressFormat.PNG, 20, byteArrayOutputStream);
                        bv.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        img1 = byteArrayOutputStream.toByteArray();


                        UserProfile_IV.setImageBitmap(bv);


//                        SQLiteData sqLiteData=new SQLiteData(UserProfile.this);
//                        Cursor res=sqLiteData.search(phone);
//                        if(res.moveToFirst())
//                        {
//                            do{
//                                byte[] bytes=res.getBlob(8);
//
//                                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                                    //UserProfile_IV.setImageBitmap(bitmap);
//                                    UserProfile_IV.setImageBitmap(bv);
//
//
//                            }while(res.moveToNext());
//                        }
//                        else {
//                            Toast.makeText(UserProfile.this, "Data Not Found", Toast.LENGTH_SHORT).show();
//                        }

                        Bitmap myBitmap = BitmapFactory.decodeFile(picturePath);
                        ExifInterface exif = new ExifInterface(picturePath);
                        int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
                        int rotationInDegrees = exifToDegrees(rotation);
                        int deg = rotationInDegrees;
                        Matrix matrix = new Matrix();
                        if (rotation != 0f) {
                            matrix.preRotate(rotationInDegrees);
                            myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true);
                            UserProfile_IV.setImageBitmap(myBitmap);
                        }
                    }
                }
            }
        } catch (Exception e) {

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return true;
    }

    private static int exifToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }
}
