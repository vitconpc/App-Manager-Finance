package com.vitcon.managerfinance.data.repository;

import com.vitcon.managerfinance.data.source.datademo.DemoDataSourceImpl;
import com.vitcon.managerfinance.data.source.datademo.DemoSource;

public class DemoRespository {
    private static DemoRespository sRespository;
    private DemoSource.DataSource mDataSource;

    public DemoRespository(DemoDataSourceImpl instance) {
        mDataSource = instance;
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
}
