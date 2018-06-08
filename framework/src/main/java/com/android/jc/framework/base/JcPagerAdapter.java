package com.android.jc.framework.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/5/10 14:52
 * @organize
 * @describe
 * @update
 */
public class JcPagerAdapter extends PagerAdapter {
    private List<View> mViewList;
    private List<CharSequence> mTitleList;
    public JcPagerAdapter(){

    }

    public JcPagerAdapter add(View view, CharSequence title){
        if (mViewList==null){
            mViewList=new ArrayList<>();
        }
        if (mTitleList==null){
            mTitleList=new ArrayList<>();
        }
        mViewList.add(view);
        mTitleList.add(title);
        return this;
    }
    @Override
    public int getCount() {
        return mViewList!=null?mViewList.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList==null?super.getPageTitle(position):mTitleList.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=mViewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }
}
