package com.example.hannahxian.qqmessage;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannahxian.qqmessage.fragements.ShopFragement;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Shop extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.frame)
    FrameLayout frame;

    FragmentTransaction trance;
    @Bind(R.id.clock)
    TextView change;
    private FragmentManager manager;

    boolean isLean = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        manager = getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        initalToolBar();
        trance = getSupportFragmentManager().beginTransaction();
        trance.replace(R.id.frame, new ShopFragement());
        trance.addToBackStack(null);
        trance.commit();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopFragement fragment1 = new ShopFragement();

                isLean = !isLean;
                bundle.putBoolean("isline",isLean);
                fragment1.setArguments(bundle);
                trance = manager.beginTransaction();
                trance.replace(R.id.frame, fragment1);
                trance.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.itemmenu,menu);
        return true;
    }

    private void initalToolBar() {
        setSupportActionBar(toolbar);

        /*toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo*/
        toolbar.setTitle("Title");//设置主标题
        toolbar.setSubtitle("Subtitle");//设置子标题

        toolbar.inflateMenu(R.menu.itemmenu);//设置右上角的填充菜单
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cart:
                break;
        }
        return true;
    }
}
