package com.zg6.nba.model;

import android.os.Looper;
import android.os.SystemClock;

import com.zg6.mvvmcore.model.IModel;
import com.zg6.nba.entity.UserEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.nba.model
 * @ClassName: UserCenterRemoteModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 14:05
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 14:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterRemoteModel implements IModel {
    public LiveData<UserEntity> login(final String phoneNumber, final String pwd){
        SystemClock.sleep(500);
        MutableLiveData<UserEntity> liveData=new MutableLiveData<>();
        if (Looper.getMainLooper().getThread()==Thread.currentThread()){
            liveData.setValue(new UserEntity("Server User",""));
        }
        return liveData;
    }
}
