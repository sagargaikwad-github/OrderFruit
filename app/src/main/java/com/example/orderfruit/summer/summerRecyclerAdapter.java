package com.example.orderfruit.summer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.orderfruit.R;
import com.example.orderfruit.RoomDB.FruitData.FruitDataModel;

import com.example.orderfruit.viewfruit.FruitViewActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class summerRecyclerAdapter extends RecyclerView.Adapter<summerRecyclerAdapter.holder> implements Filterable {
    List<FruitDataModel> fruitData=new ArrayList<>();
    Context context;
    ArrayList<FruitDataModel>backup=new ArrayList<>();



    public summerRecyclerAdapter(List<FruitDataModel> fruitData, Context context) {
        this.fruitData = fruitData;
        this.context = context;
        backup=new ArrayList<>(fruitData);
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.summer_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
       holder.summer_fruit_name.setText(fruitData.get(position).getFruit_name());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, FruitViewActivity.class);
               intent.putExtra("FruitID",fruitData.get(position).getFruit_id());
               intent.putExtra("FruitName",fruitData.get(position).getFruit_name());
               intent.putExtra("FruitPrice",fruitData.get(position).getFruit_price());
               intent.putExtra("FruitDesc1",fruitData.get(position).getFruit_description1());
               intent.putExtra("FruitDesc2",fruitData.get(position).getFruit_description2());
               intent.putExtra("FruitDesc3",fruitData.get(position).getFruit_description3());
               intent.putExtra("FruitDesc4",fruitData.get(position).getFruit_description4());
               intent.putExtra("FruitCart",fruitData.get(position).getFruit_addtocart());
               intent.putExtra("FruitFav",fruitData.get(position).getFruit_favourite());
               context.startActivity(intent);
           }
       });
        
    }
    @Override
    public void onViewAttachedToWindow(@NonNull holder holder) {
        switch (fruitData.get(holder.getAdapterPosition()).getFruit_id())
        {
            case 0:
                Glide.with(context).load("https://www.gardeningknowhow.com/wp-content/uploads/2021/05/whole-and-slices-watermelon.jpg").into(holder.summer_fruit_image);
                break;
            case 1:
                Glide.with(context).load("https://img.freepik.com/free-photo/ripe-mango-with-green-leaf-isolated-white_252965-183.jpg?w=2000").into(holder.summer_fruit_image);
                break;
            case 2:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4ba_jv0CRWew2quncYET-VszSeDU5vyzLTg&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 3:
                Glide.with(context).load("https://5.imimg.com/data5/SELLER/Default/2021/1/LZ/GA/HD/10023771/custard-apple-500x500.jpg").into(holder.summer_fruit_image);
                break;
            case 4:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6JcjkDzmMTlwEQ6OM4EIxqyI6bNDjOaRtuw&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 5:
                Glide.with(context).load("https://media.istockphoto.com/photos/green-grape-isolated-on-white-background-picture-id489520104?k=20&m=489520104&s=612x612&w=0&h=n1_B8jn9fb4dQibPhkXftNpjKA4Rvrjp_ttgj6sq5jY=").into(holder.summer_fruit_image);
                break;
            case 6:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQH5yRyd4QWC2dnOCDy7UkauJz8ymbzeqg41A&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 7:
                Glide.with(context).load("https://media.istockphoto.com/photos/star-fruit-carambola-or-star-apple-picture-id639667582").into(holder.summer_fruit_image);
                break;
            case 8:
                Glide.with(context).load("https://thekitchencommunity.org/wp-content/uploads/2021/09/What-Does-Guava-Taste-Like.jpg").into(holder.summer_fruit_image);
                break;
            case 9:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaAXtZXW0NwXfeThZW9BbWaT36At6cOjfv4Q&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 10:
                Glide.with(context).load("https://befreshcorp.net/wp-content/uploads/2017/07/product-packshot-Lychee.jpg").into(holder.summer_fruit_image);
                break;
            case 11:
                Glide.with(context).load("https://cdn.shopify.com/s/files/1/0095/6258/7195/products/babybanana.jpg?v=1610171751").into(holder.summer_fruit_image);
                break;
            case 12:
                Glide.with(context).load("https://5.imimg.com/data5/WK/JQ/MY-25358554/walnut-in-shell-500x500.jpg").into(holder.summer_fruit_image);
                break;
            case 13:
                Glide.with(context).load("https://m.media-amazon.com/images/I/41O+ipEyywL.jpg").into(holder.summer_fruit_image);
                break;
            case 14:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyNTj6FoEDJ1UV6CUcFGsrK4wwz5gw-Js8Ag&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 15:
                Glide.with(context).load("https://m.media-amazon.com/images/I/41SfsqsdqwL.jpg").into(holder.summer_fruit_image);
                break;
            case 16:
                Glide.with(context).load("https://media.istockphoto.com/photos/golden-delicious-apples-picture-id628592448").into(holder.summer_fruit_image);
                break;
            case 17:
                Glide.with(context).load("https://5.imimg.com/data5/RI/NH/MY-50344271/natural-fresh-blueberry-500x500.jpg").into(holder.summer_fruit_image);
                break;
            case 18:
                Glide.with(context).load("https://www.bigbasket.com/media/uploads/p/xxl/40174618_4-fresho-pear-beauty.jpg").into(holder.summer_fruit_image);
                break;
            case 19:
                Glide.with(context).load("https://img.freepik.com/free-photo/tamarind-with-green-leaves-isolated-white-surface_252965-220.jpg?w=2000").into(holder.summer_fruit_image);
                break;
            case 20:
                Glide.with(context).load("https://m.media-amazon.com/images/I/61ZsRkrjB9L._AC_SL1000_.jpg").into(holder.summer_fruit_image);
                break;
            case 21:
                Glide.with(context).load("https://media.istockphoto.com/photos/rose-apples-isolated-on-white-picture-id1216054107?k=20&m=1216054107&s=612x612&w=0&h=kZJC0g7mJKdQyuNbCvxyQfknFgXC4030wKP2ueMClts=").into(holder.summer_fruit_image);
                break;
            case 22:
                Glide.with(context).load("https://cdn-prod.medicalnewstoday.com/content/images/articles/320/320894/strawberry-on-white-background-to-represent-strawberry-tongue.jpg").into(holder.summer_fruit_image);
                break;
            case 23:
                Glide.with(context).load("https://www.bigbasket.com/media/uploads/p/l/10000393-2_1-fresho-apple-ambri.jpg").into(holder.summer_fruit_image);
                break;
            case 24:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAJLtcRQMP4mZvDbnL_mi2oSKAxAoxGjfqcg&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 25:
                Glide.with(context).load("https://www.bigbasket.com/media/uploads/p/l/20003958_2-fresho-ber-apple.jpg").into(holder.summer_fruit_image);
                break;
            case 26:
                Glide.with(context).load("https://cdn.shopify.com/s/files/1/0269/8258/0311/products/kashmir-online-store-figs-anjeer-medium_1024x.jpg?v=1637237373").into(holder.summer_fruit_image);
                break;
            case 27:
                Glide.with(context).load("https://healthandhealthier.com/wp-content/uploads/2021/08/U730a0a83209a40099160552f88f67df3X-1.jpg").into(holder.summer_fruit_image);
                break;
            case 28:
                Glide.with(context).load("https://m.media-amazon.com/images/I/41xd6R3u+JL.jpg").into(holder.summer_fruit_image);
                break;
            case 29:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_gfknm8XIU34szbAixZJXMA7WYhctmdwzlA&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 30:
                Glide.with(context).load("https://www.gardeningknowhow.com/wp-content/uploads/2019/04/granny-smith.jpg").into(holder.summer_fruit_image);
                break;
            case 31:
                Glide.with(context).load("https://rukminim1.flixcart.com/image/416/416/l0r1j0w0/plant-seed/z/9/o/25-mm-1571-paudha-original-imagcguesgtkumag.jpeg?q=70").into(holder.summer_fruit_image);
                break;
            case 32:
                Glide.with(context).load("https://static.libertyprim.com/files/familles/cerise-large.jpg?1569271737").into(holder.summer_fruit_image);
                break;
            case 33:
                Glide.with(context).load("https://www.jiomart.com/images/product/original/590009518/mango-totapuri-4-pcs-approx-1200-g-1400-g-product-images-o590009518-p590177429-0-202204261843.jpg").into(holder.summer_fruit_image);
                break;
            case 34:
                Glide.with(context).load("https://t4.ftcdn.net/jpg/02/05/54/21/360_F_205542149_0eVGb8CPmZXY9mjv48O5EcW94XiPdNmT.jpg").into(holder.summer_fruit_image);
                break;
            case 35:
                Glide.with(context).load("https://cdn.shopify.com/s/files/1/0364/0465/8313/products/manzano_bananas_1lb_order247_canada.jpg?v=1618060394").into(holder.summer_fruit_image);
                break;
            case 36:
                Glide.with(context).load("https://shyamamart.com/wp-content/uploads/2020/09/511786528a5a-84.png").into(holder.summer_fruit_image);
                break;
            case 37:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_45DeGaoCSVhM8P7s29Ad2mN9ModVQuErFA&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 38:
                Glide.with(context).load("https://5.imimg.com/data5/ZS/DW/OR/GLADMIN-11866148/selection-410-500x500.png").into(holder.summer_fruit_image);
                break;
            case 39:
                Glide.with(context).load("https://i0.wp.com/www.ratnagirialphonsomango.com/wp-content/uploads/2017/10/buy-ratnagiri-alphonso-mango-e1648136287916.jpg?fit=564%2C440&ssl=1").into(holder.summer_fruit_image);
                break;
            case 40:
                Glide.with(context).load("https://media.istockphoto.com/photos/red-apple-picture-id184276818?k=20&m=184276818&s=612x612&w=0&h=QxOcueqAUVTdiJ7DVoCu-BkNCIuwliPEgtAQhgvBA_g=").into(holder.summer_fruit_image);
                break;
            case 41:
                Glide.with(context).load("https://www.collinsdictionary.com/images/full/raspberry_96055874.jpg").into(holder.summer_fruit_image);
                break;
            case 42:
                Glide.with(context).load("https://5.imimg.com/data5/PW/ND/MY-46595757/fresh-pineapple-281kg-29-500x500.png").into(holder.summer_fruit_image);
                break;
            case 43:
                Glide.with(context).load("https://m.media-amazon.com/images/I/616PXhYj8iL._SL1000_.jpg").into(holder.summer_fruit_image);
                break;
            case 44:
                Glide.with(context).load("https://4.imimg.com/data4/UT/OJ/MY-24421102/muskmelon-1-500x500.png").into(holder.summer_fruit_image);
                break;
            case 45:
                Glide.with(context).load("https://i0.wp.com/vsco.fr/wp-content/uploads/2021/05/amla.jpg").into(holder.summer_fruit_image);
                break;
            case 46:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTY9PKgNBsf0poDoDn0pGZbJlK1Ddwg365iXA&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 47:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNEZy54r2C7H8cjfPGpgAeAAZnr-DXtZZbfxDDWMBM8iwCanVVaw1dwnZYOKEGvSeGOvU&usqp=CAU").into(holder.summer_fruit_image);
                break;
            case 48:
                Glide.with(context).load("https://m.media-amazon.com/images/I/51nz0w9ouPL.jpg").into(holder.summer_fruit_image);
                break;
            case 49:
                Glide.with(context).load("https://rukminim1.flixcart.com/image/416/416/k3yrte80/snack-savourie/k/v/v/500-roasted-and-salted-kaju-pouch-oforio-original-imafm6n23hgxbn3g.jpeg?q=70").into(holder.summer_fruit_image);
                break;
            case 50:
                Glide.with(context).load("https://5.imimg.com/data5/NB/DH/MY-1232526/badami-mango-500x500.jpg").into(holder.summer_fruit_image);
                break;
            case 51:
                Glide.with(context).load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjT0Boo1VEsa2h2QS2ScRgpvP-PyxmHBpnQQ&usqp=CAU").into(holder.summer_fruit_image);
                break;
        }



    }



    @Override
    public int getItemCount() {
        int a=6;
        if(fruitData.size()>a)
        {
            return a;
        }
        else
        {
            return fruitData.size();
        }
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
           ArrayList<FruitDataModel>filterdata=new ArrayList<>();
           if(charSequence.toString().isEmpty())
           {
               filterdata.addAll(backup);
           }
           else
           {
               for(FruitDataModel obj:backup)
               {
                   if(obj.getFruit_name().toString().toLowerCase().contains(charSequence.toString().toLowerCase()))
                   {
                       filterdata.add(obj);
                   }
               }
           }
           FilterResults results=new FilterResults();
           results.values=filterdata;
           return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            fruitData.clear();
            fruitData.addAll((ArrayList<FruitDataModel>)filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class holder extends RecyclerView.ViewHolder {
        TextView summer_fruit_name;
        public ImageView summer_fruit_image;

        public holder(@NonNull View itemView) {
            super(itemView);
            summer_fruit_name=itemView.findViewById(R.id.summer_fruit_name);
            summer_fruit_image=itemView.findViewById(R.id.summer_iv);




        }
    }
}
