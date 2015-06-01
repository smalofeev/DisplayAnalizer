package com.smalofeev.displayanalizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.smalofeev.displayanalizer.entity.Device;


public class MainActivity extends Activity {
    private Device mDevice;

    private TextView tvDeviceName;
    private TextView tvDeviceModel;
    private TextView tvDeviceManufacturer;

    private TextView tvDisplay;
    private TextView tvDisplayResolution;
    private TextView tvDisplaySW;
    private TextView tvDisplayDpi;

    private TextView tvFolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDevice = new Device(MainActivity.this);
        initViews();
        fillData();
    }

    private void initViews() {
        tvDeviceName = (TextView) findViewById(R.id.device_name);
        tvDeviceManufacturer = (TextView) findViewById(R.id.device_manufacturer);
        tvDeviceModel = (TextView) findViewById(R.id.device_model);

        tvDisplay = (TextView) findViewById(R.id.display_name);
        tvDisplayResolution = (TextView) findViewById(R.id.display_resolution);
        tvDisplaySW = (TextView) findViewById(R.id.display_sw);
        tvDisplayDpi = (TextView) findViewById(R.id.display_dpi);

        tvFolder = (TextView) findViewById(R.id.display_folder);
    }

    private void fillData() {
        tvDeviceName.setText(mDevice.getmName());
        tvDeviceManufacturer.setText(mDevice.getmManufacturer());
        tvDeviceModel.setText(mDevice.getmModel());

        tvDisplay.setText(mDevice.getmDisplay());
        tvDisplayResolution.setText(mDevice.getmDisplayResolution());
        tvDisplaySW.setText(mDevice.getmDisplaySmallestWidth());
        tvDisplayDpi.setText(mDevice.getmDisplayDpi());

        tvFolder.setText(mDevice.getmValuesDpi());
    }



}
