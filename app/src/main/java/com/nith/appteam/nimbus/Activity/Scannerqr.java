package com.nith.appteam.nimbus.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.nith.appteam.nimbus.R;

public class Scannerqr extends AppCompatActivity implements View.OnClickListener {

    private Button scanBtn;

    private TextView tvScanFormat, tvScanContent;

    private LinearLayout llSearch;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scannerqr);
//        llSearch.setVisibility(View.GONE);

        IntentIntegrator integrator = new IntentIntegrator(this);

        integrator.setPrompt("Scan a barcode or QRcode");

        integrator.setOrientationLocked(false);

        integrator.initiateScan();
        scanBtn =  findViewById(R.id.scan_button);

        tvScanFormat = (TextView) findViewById(R.id.tvScanFormat);

        tvScanContent = (TextView) findViewById(R.id.tvScanContent);

        llSearch = (LinearLayout) findViewById(R.id.llSearch);

//        scanBtn.setOnClickListener(this);


    }

    public void onClick(View v) {

        llSearch.setVisibility(View.GONE);

        IntentIntegrator integrator = new IntentIntegrator(this);

        integrator.setPrompt("Scan a barcode or QRcode");

        integrator.setOrientationLocked(false);

        integrator.initiateScan();

//        Use this for more customization

//        IntentIntegrator integrator = new IntentIntegrator(this);

//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);

//        integrator.setPrompt("Scan a barcode");

//        integrator.setCameraId(0);  // Use a specific camera of the device

//        integrator.setBeepEnabled(false);

//        integrator.setBarcodeImageEnabled(true);

//        integrator.initiateScan();

    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {

            if (result.getContents() == null) {
                finish();
                llSearch.setVisibility(View.GONE);

                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();


            } else {

                llSearch.setVisibility(View.VISIBLE);

//                tvScanContent.setText(result.getContents());
//
//                tvScanFormat.setText(result.getFormatName());
                Intent intent = new Intent(Scannerqr.this,CreateTeam.class);
                intent.putExtra("eventId",result.getContents());
                startActivity(intent);
                finish();

            }

        } else {

            super.onActivityResult(requestCode, resultCode, data);

        }

    }

}