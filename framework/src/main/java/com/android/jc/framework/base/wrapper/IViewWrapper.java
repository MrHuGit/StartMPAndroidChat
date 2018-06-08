package com.android.jc.framework.base.wrapper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/3/15 18:28
 * @describe
 * @update
 */

public interface IViewWrapper {
    /**
     * onAttach
     * @param context
     */
    void onWrapperAttach(Context context);
    /**
     * 动态添加View
     * @param inflater
     * @param savedInstanceState
     * @return
     */
    View onCreateWrapperView(LayoutInflater inflater, @Nullable Bundle savedInstanceState);


    /**
     * 销毁
     */
    void onWrapperDestroy();

}
