package com.fation.view;

import com.gdth.model.ImageItem;

import java.util.List;

/**
 * Created by arvin on 2016/10/3.
 */

public interface MvpListView extends BaseView {
    /**
     * 删除
     *
     * @param key
     */
    void deleteData(String key);

    /**
     * 数据刷新
     *
     * @param mList
     */
    void refreshData(List<ImageItem> mList);

    /**
     * 加载更多
     *
     * @param mList
     */
    void loadMoreData(List<ImageItem> mList);
}