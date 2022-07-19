package com.example.orderfruit.viewfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.orderfruit.R;
import com.example.orderfruit.cart.ViewCart;
import com.example.orderfruit.model.SQLiteData;

public class FruitViewActivity extends AppCompatActivity {
    TextView fruitname,fruitprice,fruitdesc1,fruitdesc2,fruitdesc3,fruitdesc4,fruitcart,fruitview_advantage,fruitview_add_to_cart_num;
    ImageView fruitimage_IV,fruitfavourite_IV;
    int favourite;
    ImageView plus_IV,minus_IV;
    Button add_to_cart_btn, buy_now_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fruitname=findViewById(R.id.fruitview_name);
        fruitimage_IV=findViewById(R.id.fruitview_image);
        fruitprice=findViewById(R.id.fruitview_price);
        fruitdesc1=findViewById(R.id.fruitview_description1);
        fruitdesc2=findViewById(R.id.fruitview_description2);
        fruitdesc3=findViewById(R.id.fruitview_description3);
        fruitdesc4=findViewById(R.id.fruitview_description4);
        fruitcart=findViewById(R.id.fruitview_add_to_cart_num);
        fruitview_advantage=findViewById(R.id.fruitview_advatage);
        fruitfavourite_IV=findViewById(R.id.fruiteview_favourite_view);


        fruitview_add_to_cart_num=findViewById(R.id.fruitview_add_to_cart_num);
        add_to_cart_btn=findViewById(R.id.fruitview_addtocart_btn);
        buy_now_btn=findViewById(R.id.fruitview_buynow_btn);


        plus_IV=findViewById(R.id.fruitview_add_btn);
        minus_IV=findViewById(R.id.fruitview_remove_btn);

        Bundle bundle=getIntent().getExtras();

        int id=bundle.getInt("FruitID");
        String name=bundle.getString("FruitName");
        int price= (int) bundle.get("FruitPrice");
        favourite=bundle.getInt("FruitFav");
        String desc1=bundle.getString("FruitDesc1");
        String desc2=bundle.getString("FruitDesc2");
        String desc3=bundle.getString("FruitDesc3");
        String desc4=bundle.getString("FruitDesc4");
        int addtocart=bundle.getInt("FruitCart");

        getSupportActionBar().setTitle(name);

        fruitname.setText(name);
        fruitprice.setText("₹ "+String.valueOf(price)+" /"+"kg");
        fruitdesc1.setText(desc1);
        fruitdesc2.setText(desc2);
        fruitdesc3.setText(desc3);
        fruitdesc4.setText(desc4);
        fruitcart.setText(String.valueOf(addtocart));
        fruitview_advantage.setText("Advantages of a "+name+" :");

        if(favourite==1)
        {
            fruitfavourite_IV.setImageResource(R.drawable.favourite_red);
        }
        else
        {
            fruitfavourite_IV.setImageResource(R.drawable.favourite_black);
        }

