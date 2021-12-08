package com.zg6.mvvmcore.repository;

import com.zg6.mvvmcore.common.Model;
import com.zg6.mvvmcore.model.IModel;

import java.lang.reflect.Field;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.mvvmcore.repository
 * @ClassName: BaseRepository
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 10:58
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 10:58
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseRepository{
    public BaseRepository(){
        injectModel();
    }

    /**
     * 通过反射+注解注入Model层 支持1对多
     * @param
     * @return
     * @author zhangyue
     * @time 2021/12/7 11:01
     */
    private void injectModel() {

        //      能拿到当前类的public及 父类的public字段   getClass().getFields();
        //Declared 能当前类的所有字段 包括private的
        Field[] fields = getClass().getDeclaredFields();
        boolean flag=false;
        for (Field field:fields){
            Model annotation = field.getAnnotation(Model.class);
//            annotation.value();
            if (null!=annotation){
                flag=true;
                field.setAccessible(true);

                String clazzName = field.getType().getName();
                try {
                    Class<?> clazz = Class.forName(clazzName);
                    Object fieldInstance = clazz.newInstance();
                    field.set(this,fieldInstance);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!flag){
            throw new IllegalStateException("no any field by Model Ann...");
        }

    }
}
