package com.zg6.mvvmcore.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.view
 * @ClassName: BaseFragment
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 13:03
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 13:03
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    /**
     * 第一次被加载
     */
    boolean isViewCreated=false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity= (BaseActivity) getActivity();
        return createView(inflater,container,savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated=true;
    }

    @Override
    public void onResume() {
        super.onResume();
        prepareLoadData();
    }

    boolean isFirst=true;
    private void prepareLoadData() {
        if (isFirst&&isViewCreated){
            loadData();
            isFirst=false;
        }
    }

    protected abstract void loadData();

    protected abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
