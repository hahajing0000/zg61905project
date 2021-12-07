package com.zg6.mvvmcore.viewmodel;

import com.zg6.mvvmcore.repository.BaseRepository;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.viewmodel
 * @ClassName: BaseViewModel
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 11:10
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 11:10
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseViewModel<Repo  extends BaseRepository> implements LifecycleObserver {
    protected Repo mRepo;
    protected LifecycleOwner mOwner;
    public BaseViewModel(LifecycleOwner _owner){
        mRepo=createRepository();
        this.mOwner=_owner;
        _owner.getLifecycle().addObserver(this);
    }

    /**
     * 创建对应的数据仓库实例 
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 11:12
     */ 
    protected abstract Repo createRepository();
    
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void activityOnCreate(){
        initResource();
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void activityOnStop(){
        releaseResource();
    }

    /**
     * 释放使用过的资源
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/12/7 11:14
     */ 
    protected abstract void releaseResource();

    /**
     * 初始化资源
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 11:13
     */ 
    protected abstract void initResource();
}
