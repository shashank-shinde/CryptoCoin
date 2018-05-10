package com.sas_apps.cryptocoin.network.api;

import com.sas_apps.cryptocoin.model.CoinMarketCapResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CoinMarketCapApi {

    @GET("ticker/")
    Call<List<CoinMarketCapResponse>> getCoinResponse(@Query("convert") String currencyName, @Query("limit") int limit);
}
