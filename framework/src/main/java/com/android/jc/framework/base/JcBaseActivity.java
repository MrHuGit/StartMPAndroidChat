package com.android.jc.framework.base;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.android.jc.framework.R;


/**
 * @author Mr.Hu(Jc)
 * @create 2018/3/15 18:06
 * @describe
 * @update
 */

public class JcBaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void setTranslucentStatus() {
        Window window = getWindow();
        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected boolean needStatusBar() {
        return true;
    }

    @ColorInt
    protected int setStatusBarColorResource() {
        return Color.parseColor("#000000");
    }

    protected <T extends Fragment> T findFragment(Class<T> tClass) {
        Fragment oldFragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        T t = null;
        if (oldFragment != null) {
            if (oldFragment.getClass().getName().equals(tClass.getName())) {
                try {
                    t = (T) oldFragment;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                getSupportFragmentManager().beginTransaction().remove(oldFragment).commit();
            }


        }
        return t;
    }

    protected void addFragment(Fragment fragment) {
        setContentView(R.layout.activity_jc_base);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).commit();
    }


}
