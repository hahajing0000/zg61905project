package com.zg6.mvvmcore.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.view
 * @ClassName: BaseActivity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 11:15
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 11:15
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //沉浸式处理 去掉状态栏
        //夜间模式处理
        //等等
        super.onCreate(savedInstanceState);

//        getSupportFragmentManager().beginTransaction().replace(0,null).commitAllowingStateLoss();

//        FragmentStatePagerAdapter
//        FragmentPagerAdapter
    }

    public void showMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void jumpToTarget(Class<?> target){
        startActivity(new Intent(this,target));
    }

    public void jumpToTarget(Class<?> target,Bundle params){
        Intent intent=new Intent(this,target);
        intent.putExtra("params",params);
        startActivity(intent);
    }
}
