package com.android.jc.mp_android_chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.jc.framework.base.JcBaseActivity;
import com.android.jc.framework.recyclerview.NormalRvAdapter;
import com.android.jc.framework.recyclerview.ViewHolder;
import com.android.jc.mp_android_chat.line.LineChartActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Hu(Jc)
 * @create 2018/6/7 20:02
 * @organize
 * @describe
 * @update
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NormalRvAdapter<ItemBean> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new NormalRvAdapter<ItemBean>(R.layout.item_main_rv) {
            @Override
            public void convert(ViewHolder holder, ItemBean bean, int position) {
                holder.setText(R.id.tv_name,bean.getName());
            }
        });
        mAdapter.setOnItemClickListener((view, holder, bean, position) -> startActivity(new Intent(MainActivity.this, bean.gettClass())));
        List<ItemBean> list = new ArrayList<>();
        list.add(new ItemBean("折线图", LineChartActivity.class));
        mAdapter.setList(list).notifyDataSetChanged();
    }


    public static class ItemBean {
        private String name;
        private Class<? extends JcBaseActivity> tClass;

        public ItemBean(String name, Class<? extends JcBaseActivity> tClass) {
            this.name = name;
            this.tClass = tClass;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class<? extends JcBaseActivity> gettClass() {
            return tClass;
        }

        public void settClass(Class<? extends JcBaseActivity> tClass) {
            this.tClass = tClass;
        }
    }
}
