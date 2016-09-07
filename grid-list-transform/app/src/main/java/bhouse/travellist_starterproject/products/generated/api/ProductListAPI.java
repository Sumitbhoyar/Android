package bhouse.travellist_starterproject.products.generated.api;

import bhouse.travellist_starterproject.products.generated.ProductListResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductListAPI {
    @GET("/bins/20ujc")
    Call<ProductListResponse> loadProductss();
}
