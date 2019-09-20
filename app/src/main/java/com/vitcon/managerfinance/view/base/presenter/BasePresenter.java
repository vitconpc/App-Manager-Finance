package com.vitcon.managerfinance.view.base.presenter;

import com.vitcon.managerfinance.view.base.view.BaseView;

public interface BasePresenter<V extends BaseView> {

    void setView(V view);

    void onStart();

    void onStop();
}
