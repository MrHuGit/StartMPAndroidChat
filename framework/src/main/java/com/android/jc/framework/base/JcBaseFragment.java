package com.android.jc.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.jc.framework.base.wrapper.IViewWrapper;

import java.util.ArrayList;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/3/15 18:10
 * @describe
 * @update
 */

public abstract class JcBaseFragment extends Fragment {
    private ArrayList<IViewWrapper> headWrappers = null;
    private ArrayList<IViewWrapper> footWrappers = null;
    private Context mContext;
    @CallSuper
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (headWrappers != null) {
            for (IViewWrapper wrapper : headWrappers) {
                wrapper.onWrapperAttach(context);
            }
        }

        if (footWrappers != null) {
            for (IViewWrapper wrapper : footWrappers) {
                wrapper.onWrapperAttach(context);
            }
        }


        mContext = context;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = onCreateRootView(inflater, container, savedInstanceState);
        LinearLayout result;
        if (rootView instanceof LinearLayout && ((LinearLayout) rootView).getOrientation() == LinearLayout.VERTICAL) {
            result = (LinearLayout) rootView;
            addView(result, inflater, savedInstanceState);
        } else {
            result = new LinearLayout(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            result.setLayoutParams(params);
            result.setOrientation(LinearLayout.VERTICAL);
            result.addView(rootView);
            addView(result, inflater, savedInstanceState);

        }

        return result;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (headWrappers != null) {
            for (IViewWrapper wrapper : headWrappers) {
                wrapper.onWrapperDestroy();
            }
        }

        if (footWrappers != null) {
            for (IViewWrapper wrapper : footWrappers) {
                wrapper.onWrapperDestroy();
            }
        }

    }




    /**
     * 添加头部装饰者
     *
     * @param wrapper
     *
     * @return
     */
    public JcBaseFragment addHeadWrapper(IViewWrapper wrapper) {
        if (headWrappers == null) {
            headWrappers = new ArrayList<>();
        }
        headWrappers.add(wrapper);
        return this;
    }

    /**
     * 添加尾部装饰者
     *
     * @param wrapper
     *
     * @return
     */
    public JcBaseFragment addFootWrapper(IViewWrapper wrapper) {
        if (headWrappers == null) {
            headWrappers = new ArrayList<>();
        }
        headWrappers.add(wrapper);
        return this;
    }


    /**
     * 根据上层的view动态添加头部跟尾部装饰者View进去
     *
     * @param rootView
     * @param inflater
     * @param savedInstanceState
     */
    private void addView(LinearLayout rootView, LayoutInflater inflater, @Nullable Bundle savedInstanceState) {
        if (headWrappers != null) {
            for (int i = 0; i < headWrappers.size(); i++) {
                View headView = headWrappers.get(i).onCreateWrapperView(inflater, savedInstanceState);
                if (headView == null) {
                    continue;
                }
                if (headView.getParent() != null) {
                    throw new IllegalArgumentException("传入头部装饰者的rootView必须没有父控件！");
                }
                rootView.addView(headView, i);

            }
        }
        if (footWrappers != null) {
            for (IViewWrapper wrapper : footWrappers) {
                View footView = wrapper.onCreateWrapperView(inflater, savedInstanceState);
                if (footView == null) {
                    continue;
                }
                if (footView.getParent() != null) {
                    throw new IllegalArgumentException("传入尾部装饰者的rootView必须没有父控件！");
                }
                rootView.addView(footView, rootView.getChildCount() - 1);
            }
        }


    }



    /**
     * 上层添加布局View
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return
     */
    protected abstract View onCreateRootView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
