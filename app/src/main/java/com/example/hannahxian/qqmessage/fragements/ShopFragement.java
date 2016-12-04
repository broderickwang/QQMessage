package com.example.hannahxian.qqmessage.fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hannahxian.qqmessage.Interfs.OnRecycleViewItemClickListner;
import com.example.hannahxian.qqmessage.R;
import com.example.hannahxian.qqmessage.adapter.MyAdapter;
import com.example.hannahxian.qqmessage.bean.Goods;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hannahxian on 2016/12/3.
 */

public class ShopFragement extends Fragment {
    @Bind(R.id.myRecylceview)
    RecyclerView myRecycleview;
    private boolean isLine = false;

    RecyclerView.LayoutManager lm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shop, container, false);
        ButterKnife.bind(this, v);

        Bundle b = getArguments();
        if(b!=null)
            isLine = b.getBoolean("isline");

        if(isLine)
            lm = new LinearLayoutManager(getActivity());
        else
            lm = new GridLayoutManager(getActivity(), 2);

        myRecycleview.setLayoutManager(lm);


        Goods[] gs = new Goods[10];
        for (int i = 0; i < 10; i++) {
            gs[i] = new Goods("cola", (double) i, "this is test description");
        }

        MyAdapter adapter = new MyAdapter(gs);
        adapter.setClickListner(new OnRecycleViewItemClickListner() {
            @Override
            public void OnItemClick(View view, String gs) {
                Toast.makeText(getActivity(), gs, Toast.LENGTH_SHORT).show();
            }
        });
        myRecycleview.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
