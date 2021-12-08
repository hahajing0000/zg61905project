package com.zg6.mvvmcore.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zg6.mvvmcore.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.view
 * @ClassName: BaseMVVMFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 13:40
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 13:40
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseMVVMFragment<VM extends BaseViewModel,Binding extends ViewDataBinding> extends BaseLazyFragment {
    protected VM mViewModel;
    protected Binding mBinding;
    private HashMap<Integer,Object> mMap=new HashMap<>();
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewModel=createViewModel();
        mBinding= DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        mBinding.setLifecycleOwner(this);
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
        return mBinding.getRoot();
    }

    private void setVars(Binding mBinding, HashMap<Integer, Object> mMap) {
        if (null==mBinding||null==mMap||mMap.size()==0){
            for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
                if (entry.getValue()==null){
                    continue;
                }
                mBinding.setVariable(entry.getKey(),entry.getValue());
            }
        }
    }

    /**
     * 准备页面需要的数据源
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 13:56
     */ 
    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    /**
     * 获取布局id
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 13:56
     */ 
    protected abstract int getLayoutId();

    /**
     * 创建ViewModle实例
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/12/7 13:59
     */ 
    protected abstract VM createViewModel();
}
