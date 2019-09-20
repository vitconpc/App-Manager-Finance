package com.vitcon.managerfinance.data.repository;

import com.vitcon.managerfinance.data.model.response.DataResponse;
import com.vitcon.managerfinance.data.source.datademo.DemoDataSourceImpl;
import com.vitcon.managerfinance.data.source.datademo.DemoSource;
import com.vitcon.managerfinance.network.retrofit.RetrofitApi;
import com.vitcon.managerfinance.network.retrofit.RetrofitApiUtils;

import java.util.List;

import io.reactivex.Observable;

public class DemoRespository {
    private static DemoRespository sRespository;
    private DemoSource.DataSource mDataSource;
    private RetrofitApi mRetrofitApi;

    public DemoRespository(DemoDataSourceImpl instance) {
        mDataSource = instance;
        mRetrofitApi = RetrofitApiUtils.getInstance();
    }

    public static DemoRespository getInstance() {
        if (sRespository == null) {
            sRespository = new DemoRespository(DemoDataSourceImpl.getInstance());
        }
        return sRespository;
    }

    public void getDatademo(DemoSource.CallbackFromDataSource callback) {
        mDataSource.CallData(callback);
    }

    public Observable<List<DataResponse>> getDataApi() {
        return mRetrofitApi.getData();
    }
}
