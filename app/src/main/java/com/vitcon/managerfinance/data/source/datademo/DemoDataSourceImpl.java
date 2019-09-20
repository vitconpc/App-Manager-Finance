package com.vitcon.managerfinance.data.source.datademo;

import com.vitcon.managerfinance.data.model.response.DemoResponse;

public class DemoDataSourceImpl implements DemoSource.DataSource{

    private static DemoDataSourceImpl sDemoDataSource;

    public static DemoDataSourceImpl getInstance(){
        if (sDemoDataSource == null){
            sDemoDataSource = new DemoDataSourceImpl();
        }
        return sDemoDataSource;
    }
    @Override
    public void CallData(DemoSource.CallbackFromDataSource<DemoResponse> listener) {
            String a = "Hello";//todo get data here
        DemoResponse response = new DemoResponse();
        response.setData(a);
        listener.getDataSuccess(response);
    }
}
