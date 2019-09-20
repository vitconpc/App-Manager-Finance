package com.vitcon.managerfinance.data.source.datademo;

import com.vitcon.managerfinance.data.model.response.DemoResponse;

public interface DemoSource {
    interface DataSource {
        void CallData(CallbackFromDataSource<DemoResponse> listener);
    }

    interface CallbackFromDataSource<T> {
        void getDataSuccess(T data);
        void getDataError(String error);
    }
}