        switch (id)
        {
            case 0:
                Glide.with(this).load("https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg").into(fruitimage_IV);
                break;
            case 1:
                Glide.with(this).load("https://img.freepik.com/free-photo/ripe-mango-with-green-leaf-isolated-white_252965-183.jpg?w=2000").into(fruitimage_IV);
                break;
            case 2:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ba_jv0CRWew2quncYET-VszSeDU5vyzLTg&usqp=CAU").into(fruitimage_IV);
                break;
            case 3:
                Glide.with(this).load("https://5.imimg.com/data5/SELLER/Default/2021/1/LZ/GA/HD/10023771/custard-apple-500x500.jpg").into(fruitimage_IV);
                break;
            case 4:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6JcjkDzmMTlwEQ6OM4EIxqyI6bNDjOaRtuw&usqp=CAU").into(fruitimage_IV);
                break;
            case 5:
                Glide.with(this).load("https://media.istockphoto.com/photos/green-grape-isolated-on-white-background-picture-id489520104?k=20&m=489520104&s=612x612&w=0&h=n1_B8jn9fb4dQibPhkXftNpjKA4Rvrjp_ttgj6sq5jY=").into(fruitimage_IV);
                break;
            case 6:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQH5yRyd4QWC2dnOCDy7UkauJz8ymbzeqg41A&usqp=CAU").into(fruitimage_IV);
                break;
            case 7:
                Glide.with(this).load("https://media.istockphoto.com/photos/star-fruit-carambola-or-star-apple-picture-id639667582").into(fruitimage_IV);
                break;
            case 8:
                Glide.with(this).load("https://thekitchencommunity.org/wp-content/uploads/2021/09/What-Does-Guava-Taste-Like.jpg").into(fruitimage_IV);
                break;
            case 9:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaAXtZXW0NwXfeThZW9BbWaT36At6cOjfv4Q&usqp=CAU").into(fruitimage_IV);
                break;
            case 10:
                Glide.with(this).load("https://befreshcorp.net/wp-content/uploads/2017/07/product-packshot-Lychee.jpg").into(fruitimage_IV);
                break;
            case 11:
                Glide.with(this).load("https://cdn.shopify.com/s/files/1/0095/6258/7195/products/babybanana.jpg?v=1610171751").into(fruitimage_IV);
                break;
            case 12:
                Glide.with(this).load("https://5.imimg.com/data5/WK/JQ/MY-25358554/walnut-in-shell-500x500.jpg").into(fruitimage_IV);
                break;
            case 13:
                Glide.with(this).load("https://m.media-amazon.com/images/I/41O+ipEyywL.jpg").into(fruitimage_IV);
                break;
            case 14:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyNTj6FoEDJ1UV6CUcFGsrK4wwz5gw-Js8Ag&usqp=CAU").into(fruitimage_IV);
                break;
            case 15:
                Glide.with(this).load("https://m.media-amazon.com/images/I/41SfsqsdqwL.jpg").into(fruitimage_IV);
                break;
            case 16:
                Glide.with(this).load("https://media.istockphoto.com/photos/golden-delicious-apples-picture-id628592448").into(fruitimage_IV);
                break;
            case 17:
                Glide.with(this).load("https://5.imimg.com/data5/RI/NH/MY-50344271/natural-fresh-blueberry-500x500.jpg").into(fruitimage_IV);
                break;
            case 18:
                Glide.with(this).load("https://www.bigbasket.com/media/uploads/p/xxl/40174618_4-fresho-pear-beauty.jpg").into(fruitimage_IV);
                break;
            case 19:
                Glide.with(this).load("https://img.freepik.com/free-photo/tamarind-with-green-leaves-isolated-white-surface_252965-220.jpg?w=2000").into(fruitimage_IV);
                break;
            case 20:
                Glide.with(this).load("https://m.media-amazon.com/images/I/61ZsRkrjB9L._AC_SL1000_.jpg").into(fruitimage_IV);
                break;
            case 21:
                Glide.with(this).load("https://media.istockphoto.com/photos/rose-apples-isolated-on-white-picture-id1216054107?k=20&m=1216054107&s=612x612&w=0&h=kZJC0g7mJKdQyuNbCvxyQfknFgXC4030wKP2ueMClts=").into(fruitimage_IV);
                break;
            case 22:
                Glide.with(this).load("https://cdn-prod.medicalnewstoday.com/content/images/articles/320/320894/strawberry-on-white-background-to-represent-strawberry-tongue.jpg").into(fruitimage_IV);
                break;
            case 23:
                Glide.with(this).load("https://www.bigbasket.com/media/uploads/p/l/10000393-2_1-fresho-apple-ambri.jpg").into(fruitimage_IV);
                break;
            case 24:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAJLtcRQMP4mZvDbnL_mi2oSKAxAoxGjfqcg&usqp=CAU").into(fruitimage_IV);
                break;
            case 25:
                Glide.with(this).load("https://www.bigbasket.com/media/uploads/p/l/20003958_2-fresho-ber-apple.jpg").into(fruitimage_IV);
                break;
            case 26:
                Glide.with(this).load("https://cdn.shopify.com/s/files/1/0269/8258/0311/products/kashmir-online-store-figs-anjeer-medium_1024x.jpg?v=1637237373").into(fruitimage_IV);
                break;
            case 27:
                Glide.with(this).load("https://healthandhealthier.com/wp-content/uploads/2021/08/U730a0a83209a40099160552f88f67df3X-1.jpg").into(fruitimage_IV);
                break;
            case 28:
                Glide.with(this).load("https://m.media-amazon.com/images/I/41xd6R3u+JL.jpg").into(fruitimage_IV);
                break;
            case 29:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_gfknm8XIU34szbAixZJXMA7WYhctmdwzlA&usqp=CAU").into(fruitimage_IV);
                break;
            case 30:
                Glide.with(this).load("https://www.gardeningknowhow.com/wp-content/uploads/2019/04/granny-smith.jpg").into(fruitimage_IV);
                break;
            case 31:
                Glide.with(this).load("https://rukminim1.flixcart.com/image/416/416/l0r1j0w0/plant-seed/z/9/o/25-mm-1571-paudha-original-imagcguesgtkumag.jpeg?q=70").into(fruitimage_IV);
                break;
            case 32:
                Glide.with(this).load("https://static.libertyprim.com/files/familles/cerise-large.jpg?1569271737").into(fruitimage_IV);
                break;
            case 33:
                Glide.with(this).load("https://www.jiomart.com/images/product/original/590009518/mango-totapuri-4-pcs-approx-1200-g-1400-g-product-images-o590009518-p590177429-0-202204261843.jpg").into(fruitimage_IV);
                break;
            case 34:
                Glide.with(this).load("https://t4.ftcdn.net/jpg/02/05/54/21/360_F_205542149_0eVGb8CPmZXY9mjv48O5EcW94XiPdNmT.jpg").into(fruitimage_IV);
                break;
            case 35:
                Glide.with(this).load("https://cdn.shopify.com/s/files/1/0364/0465/8313/products/manzano_bananas_1lb_order247_canada.jpg?v=1618060394").into(fruitimage_IV);
                break;
            case 36:
                Glide.with(this).load("https://shyamamart.com/wp-content/uploads/2020/09/511786528a5a-84.png").into(fruitimage_IV);
                break;
            case 37:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_45DeGaoCSVhM8P7s29Ad2mN9ModVQuErFA&usqp=CAU").into(fruitimage_IV);
                break;
            case 38:
                Glide.with(this).load("https://5.imimg.com/data5/ZS/DW/OR/GLADMIN-11866148/selection-410-500x500.png").into(fruitimage_IV);
                break;
            case 39:
                Glide.with(this).load("https://i0.wp.com/www.ratnagirialphonsomango.com/wp-content/uploads/2017/10/buy-ratnagiri-alphonso-mango-e1648136287916.jpg?fit=564%2C440&ssl=1").into(fruitimage_IV);
                break;
            case 40:
                Glide.with(this).load("https://media.istockphoto.com/photos/red-apple-picture-id184276818?k=20&m=184276818&s=612x612&w=0&h=QxOcueqAUVTdiJ7DVoCu-BkNCIuwliPEgtAQhgvBA_g=").into(fruitimage_IV);
                break;
            case 41:
                Glide.with(this).load("https://www.collinsdictionary.com/images/full/raspberry_96055874.jpg").into(fruitimage_IV);
                break;
            case 42:
                Glide.with(this).load("https://5.imimg.com/data5/PW/ND/MY-46595757/fresh-pineapple-281kg-29-500x500.png").into(fruitimage_IV);
                break;
            case 43:
                Glide.with(this).load("https://m.media-amazon.com/images/I/616PXhYj8iL._SL1000_.jpg").into(fruitimage_IV);
                break;
            case 44:
                Glide.with(this).load("https://4.imimg.com/data4/UT/OJ/MY-24421102/muskmelon-1-500x500.png").into(fruitimage_IV);
                break;
            case 45:
                Glide.with(this).load("https://i0.wp.com/vsco.fr/wp-content/uploads/2021/05/amla.jpg").into(fruitimage_IV);
                break;
            case 46:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTY9PKgNBsf0poDoDn0pGZbJlK1Ddwg365iXA&usqp=CAU").into(fruitimage_IV);
                break;
            case 47:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNEZy54r2C7H8cjfPGpgAeAAZnr-DXtZZbfxDDWMBM8iwCanVVaw1dwnZYOKEGvSeGOvU&usqp=CAU").into(fruitimage_IV);
                break;
            case 48:
                Glide.with(this).load("https://m.media-amazon.com/images/I/51nz0w9ouPL.jpg").into(fruitimage_IV);
                break;
            case 49:
                Glide.with(this).load("https://rukminim1.flixcart.com/image/416/416/k3yrte80/snack-savourie/k/v/v/500-roasted-and-salted-kaju-pouch-oforio-original-imafm6n23hgxbn3g.jpeg?q=70").into(fruitimage_IV);
                break;
            case 50:
                Glide.with(this).load("https://5.imimg.com/data5/NB/DH/MY-1232526/badami-mango-500x500.jpg").into(fruitimage_IV);
                break;
            case 51:
                Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjT0Boo1VEsa2h2QS2ScRgpvP-PyxmHBpnQQ&usqp=CAU").into(fruitimage_IV);
                break;
        }

