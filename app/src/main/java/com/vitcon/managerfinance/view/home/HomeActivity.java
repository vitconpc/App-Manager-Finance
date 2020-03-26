package com.vitcon.managerfinance.view.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        ImageView image1 = findViewById(R.id.mau1);
        ImageView image2 = findViewById(R.id.mau2);
        ImageView image3 = findViewById(R.id.mau3);

        image1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int w = image1.getWidth();
                image1.setLayoutParams(new LinearLayout.LayoutParams(w,w));
                image1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
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

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().onStop();
    }
}
