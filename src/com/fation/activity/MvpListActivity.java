package com.fation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.fation.R;
import com.fation.view.MvpListView;
import com.gdth.adapter.ListViewAdapter;
import com.gdth.core.annotation.view.ViewInject;
import com.gdth.core.widget.BaseActivity;
import com.gdth.model.ImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arvin on 2016/10/1.
 */

public class MvpListActivity extends BaseActivity implements MvpListView {
    @ViewInject(id=R.id.header_label_title) TextView text_header;
    @ViewInject(id=R.id.header_btn_left) TextView text_header_left;
    @ViewInject(id=R.id.header_btn_right) TextView text_header_right;

    @ViewInject(id=R.id.mvp_listview, itemClick="onItemClick")
    ListView mListView;

    private List<ImageItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_list);

        initView();
    }

    private void initView() {
        String title = this.getIntent().getStringExtra("name");
        text_header.setText(title);

        mList = new ArrayList<ImageItem>();

        ListViewAdapter mGridViewAdapter = new ListViewAdapter(this, mList);

        mListView.setAdapter(mGridViewAdapter);
    }

    /**
     * gridview点击事件
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        ImageItem mImageItem = mList.get(arg2);
        Intent intent = new Intent(this, MvpActivity.class);
        intent.putExtra("name", "添加");
        intent.putExtra("key", mImageItem.getKey());

        startActivity(intent);
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
}
