package bhouse.travellist_starterproject.products.generated.api;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import bhouse.travellist_starterproject.TravelListAdapter;
import bhouse.travellist_starterproject.products.generated.ProductListResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListsCallback implements Callback<ProductListResponse> {
    RecyclerView mRecyclerView;
    TravelListAdapter.OnItemClickListener listener;
    Context applicationContext;
    public ProductListsCallback(RecyclerView mRecyclerView, TravelListAdapter.OnItemClickListener listener, Context applicationContext) {
        this.mRecyclerView= mRecyclerView;
        this.listener=listener;
    }

    @Override
    public void onResponse(Call<ProductListResponse> call, Response<ProductListResponse> response) {
        TravelListAdapter mAdapter = new TravelListAdapter(applicationContext);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(listener);
    }

    @Override
    public void onFailure(Call<ProductListResponse> call, Throwable t) {
        System.out.println(t);
        t.printStackTrace();
    }
}
