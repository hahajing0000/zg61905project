package com.zg6.mvvmcore.view;

import android.os.Bundle;
import android.util.SparseArray;

import com.zg6.mvvmcore.R;
import com.zg6.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.view
 * @ClassName: BaseMVVMActivity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 11:19
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 11:19
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseMVVMActivity<VM extends BaseViewModel,Binding extends ViewDataBinding> extends BaseActivity {
    protected VM mViewModel;
    protected Binding mDataBinding;
    private HashMap<Integer,Object> mMap=new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding= DataBindingUtil.setContentView(this,getLayoutId());
        //如果不设置binding的生命周期 会出现LiveData数据不更新的问题
        mDataBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        prepareSetVars(mMap);
        setVars(mDataBinding,mMap);
        
    }

    /**
     * 设置页面数据源
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 13:03
     */ 
    private void setVars(Binding mDataBinding, HashMap<Integer, Object> mMap){
        if (null==mMap||mMap.size()==0||mDataBinding==null){
            throw new IllegalStateException("need set binding or vars");
        }
        for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
            if (entry.getValue()==null){
                continue;
            }
            mDataBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    /**
     * 提供给子类来实现 用于设置页面上需要用到的变量数据源
     * @param
     * @return
     * @author zhangyue
     * @time 2021/12/7 11:27
     */
    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    /**
     * 创建ViewModel方法
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/12/7 11:25
     */ 
    protected abstract VM createViewModel();

    /**
     * 获取布局id
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 11:24
     */ 
    protected abstract int getLayoutId();
}
