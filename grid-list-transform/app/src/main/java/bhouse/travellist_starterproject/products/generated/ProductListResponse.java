package bhouse.travellist_starterproject.products.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductListResponse {
	public static List<Product> productMap = new ArrayList<>();
	public Summary Summary;
	public List<Product> Products = new ArrayList<Product>();

	public void  refreshMap(){
		productMap.clear();
		for (int i=0 ;i< Products.size();i++) {
			productMap.addAll(Products);
		}
	}
}