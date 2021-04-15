package com.example.pap_fr_2_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.pap_fr_2_android.ui.main.MainFragment;
import com.example.pap_fr_2_android.ui.main.DongtaiFragment;
import com.example.pap_fr_2_android.ui.main.MessageFragment;
import com.example.pap_fr_2_android.ui.main.MineFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    
    private final int show_tab_mainpage = 0;
    private final int show_tab_dongtai = 1;
    private final int show_tab_message = 2;
    private final int show_tab_mine = 3;
    private int mrIndex = show_tab_mainpage;
    private int index = -1;

    private static final String[] FRAGMENT_TAG = {"main","dongtai", "message","mine"};

    private MainFragment mainFragment;
    private DongtaiFragment dongtaiFragment;
    private MessageFragment messageFragment;
    private MineFragment mineFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.main_activity);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState !=null){
            mrIndex = savedInstanceState.getInt("PREV_SELINDEX", mrIndex);
            mainFragment = (MainFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            dongtaiFragment = (DongtaiFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            messageFragment = (MessageFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);
            mineFragment = (MineFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[3]);
        }
        initView();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("PREV_SELINDEX", mrIndex);
        super.onSaveInstanceState(outState);
    }
    protected void initView() {
        //获得RadioGroup控件
        radioGroup = (RadioGroup)findViewById(R.id.rg_group);
        //选择设置Fragment
        setTabSelection(show_tab_mainpage);
        //点击事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mainpage://主页
                        setTabSelection(show_tab_mainpage);
                        break;
                    case R.id.rb_dongtai://动态
                        setTabSelection(show_tab_dongtai);
                        break;
                    case R.id.rb_message://消息
                        setTabSelection(show_tab_message);
                        break;
                    case R.id.rb_mine://我的
                        setTabSelection(show_tab_mine);
                        break;
                    default:
                        break;
                }
            }
        });
    }
    private void setTabSelection(int id) {    //根据传入的index参数来设置选中的tab页。
        if (id == index) {
            return;
        }
        index = id;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case show_tab_mainpage://首页的fragment
                radioGroup.check(R.id.rb_mainpage);
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    transaction.add(R.id.container, mainFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(mainFragment);
                }
                transaction.commit();
                break;
            case show_tab_dongtai://动态的fragment
                radioGroup.check(R.id.rb_dongtai);
                if (dongtaiFragment == null) {
                    dongtaiFragment = new DongtaiFragment();
                    transaction.add(R.id.container, dongtaiFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(dongtaiFragment);
                }
                transaction.commit();
                break;
            case show_tab_message://消息的fragment
                radioGroup.check(R.id.rb_message);
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                    transaction.add(R.id.container, messageFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(messageFragment);
                }
                transaction.commit();
                break;
            case show_tab_mine://我的的fragment
                radioGroup.check(R.id.rb_mine);//我的的fragmen
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.container, mineFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(mineFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }
    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (dongtaiFragment != null) {
            transaction.hide(dongtaiFragment);
        }
        if (messageFragment != null) {
            transaction.hide(messageFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

}
