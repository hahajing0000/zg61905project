package com.zg6.nba.repository;

import com.zg6.mvvmcore.common.Model;
import com.zg6.mvvmcore.repository.BaseRepository;
import com.zg6.nba.entity.UserEntity;
import com.zg6.nba.model.UserCenterRemoteModel;

import androidx.lifecycle.LiveData;
import io.reactivex.Flowable;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.nba.repository
 * @ClassName: UserCenterRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 14:07
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 14:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCenterRepository extends BaseRepository {
    @Model
    UserCenterRemoteModel model;

    public LiveData<UserEntity> login(String phoneNumber, String pwd){
        return model.login(phoneNumber,pwd);
    }

}
