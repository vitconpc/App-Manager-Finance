package com.vitcon.managerfinance.view.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vitcon.managerfinance.R;
import com.vitcon.managerfinance.view.base.activity.BaseActivity;

import java.util.List;

public class HomeActivity extends BaseActivity<HomeContact.Presenter> implements HomeContact.View, View.OnClickListener {

    private TextView mTextContent;
    @Override
    protected HomeContact.Presenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTextContent = findViewById(R.id.txt_content);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        getPresenter().setView(this);
    }

    @Override
    protected void initEvent() {
        findViewById(R.id.btn_click_me).setOnClickListener(this);
    }

    @Override
    public void showResult(String demo) {
        if (demo!=null){
            mTextContent.setText(demo);
        }
    }

    @Override
    public void onClick(View v) {
        getPresenter().onClickToGetDataDemo();
    }
}
