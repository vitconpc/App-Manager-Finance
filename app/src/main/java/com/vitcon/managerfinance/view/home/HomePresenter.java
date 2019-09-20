package com.vitcon.managerfinance.view.home;

import com.vitcon.managerfinance.data.model.response.DemoResponse;
import com.vitcon.managerfinance.data.repository.DemoRespository;
import com.vitcon.managerfinance.data.source.datademo.DemoSource;
import com.vitcon.managerfinance.view.base.presenter.BasePresenterImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter extends BasePresenterImpl<HomeContact.View> implements HomeContact.Presenter, DemoSource.CallbackFromDataSource<DemoResponse> {

    private CompositeDisposable mCompositeDisposable;
    private DemoRespository mRespository;

    public HomePresenter() {
        mRespository = DemoRespository.getInstance();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onClickToGetDataDemo() {
        //todo call offline
        mRespository.getDatademo(this);

        //todo call api
        Disposable disposable = mRespository.getDataApi().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> {
                    getView().showResult(response.get(0).getTitle());
                }, throwable -> {
                    getView().showResult("sorry");
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getDataSuccess(DemoResponse data) {
        getView().showResult(data.getData());
    }

    @Override
    public void getDataError(String error) {
        getView().showResult(error);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }
}
