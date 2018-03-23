package com.techkei.thirumaran.retrofit.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.techkei.thirumaran.retrofit.R;
import com.techkei.thirumaran.retrofit.model.dto.response.ContentResponse;
import com.techkei.thirumaran.retrofit.presenter.IPresenter.IMainActivityPresenter;
import com.techkei.thirumaran.retrofit.presenter.MainActivityPresenter;
import com.techkei.thirumaran.retrofit.view.IView.IMainActivityView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IMainActivityView {

    @BindView(R.id.et_post)
    EditText etPost;
    private IMainActivityPresenter iMainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iMainActivityPresenter = new MainActivityPresenter(this);
        iMainActivityPresenter.onCreatePresenter(getIntent().getExtras());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.bt_post)
    public void onClickPost() {
        if (etPost.getText().toString().trim().length() > 0) {
            iMainActivityPresenter.postData(etPost.getText().toString().trim());
        }
    }

    @Override
    public void setSuccessDatya(ContentResponse data) {
        showMessage(data.getMessage());
    }

    @Override
    public void setFailureMessage(String message) {
        showMessage(message);
    }
}
