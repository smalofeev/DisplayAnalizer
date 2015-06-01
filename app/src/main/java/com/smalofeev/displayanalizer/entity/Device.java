package com.smalofeev.displayanalizer.entity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import com.smalofeev.displayanalizer.R;

/**
 * Created by root on 30.05.15.
 */
public class Device {
    private final String mName;
    private final String mManufacturer;
    private final String mModel;

    private final String mDisplay;
    private String mDisplayResolution;
    private String mDisplayDpi;
    private String mDisplaySmallestWidth;

    private String mValuesDpi;

    public Device(Activity activity) {
        mName = Build.DEVICE;
        mManufacturer = Build.MANUFACTURER;
        mModel =  Build.MODEL;

        mDisplay = Build.DISPLAY;

        fillDisplayParams(activity);
    }

    private void fillDisplayParams(Activity activity) {
        Configuration configuration = activity.getResources().getConfiguration();
        int screenWidthDp = configuration.screenWidthDp;
        int smallestScreenWidthDp = configuration.smallestScreenWidthDp;
        StringBuilder sb = new StringBuilder(screenWidthDp);

        mDisplaySmallestWidth = sb.toString();


        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getRealMetrics(outMetrics);

        float density  = activity.getResources().getDisplayMetrics().density;
        int height = outMetrics.heightPixels;
        int width  = outMetrics.widthPixels;



        double updatedDenstiny = outMetrics.density * outMetrics.densityDpi; //activity.getResources().getInteger(R.integer.dpi_value);
        double x = Math.pow(outMetrics.widthPixels / outMetrics.xdpi, 2);
        double y = Math.pow(outMetrics.heightPixels / outMetrics.ydpi, 2);



        double screenInches = /*Math.round(*/Math.sqrt(x + y)/* + 0.5*/;

        double dpi = Math.sqrt(Math.pow(outMetrics.widthPixels, 2) + Math.pow(outMetrics.heightPixels, 2) / screenInches);

        int dp = (int) (outMetrics.widthPixels / (dpi / outMetrics.densityDpi));

        int widthDp = (int) (outMetrics.widthPixels / density);

        StringBuilder sbResolution = new StringBuilder();
        sbResolution.append(width).append("x").append(height);

        mDisplaySmallestWidth = "" + smallestScreenWidthDp;
//        mDisplaySmallestWidth = ""+outMetrics.densityDpi + " xDpi = " + outMetrics.xdpi + " yDpi = " + outMetrics.ydpi
//                                + " s";

        mDisplayResolution = sbResolution.toString();

        mDisplayDpi = Float.toString(density);

        mValuesDpi = activity.getString(R.string.values_folder);
    }

    public String getmName() {
        return mName;
    }

    public String getmManufacturer() {
        return mManufacturer;
    }

    public String getmModel() {
        return mModel;
    }

    public String getmDisplay() {
        return mDisplay;
    }

    public String getmDisplayResolution() {
        return mDisplayResolution;
    }

    public String getmDisplayDpi() {
        return mDisplayDpi;
    }

    public String getmDisplaySmallestWidth() {
        return mDisplaySmallestWidth;
    }

    public String getmValuesDpi() {
        return mValuesDpi;
    }
}
