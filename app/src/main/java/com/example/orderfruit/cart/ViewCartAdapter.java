package com.example.orderfruit.cart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfruit.AddToCart_Interface;
import com.example.orderfruit.R;
import com.example.orderfruit.model.FruitData;

import java.util.ArrayList;


public class ViewCartAdapter extends RecyclerView.Adapter<ViewCartAdapter.holder> {
    ArrayList<FruitData> arrayList;
    Context context;
    AddToCart_Interface addToCart_interface;
    int sum;


    public ViewCartAdapter(ArrayList<FruitData> arrayList, Context context, AddToCart_Interface addToCart_interface) {
        this.arrayList = arrayList;
        this.context = context;
        this.addToCart_interface=addToCart_interface;

    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.viewcart_row,parent,false);
        return new holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        holder.viewcart_fruitname.setText(arrayList.get(position).getFruit_name());
        holder.viewcart_fruitweight.setText(String.valueOf(arrayList.get(position).getFruit_addtocart())+" KG");
        holder.viewcart_cart.setText(String.valueOf(arrayList.get(position).getFruit_addtocart()));
        holder.viewcart_price.setText(String.valueOf("₹"+arrayList.get(position).getFruit_price()*arrayList.get(position).getFruit_addtocart()));

        sum=0;
        for(int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getFruit_addtocart()>0)
            {
                int getFruitPrice=arrayList.get(i).getFruit_price();
                int getFruitWeight=arrayList.get(i).getFruit_addtocart();
                int PriceandWeight=getFruitPrice*getFruitWeight;
                sum=sum+PriceandWeight;
            }
            else
            {
            }
        }

        ((ViewCart) context).getdata(sum);

        holder.viewcart_row_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int id=arrayList.get(position).getFruit_id();
               int add= Integer.parseInt(holder.viewcart_cart.getText().toString());
               sum=0;
               if(add<10)
               {
                    add=add+1;
                    holder.viewcart_cart.setText(String.valueOf(add));

                   addToCart_interface.add_to_cart(id,add);

                   holder.viewcart_fruitweight.setText(String.valueOf(add));
                   holder.viewcart_price.setText(String.valueOf(add*arrayList.get(position).getFruit_price()));

                   sum=0;
                   for(int i = 0; i < arrayList.size(); i++){
                       if(arrayList.get(i).getFruit_addtocart()>0)
                       {
                           int getFruitPrice=arrayList.get(i).getFruit_price();
                           int getFruitWeight=arrayList.get(i).getFruit_addtocart();
                           int PriceandWeight=getFruitPrice*getFruitWeight;
                           sum=sum+PriceandWeight;
                           ((ViewCart) context).onResume();
                       }
                       else
                       {
                       }

                   }

               }
               else
               {
                   Toast.makeText(context.getApplicationContext(), "Not More than 10 KG", Toast.LENGTH_SHORT).show();
               }

                //((ViewCart) context).onResume();


            }


        });
        holder.viewcart_row_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=arrayList.get(position).getFruit_id();
                int remove= Integer.parseInt(holder.viewcart_cart.getText().toString());
                sum=0;
               if(remove<1)
               {
                   Toast.makeText(context.getApplicationContext(), "Atlest 1 KG", Toast.LENGTH_SHORT).show();

               }
               else
               {
                   remove=remove-1;
                   holder.viewcart_cart.setText(String.valueOf(remove));
                   addToCart_interface.add_to_cart(id,remove);

                   sum=0;
                   for(int i = 0; i < arrayList.size(); i++){
                       if(arrayList.get(i).getFruit_addtocart()>0)
                       {
                           int getFruitPrice=arrayList.get(i).getFruit_price();
                           int getFruitWeight=arrayList.get(i).getFruit_addtocart();
                           int PriceandWeight=getFruitPrice*getFruitWeight;
                           sum=sum+PriceandWeight;
                           ((ViewCart) context).onResume();
                       }
                       else
                       {
                       }
                   }


                 // ((ViewCart) context).onResume();


               }
                addToCart_interface.add_to_cart(id,remove);
                holder.viewcart_fruitweight.setText(String.valueOf(remove));
                holder.viewcart_price.setText(String.valueOf(remove*arrayList.get(position).getFruit_price()));

//                for(int i = 0; i < arrayList.size(); i++){
//                    int j=arrayList.get(position).getFruit_price()*arrayList.get(position).getFruit_addtocart();
//                    sum=sum-j;
//                }
//                ViewCart viewCart= (ViewCart) context;
//                ((ViewCart) context).getdata(sum);



            }


        });



//        int sum=0;
//        for(int i = 0; i < arrayList.size(); i++){
//            int j=arrayList.get(i).getFruit_price();
//            sum=sum+j;
//        }



//        int sum=0;
//        for(int i = 0; i < arrayList.size(); i++){
//            int j=arrayList.get(i).getFruit_price()*arrayList.get(i).getFruit_addtocart();
//            sum=sum+j;
//        }
//        int item_total=sum;
//        int delivery_charge=0;
//        int topay=item_total+delivery_charge;
//        addToCart_interface.paymentDetails(item_total,delivery_charge,topay);

    }




    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView viewcart_fruitname, viewcart_fruitweight, viewcart_cart, viewcart_price,viewcart_row_minus,viewcart_row_plus;

        public holder(@NonNull View itemView) {
            super(itemView);
            viewcart_fruitname=itemView.findViewById(R.id.viewcart_row_fruitname);
            viewcart_fruitweight=itemView.findViewById(R.id.viewcart_row_weight);
            viewcart_cart=itemView.findViewById(R.id.viewcart_cart);
            viewcart_price=itemView.findViewById(R.id.viewcart_row_price);
            viewcart_row_minus=itemView.findViewById(R.id.viewcart_row_minus);
            viewcart_row_plus=itemView.findViewById(R.id.viewcart_row_plus);


        }
    }
}
