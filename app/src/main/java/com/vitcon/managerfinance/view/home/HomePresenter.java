package com.vitcon.managerfinance.view.home;

import android.widget.Toast;

import com.vitcon.managerfinance.data.model.DemoResponse;
import com.vitcon.managerfinance.data.repository.DemoRespository;
import com.vitcon.managerfinance.data.source.datademo.DemoSource;
import com.vitcon.managerfinance.view.base.presenter.BasePresenterImpl;

public class HomePresenter extends BasePresenterImpl<HomeContact.View> implements HomeContact.Presenter, DemoSource.CallbackFromDataSource<DemoResponse> {

    private DemoRespository mRespository;
    public HomePresenter() {
        mRespository = DemoRespository.getInstance();
    }

    @Override
    public void onClickToGetDataDemo() {
        mRespository.getDatademo(this);
    }

    @Override
    public void getDataSuccess(DemoResponse data) {
        getView().showResult(data.getData());
    }

    @Override
    public void getDataError(String error) {
        getView().showResult(error);
    }
}
