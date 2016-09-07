package bhouse.travellist_starterproject.products.generated.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.sql.SQLOutput;

import bhouse.travellist_starterproject.TravelListAdapter;
import bhouse.travellist_starterproject.products.generated.ProductListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsManager {
    public void loadProductList(final RecyclerView mRecyclerView, final TravelListAdapter.OnItemClickListener listener, final Context applicationContext){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        ProductListAPI productListAPI = retrofit.create(ProductListAPI.class);

        Call<ProductListResponse> call = productListAPI.loadProductss();
        //asynchronous call
            call.enqueue(new Callback<ProductListResponse>() {
                @Override
                public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
                    response.body().refreshMap();
                    TravelListAdapter mAdapter = new TravelListAdapter(applicationContext);
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListener(listener);
                }

                @Override
                public void onFailure(Call<ProductListResponse> call, Throwable t) {
                    System.out.println(t);
                }
            });
            System.out.println(11);
        }
    }


