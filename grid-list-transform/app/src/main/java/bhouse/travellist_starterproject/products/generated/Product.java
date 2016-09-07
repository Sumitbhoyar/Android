package bhouse.travellist_starterproject.products.generated;


import android.content.Context;

public class Product {

	public String Id;
	public String Price;
	public String Name;
	public String Image;
	public String Rating;
	public int getImageResourceId(Context context) {
		return context.getResources().getIdentifier(this.Image, "drawable", context.getPackageName());
	}
}