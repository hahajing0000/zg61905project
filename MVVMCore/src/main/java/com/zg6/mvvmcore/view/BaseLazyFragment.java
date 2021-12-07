package com.zg6.mvvmcore.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.view
 * @ClassName: BaseLazyFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 13:19
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 13:19
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseLazyFragment extends BaseFragment {
    //第一次加载
    boolean isFirst=true;
    //视图创建成功
    boolean isViewCreated=false;
    //是否用户可见
    boolean isVisibleToUser=false;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean _isVisibleToUser) {
        super.setUserVisibleHint(_isVisibleToUser);

        if (_isVisibleToUser){
            preformLoadData();
            isVisibleToUser=_isVisibleToUser;
        }else{
            isVisibleToUser=false;
        }
    }

    private void preformLoadData() {
        if (isFirst&&isVisibleToUser&&isViewCreated){
            lazyLoadData();
            isFirst=false;
        }
    }

    protected abstract void lazyLoadData();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated=true;
    }
}
