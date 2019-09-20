package com.vitcon.managerfinance.view.base.presenter;

import com.vitcon.managerfinance.view.base.view.BaseView;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {

    private V mView;

    @Override
    public void setView(V view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public V getView() {
        return mView;
    }
}
