package com.vitcon.managerfinance.view.base.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vitcon.managerfinance.R;
import com.vitcon.managerfinance.view.base.presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    private T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        mPresenter = initPresenter();
        initView(savedInstanceState);
        initEvent();
        initData(savedInstanceState);
    }

    protected abstract T initPresenter();

    protected T getPresenter(){
        return mPresenter;
    }

    protected abstract int getLayoutResource();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initEvent();
}
