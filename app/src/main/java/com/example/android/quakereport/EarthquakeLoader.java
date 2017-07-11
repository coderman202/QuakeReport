package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/*
 * Created by Reggie on 10/07/2017. A custom class to download the earthquake data.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String requestURL;

    public EarthquakeLoader(Context context, String requestURL){
        super(context);
        this.requestURL = requestURL;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground(){
        if(requestURL == null){
            return null;
        }
        return QueryUtils.extractEarthquakes(requestURL);

    }
}
