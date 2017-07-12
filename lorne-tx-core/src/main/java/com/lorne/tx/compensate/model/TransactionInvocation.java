package com.lorne.tx.compensate.model;

import com.lorne.tx.exception.TransactionException;
import com.lorne.tx.serializer.JavaSerializer;
import com.lorne.tx.serializer.ObjectSerializer;

import java.io.Serializable;

/**
 * <p>Description: .</p>
 * <p>Copyright: 2015-2017 happylifeplat.com All Rights Reserved</p>
 *  TransactionInvocation 事务补偿方法参数
 * @author yu.xiao@happylifeplat.com
 * @version 1.0
 * @since JDK 1.8
 */
public class TransactionInvocation implements Serializable {

    private static final long serialVersionUID = 7722060715819141844L;

    private final static ObjectSerializer serializer = new JavaSerializer();
    /**
     * 事务执行器
     */
    private Class targetClazz;
    /**
     * 方法
     */
    private String method;
    /**
     * 参数值
     */
    private Object[] argumentValues;

    public byte[] toSerializable(){
        try {
            return serializer.serialize(this);
        } catch (TransactionException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static TransactionInvocation parser(byte[] bs){
        try {
            return serializer.deSerialize(bs,TransactionInvocation.class);
        } catch (TransactionException e) {
            e.printStackTrace();
            return null;
        }
    }


    public TransactionInvocation() {
    }


    public TransactionInvocation(Class targetClazz, String method, Object[] argumentValues) {
        this.targetClazz = targetClazz;
        this.method = method;
        this.argumentValues = argumentValues;
    }


    public Class getTargetClazz() {
        return targetClazz;
    }

    public String getMethod() {
        return method;
    }

    public Object[] getArgumentValues() {
        return argumentValues;
    }

}