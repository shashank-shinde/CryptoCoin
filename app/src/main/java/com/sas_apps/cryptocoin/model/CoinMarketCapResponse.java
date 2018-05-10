package com.sas_apps.cryptocoin.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by av3 on 10/5/18.
 */

public class CoinMarketCapResponse implements Parcelable {


    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("symbol")
    @Expose
    public String symbol;
    @SerializedName("rank")
    @Expose
    public String rank;
    @SerializedName("price_usd")
    @Expose
    public String priceUsd;
    @SerializedName("price_btc")
    @Expose
    public String priceBtc;
    @SerializedName("24h_volume_usd")
    @Expose
    public String _24hVolumeUsd;
    @SerializedName("market_cap_usd")
    @Expose
    public String marketCapUsd;
    @SerializedName("available_supply")
    @Expose
    public String availableSupply;
    @SerializedName("total_supply")
    @Expose
    public String totalSupply;
    @SerializedName("max_supply")
    @Expose
    public String maxSupply;
    @SerializedName("percent_change_1h")
    @Expose
    public String percentChange1h;
    @SerializedName("percent_change_24h")
    @Expose
    public String percentChange24h;
    @SerializedName("percent_change_7d")
    @Expose
    public String percentChange7d;
    @SerializedName("last_updated")
    @Expose
    public String lastUpdated;
    @SerializedName("price_inr")
    @Expose
    public String priceInr;
    @SerializedName("24h_volume_inr")
    @Expose
    public String _24hVolumeInr;
    @SerializedName("market_cap_inr")
    @Expose
    public String marketCapInr;


    public CoinMarketCapResponse(String id, String name, String symbol, String rank, String priceUsd, String priceBtc, String _24hVolumeUsd, String marketCapUsd, String availableSupply, String totalSupply, String maxSupply, String percentChange1h, String percentChange24h, String percentChange7d, String lastUpdated, String priceInr, String _24hVolumeInr, String marketCapInr) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.priceUsd = priceUsd;
        this.priceBtc = priceBtc;
        this._24hVolumeUsd = _24hVolumeUsd;
        this.marketCapUsd = marketCapUsd;
        this.availableSupply = availableSupply;
        this.totalSupply = totalSupply;
        this.maxSupply = maxSupply;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.lastUpdated = lastUpdated;
        this.priceInr = priceInr;
        this._24hVolumeInr = _24hVolumeInr;
        this.marketCapInr = marketCapInr;
    }

    protected CoinMarketCapResponse(Parcel in) {
        id = in.readString();
        name = in.readString();
        symbol = in.readString();
        rank = in.readString();
        priceUsd = in.readString();
        priceBtc = in.readString();
        _24hVolumeUsd = in.readString();
        marketCapUsd = in.readString();
        availableSupply = in.readString();
        totalSupply = in.readString();
        maxSupply = in.readString();
        percentChange1h = in.readString();
        percentChange24h = in.readString();
        percentChange7d = in.readString();
        lastUpdated = in.readString();
        priceInr = in.readString();
        _24hVolumeInr = in.readString();
        marketCapInr = in.readString();
    }

    public static final Creator<CoinMarketCapResponse> CREATOR = new Creator<CoinMarketCapResponse>() {
        @Override
        public CoinMarketCapResponse createFromParcel(Parcel in) {
            return new CoinMarketCapResponse(in);
        }

        @Override
        public CoinMarketCapResponse[] newArray(int size) {
            return new CoinMarketCapResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRank() {
        return rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public String get_24hVolumeUsd() {
        return _24hVolumeUsd;
    }

    public String getMarketCapUsd() {
        return marketCapUsd;
    }

    public String getAvailableSupply() {
        return availableSupply;
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public String getMaxSupply() {
        return maxSupply;
    }

    public String getPercentChange1h() {
        return percentChange1h;
    }

    public String getPercentChange24h() {
        return percentChange24h;
    }

    public String getPercentChange7d() {
        return percentChange7d;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getPriceInr() {
        return priceInr;
    }

    public String get_24hVolumeInr() {
        return _24hVolumeInr;
    }

    public String getMarketCapInr() {
        return marketCapInr;
    }


    @Override
    public String toString() {
        return
                "\n id='" + id + '\'' +
                "\n name='" + name + '\'' +
                "\n symbol='" + symbol + '\'' +
                "\n rank='" + rank + '\'' +
                "\n priceUsd='" + priceUsd + '\'' +
                "\n priceBtc='" + priceBtc + '\'' +
                "\n _24hVolumeUsd='" + _24hVolumeUsd + '\'' +
                "\n marketCapUsd='" + marketCapUsd + '\'' +
                "\n availableSupply='" + availableSupply + '\'' +
                "\n totalSupply='" + totalSupply + '\'' +
                "\n maxSupply='" + maxSupply + '\'' +
                "\n percentChange1h='" + percentChange1h + '\'' +
                "\n percentChange24h='" + percentChange24h + '\'' +
                "\n percentChange7d='" + percentChange7d + '\'' +
                "\n lastUpdated='" + lastUpdated + '\'' +
                "\n priceInr='" + priceInr + '\'' +
                "\n _24hVolumeInr='" + _24hVolumeInr + '\'' +
                "\n marketCapInr='" + marketCapInr + '\'' ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(symbol);
        parcel.writeString(rank);
        parcel.writeString(priceUsd);
        parcel.writeString(priceBtc);
        parcel.writeString(_24hVolumeUsd);
        parcel.writeString(marketCapUsd);
        parcel.writeString(availableSupply);
        parcel.writeString(totalSupply);
        parcel.writeString(maxSupply);
        parcel.writeString(percentChange1h);
        parcel.writeString(percentChange24h);
        parcel.writeString(percentChange7d);
        parcel.writeString(lastUpdated);
        parcel.writeString(priceInr);
        parcel.writeString(_24hVolumeInr);
        parcel.writeString(marketCapInr);
    }
}
