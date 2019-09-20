package com.vitcon.managerfinance.network.retrofit;

import com.vitcon.managerfinance.data.model.response.DataResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("photos")
    Observable<List<DataResponse>> getData();
}
