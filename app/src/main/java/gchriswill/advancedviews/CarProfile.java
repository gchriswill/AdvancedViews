package gchriswill.advancedviews;

import java.util.HashMap;

/**
 * Created by gchriswill on 12/12/14.
 */
public class CarProfile {

    private HashMap <String, String> mCoreObject;


    public CarProfile(String make,
                    String model,
                    String year,
                    int image,
                    int id) {

        mCoreObject = new HashMap<>();
        mCoreObject.put("make", make);
        mCoreObject.put("model", model);
        mCoreObject.put("year", year);
        mCoreObject.put("image", String.valueOf(image));
        mCoreObject.put("id", String.valueOf(id));

    }


//  Getters Methods

    public String getCarMake() {return mCoreObject.get("make");}
    public String getCarModel() {return mCoreObject.get("model");}
    public String getCarYear() {return mCoreObject.get("year");}
    public int getCarImage() {return Integer.parseInt(mCoreObject.get("image"));}
    public int getCarID() {return Integer.parseInt(mCoreObject.get("id"));}

}
