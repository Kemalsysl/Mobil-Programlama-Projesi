package com.example.proje1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proje1.Adaptor.CategoryAdaptor;
import com.example.proje1.Adaptor.PopularAdaptor;
import com.example.proje1.Domain.CategoryDomain;
import com.example.proje1.Domain.FoodDomain;
import com.example.proje1.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("İçecek","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter); // burada adapteri RecyclerView'e bağlıyoruz
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add((FoodDomain) new com.example.proje1.Domain.FoodDomain("Pepperoni pizza", "pizza", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 9.76));
        foodlist.add((FoodDomain)new com.example.proje1.Domain.FoodDomain("Cheese Burger","burger","beef,Gouda Cheese,Special Sauce,Lettuce,tomato",8.79));
        foodlist.add((FoodDomain)new com.example.proje1.Domain.FoodDomain("Vegetable pizza","pizza3","olive oil,Vegetable oil,pitted kalamanta ",8.79));

        adapter2=new PopularAdaptor(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }


    }
