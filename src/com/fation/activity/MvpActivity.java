package com.fation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fation.R;
import com.fation.adapter.MainGridViewAdapter;
import com.fation.view.MvpView;
import com.gdth.core.annotation.view.ViewInject;
import com.gdth.core.widget.BaseActivity;
import com.gdth.model.ImageItem;
import com.gdth.utils.MenuUtil;
import com.gdth.widget.gridview.LineGridView;

import java.util.List;

public class MvpActivity extends BaseActivity implements MvpView{

    @ViewInject(id=R.id.header_label_title) TextView text_header;
    @ViewInject(id=R.id.header_btn_left) TextView text_header_left;
    @ViewInject(id=R.id.header_btn_right) TextView text_header_right;

    private List<ImageItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        initView();
    }

    private void initView() {
        text_header.setText("主页");
        text_header_left.setVisibility(View.GONE);
        text_header_right.setVisibility(View.GONE);

    }

    @Override
    public void addSuccess() {
        this.showMessage("保存成功");
        finish();
    }

    @Override
    public void editSuccess() {
        this.showMessage("保存成功");
        finish();
    }
}
