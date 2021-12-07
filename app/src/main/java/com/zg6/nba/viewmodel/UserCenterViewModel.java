package com.zg6.nba.viewmodel;

import android.os.Looper;
import android.util.Log;

import com.zg6.mvvmcore.viewmodel.BaseViewModel;
import com.zg6.nba.entity.UserEntity;
import com.zg6.nba.repository.UserCenterRepository;

import org.reactivestreams.Subscription;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.nba.viewmodel
 * @ClassName: UserCenterViewModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 14:09
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 14:09
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterViewModel extends BaseViewModel<UserCenterRepository> {
    public MutableLiveData<UserEntity> dataSource=new MutableLiveData<>();
    public UserCenterViewModel(LifecycleOwner _owner) {
        super(_owner);

        dataSource.setValue(new UserEntity());
    }

    @Override
    protected UserCenterRepository createRepository() {
        return new UserCenterRepository();
    }

    @Override
    protected void releaseResource() {

    }

    @Override
    protected void initResource() {

    }

    public LiveData<UserEntity> login(String phoneNumber,String pwd){
        return mRepo.login(phoneNumber,pwd);
    }


}
