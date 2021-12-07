package com.zg6.nba.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;

import com.zg6.mvvmcore.view.BaseMVVMActivity;
import com.zg6.mvvmcore.viewmodel.BaseViewModel;
import com.zg6.nba.BR;
import com.zg6.nba.R;
import com.zg6.nba.databinding.ActivityMainBinding;
import com.zg6.nba.entity.UserEntity;
import com.zg6.nba.viewmodel.UserCenterViewModel;

import java.util.HashMap;

public class MainActivity extends BaseMVVMActivity<UserCenterViewModel, ActivityMainBinding> {


    @Override
    protected void prepareSetVars(HashMap<Integer, Object> mMap) {
        mMap.put(BR.user,mViewModel.dataSource);
        mMap.put(BR.owner,this);
    }

    @Override
    protected UserCenterViewModel createViewModel() {
        return new UserCenterViewModel(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    public void onClickForLogin(View view){
        UserEntity userEntity = mViewModel.dataSource.getValue();
        LiveData<UserEntity> result = mViewModel.login(userEntity.getPhoneNumber(), userEntity.getPwd());
        result.observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                showMsg(userEntity.toString());
            }
        });
    }
}