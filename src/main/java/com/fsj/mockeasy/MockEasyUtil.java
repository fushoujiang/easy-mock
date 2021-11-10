package com.fsj.mockeasy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class MockEasyUtil {


    public static <T> T getDefaultBean(Class object) throws Exception {
        Class classType= Class.forName(object.getName());
        Field[] fields = classType.getDeclaredFields();//得到对象中的字段
        //每次循环时，重新实例化一个与传过来的对象类型一样的对象
        T objectCopy = null;
        if (classType.isInterface()){
            if (classType.isInstance(List.class)){
                objectCopy = (T) new ArrayList();
            }
        }else {
            objectCopy = (T)classType.getDeclaredConstructor().newInstance();
        }
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            Object value = null;
            //根据字段类型决定结果集中使用哪种get方法从数据中取到数据
            Class<?> fieldType = field.getType();
            if (fieldType.equals(String.class)) {
                value = "";
            } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
                value = new Integer(0);
            } else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
                value = new Double(0);
            } else if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
                value = new Long(0);
            } else if (fieldType.equals(Date.class)) {
                value = new Date();
            } else if (fieldType.equals(Object.class)) {
                value = new Object();
            } else if (fieldType.equals(List.class)){
                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                Class<?> actualTypeArgument = (Class<?>)pt.getActualTypeArguments()[0];
                List list = new ArrayList();
                list.add(getDefaultBean(actualTypeArgument));
                value = list;
            } else if (fieldType.equals(Boolean.class)){
                value =Boolean.TRUE;
            } else{
                value =  getDefaultBean(fieldType);
            }
            // 获得属性的首字母并转换为大写，与setXXX对应
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String setMethodName = "set" + firstLetter
                    + fieldName.substring(1);
            if (fieldName.equals("serialVersionUID")) {
                continue;
            }
            Method setMethod = classType.getMethod(setMethodName,
                    new Class[]{fieldType});
            setMethod.invoke(objectCopy, value);//调用对象的setXXX方法
        }
        return objectCopy;
    }







    /**
     * 得到属性值
     * @param obj
     */
    public static String readAttributeValue(Object obj){
        String nameVlues="";
        //得到class
        Class cls = obj.getClass();
        //得到所有属性
        Field[] fields = cls.getDeclaredFields();
        for (int i=0;i<fields.length;i++){//遍历
            try {
                //得到属性
                Field field = fields[i];
                //打开私有访问
                field.setAccessible(true);
                //获取属性
                String name = field.getName();
                //获取属性值
                Object value = field.get(obj);
                //一个个赋值
                nameVlues += field.getName()+":"+value+",";
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }//获取最后一个逗号的位置
        int lastIndex = nameVlues.lastIndexOf(",");
        //不要最后一个逗号","
        return  nameVlues.substring(0,lastIndex);
    }
}
