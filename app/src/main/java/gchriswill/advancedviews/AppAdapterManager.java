package gchriswill.advancedviews;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gchriswill on 12/12/14.
 */
public class AppAdapterManager {

    public ArrayAdapter<String> CreateListArrayAdapter(
            Context context,
            ArrayList<CarProfile> objects,
            boolean isForLandscape) {

        ArrayList<String> mStringObjects = new ArrayList<>();
        for (CarProfile i : objects) mStringObjects.add(i.getCarMake());

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(
                context,
                isForLandscape ?
                        R.layout.tviflv :
                        R.layout.tvifs,
                mStringObjects);

       if (!isForLandscape)adapter.setDropDownViewResource(R.layout.ctvifs);

    return adapter;

    }

}
