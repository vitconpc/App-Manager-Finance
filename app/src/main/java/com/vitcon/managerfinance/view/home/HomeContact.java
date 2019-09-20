package com.vitcon.managerfinance.view.home;

import com.vitcon.managerfinance.view.base.presenter.BasePresenter;
import com.vitcon.managerfinance.view.base.view.BaseView;

public interface HomeContact {
    interface View extends BaseView{
        void showResult(String demo);
    }

    interface Presenter extends BasePresenter<View>{
        void onClickToGetDataDemo();
    }
}
