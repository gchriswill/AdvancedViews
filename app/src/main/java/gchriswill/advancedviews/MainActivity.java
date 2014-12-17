package gchriswill.advancedviews;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    AppAdapterManager adapterManager = new AppAdapterManager();
    ArrayList<CarProfile> mCarObjects = new ArrayList<>();
    ListView listview;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.SpinnerForItems);
        spinner.setOnItemSelectedListener(this);

        mCarObjects.add(new CarProfile("Smart ", "forTwo", "'14", R.drawable.smartcar,0 ));
        mCarObjects.add(new CarProfile("Toyota", "Corolla", "'11",R.drawable.corolla,2 ));
        mCarObjects.add(new CarProfile("Ford", "Focus ST", "'13",R.drawable.focus,3 ));
        mCarObjects.add(new CarProfile("Chevrolet", "Volt", "'13",R.drawable.volt,4 ));
        mCarObjects.add(new CarProfile("Volkswagen", "GTi", "'14",R.drawable.vwgti,5 ));

        spinner.setAdapter(
                adapterManager.CreateListArrayAdapter(
                        this,
                        mCarObjects, false));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //  Orientation mode validation area
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main_lan);
            listview = (ListView) findViewById(R.id.ListViewForLand);
            listview.setOnItemClickListener(this);
            listview.setAdapter(
                    adapterManager.CreateListArrayAdapter(
                            this,
                            mCarObjects, true));

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            spinner = (Spinner) findViewById(R.id.SpinnerForItems);
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(
                    adapterManager.CreateListArrayAdapter(
                            this,
                            mCarObjects, false));

        }

    }

    public void setValuesForUI(int location){

        ((TextView)findViewById(R.id.TextViewMake)).setText(mCarObjects.get(location).getCarMake());
        ((TextView)findViewById(R.id.TextViewModel)).setText(mCarObjects.get(location).getCarModel());
        ((TextView)findViewById(R.id.TextViewYear)).setText(mCarObjects.get(location).getCarYear());
        ((ImageView)findViewById(R.id.ImageViewCarImage)).setImageResource(mCarObjects.get(location).getCarImage());

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        setValuesForUI(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        setValuesForUI(position);
    }
}