        plus_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int add=Integer.parseInt(fruitcart.getText().toString());
                 if(add>=10)
                 {
                     Toast.makeText(FruitViewActivity.this, "10 kg Limit Per Person", Toast.LENGTH_SHORT).show();
                     fruitcart.setText(String.valueOf(add));
                 }
                 else
                 {
                     add=add+1;
                     fruitcart.setText(String.valueOf(add));
                 }

            }
        });
        minus_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int remove=Integer.parseInt(fruitcart.getText().toString());
               if(remove==0)
               {
                   Toast.makeText(FruitViewActivity.this, "This Fruit are not in cart", Toast.LENGTH_SHORT).show();
                   fruitcart.setText(String.valueOf(remove));
               }
               else
               {
                   remove=remove-1;
                   fruitcart.setText(String.valueOf(remove));
               }
            }
        });

        fruitfavourite_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteData sqLiteData=new SQLiteData(getApplicationContext());
                if(favourite==0)
                {
                    favourite=1;
                    fruitfavourite_IV.setImageResource(R.drawable.favourite_red);
                    sqLiteData.favoutite_update(id,favourite);
                }
                else
                {
                    favourite=0;
                    fruitfavourite_IV.setImageResource(R.drawable.favourite_black);
                    sqLiteData.favoutite_update(id,favourite);
                }
            }
        });


        add_to_cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int product=Integer.parseInt(fruitview_add_to_cart_num.getText().toString());
              SQLiteData sqLiteData=new SQLiteData(FruitViewActivity.this);
                 sqLiteData.addtocart(id,product);
                 if(!fruitcart.getText().equals(0))
                 {
                     Toast.makeText(FruitViewActivity.this,"Fruit Added Sucessfully",Toast.LENGTH_SHORT).show();
                 }
                 else
                 {

                 }



            }
        });

        buy_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FruitViewActivity.this, ViewCart.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(favourite==1)
        {
            fruitfavourite_IV.setImageResource(R.drawable.favourite_red);
        }
        else
        {
            fruitfavourite_IV.setImageResource(R.drawable.favourite_black);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

}