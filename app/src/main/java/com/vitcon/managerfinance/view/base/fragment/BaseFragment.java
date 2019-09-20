package com.vitcon.managerfinance.view.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vitcon.managerfinance.view.base.presenter.BasePresenter;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private T mPresenter;

    protected T getPresenter() {
        return mPresenter;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getContext()).inflate(getLayoutResource(),container,false);
        mPresenter = initPresenter();
        initView(savedInstanceState,rootView);
        initData(savedInstanceState);
        return rootView;
    }

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initView(Bundle savedInstanceState, View rootView);

    protected abstract T initPresenter();

    protected abstract int getLayoutResource();
}
