package bhouse.travellist_starterproject;

import android.content.Context;

public class Product {

  public Integer Id;
  public Double Price;
  public String Name;
  public String Image;
  public Double Rating;

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.Image, "drawable", context.getPackageName());
  }
}
