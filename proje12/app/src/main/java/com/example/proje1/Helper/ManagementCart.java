package com.example.proje1.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.proje1.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);
    }
    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood= getListCart();
                boolean existAlready=false;
                int n=0;
                for (int i = 0; i < listFood.size(); i++){
                    if (listFood.get(i).getTitle().equals(item.getTitle())){
                        existAlready=true;
                        n=i;
                        break;
                    }
                }

                if (existAlready){
                    listFood.get(n).setNumberInCart(item.getNumberInCart());
                }else{
                    listFood.add(item);
                }
                tinyDB.putListObject("CardList",listFood);
                Toast.makeText(context, "Sepetinize Eklendi", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<FoodDomain>getListCart(){
        return tinyDB.getListObject("CartList");
    }
}
