package com.fation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.fation.R;
import com.fation.adapter.MainGridViewAdapter;
import com.gdth.core.annotation.view.ViewInject;
import com.gdth.core.widget.BaseActivity;
import com.gdth.model.ImageItem;
import com.gdth.utils.MenuUtil;
import com.gdth.widget.gridview.LineGridView;

import java.util.List;

/**
 * Created by arvin on 2016/10/1.
 */

public class MainActivity extends BaseActivity {

    @ViewInject(id=R.id.main_gridview, itemClick="onItemClick") LineGridView mLineGridView;
    @ViewInject(id=R.id.header_label_title) TextView text_header;
    @ViewInject(id=R.id.header_btn_left) TextView text_header_left;
    @ViewInject(id=R.id.header_btn_right) TextView text_header_right;

    private List<ImageItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    /**
     * gridview点击事件
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        ImageItem mImageItem = mList.get(arg2);
        Intent intent = new Intent();
        String key = mImageItem.getKey();
        intent.putExtra("name", mImageItem.getValue());
        intent.setClassName(this, key);
        startActivity(intent);
    }
}
