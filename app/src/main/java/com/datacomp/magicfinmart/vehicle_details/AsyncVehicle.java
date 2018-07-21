package com.datacomp.magicfinmart.vehicle_details;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nilesh Birhade on 20-07-2018.
 */

public class AsyncVehicle extends AsyncTask<Void, Void, String> {

    Context mContext;
    String mNumber;
    ICarDetail mICarDetail;
    boolean isVehicle;

    AsyncVehicle(Context context, boolean isVehicle, String vehicleNumber, ICarDetail iCarDetail) {
        mContext = context;
        mNumber = vehicleNumber;
        mICarDetail = iCarDetail;
        this.isVehicle = isVehicle;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mICarDetail.getCarDetails(s);
    }

    private String sendGetVehicle(String number) throws Exception {

        //MH43BE6262
        String url = "http://202.131.96.98:8041/PolicyBossRegNoService.svc/GetRegNoData?v=" + number;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        // System.out.println("\nSending 'GET' request to URL : " + url);
        // System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }

    private String sendGetMobile(String number) throws Exception {

        //MH43BE6262
        String url = "http://202.131.96.98:8010/GenesysService.svc/GetCustomerInformation?v=" + number;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        // System.out.println("\nSending 'GET' request to URL : " + url);
        // System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            if (isVehicle) {
                return sendGetVehicle(mNumber);
            } else {
                return sendGetMobile(mNumber);
            }

        } catch (Exception e) {
            return "";
        }

    }
}
