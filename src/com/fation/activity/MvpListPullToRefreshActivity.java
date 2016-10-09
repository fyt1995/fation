package com.fation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fation.R;
import com.fation.adapter.MainGridViewAdapter;
import com.fation.view.MvpListView;
import com.gdth.core.annotation.view.ViewInject;
import com.gdth.core.widget.BaseActivity;
import com.gdth.model.ImageItem;
import com.gdth.utils.MenuUtil;
import com.gdth.widget.dialog.BaseToast;
import com.gdth.widget.gridview.LineGridView;

import java.util.List;

public class MvpListPullToRefreshActivity extends BaseActivity implements MvpListView {

    @ViewInject(id=R.id.main_gridview, itemClick="onItemClick") LineGridView mLineGridView;
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

        mLineGridView.setNumColumns(4);
        mList = MenuUtil.getMenuFromAssets(this, "menu/menu.xml");

        MainGridViewAdapter mGridViewAdapter = new MainGridViewAdapter(this, mList, 4);

        mLineGridView.setAdapter(mGridViewAdapter);
    }

    @Override
    public void deleteData(String key) {

    }

    @Override
    public void refreshData(List<ImageItem> mList) {

    }

    @Override
    public void loadMoreData(List<ImageItem> mList) {

    }

    @Override
    public void showProgressDialog(String msg) {
        this.mDialogLoader.setMessage(msg);
        this.mDialogLoader.show();
    }

    @Override
    public void hideProgressDialog() {
        this.mDialogLoader.hide();
    }

    @Override
    public void showMessage(String msg) {
        BaseToast.getInstance().ShowSystemToast(this, msg);
    }
}
