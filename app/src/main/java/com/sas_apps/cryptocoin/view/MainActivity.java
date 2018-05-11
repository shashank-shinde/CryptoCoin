package com.sas_apps.cryptocoin.view;

import android.app.ProgressDialog;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.sas_apps.cryptocoin.R;
import com.sas_apps.cryptocoin.view.adaptor.MainRecyclerViewAdaptor;
import com.sas_apps.cryptocoin.network.api.CoinMarketCapApi;
import com.sas_apps.cryptocoin.model.CoinMarketCapResponse;
import com.sas_apps.cryptocoin.network.retrofit.RetrofitClient;
import com.sas_apps.cryptocoin.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements
        Callback<List<CoinMarketCapResponse>> {

    private static final String TAG = "MainActivity";
    private static final String KEY = "Parcelable_Key";
    private static final int API_RESPONSE_LIMIT = 40;
    private List<CoinMarketCapResponse> responseList = new ArrayList<>();
    private RecyclerView recyclerViewMain;
    private ProgressDialog progressDialog;
    Call<List<CoinMarketCapResponse>> apiCall;
//    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewMain = findViewById(R.id.recyclerView_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerViewMain.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL);
        recyclerViewMain.addItemDecoration(dividerItemDecoration);

        if (savedInstanceState != null) {
            responseList = savedInstanceState.getParcelableArrayList(KEY);
            recyclerViewMain.setAdapter(new MainRecyclerViewAdaptor(responseList));
        } else {
            makeApiCall();
        }
    }


    private void makeApiCall() {
        CoinMarketCapApi api = RetrofitClient.getInstance(Utils.Base_URL)
                .create(CoinMarketCapApi.class);
        apiCall = api
                .getCoinResponse("inr", API_RESPONSE_LIMIT);
        apiCall.enqueue(this);
    }


    @Override
    public void onResponse(@NonNull Call<List<CoinMarketCapResponse>> call,
                           @NonNull Response<List<CoinMarketCapResponse>> response) {
        progressDialog.cancel();
        if (response.isSuccessful()) {
//         Log.d(TAG, String.format("onResponse: %s", response.body().get(i).toString()));
            responseList.addAll(response.body());
            recyclerViewMain.setAdapter(new MainRecyclerViewAdaptor(responseList));
        } else {
            Toast.makeText(this, response.message(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onFailure(@NonNull Call<List<CoinMarketCapResponse>> call, @NonNull Throwable t) {
        progressDialog.cancel();
        Log.e(TAG, String.format("onFailure: %s", t.getMessage()));
        if (t instanceof IOException) {
            Toast.makeText(this, "Network error", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (responseList != null) {
            outState.putParcelableArrayList(KEY, (ArrayList<? extends Parcelable>) responseList);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiCall != null && !apiCall.isExecuted()) {
            apiCall.cancel();
        }
    }

}
