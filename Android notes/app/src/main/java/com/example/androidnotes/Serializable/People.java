package com.example.androidnotes.Serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient int age; // 不进行序列化
    private String name;
    private Boolean sex; // boy 1,girl 0

    public People(){
    }

    public People(int age,String name,boolean sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }


    // 此方法用于反射，写transient对象
    private void writeObject(ObjectOutputStream outputStream){
        try {
            outputStream.defaultWriteObject();
            outputStream.writeObject(age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 此方法用于反射，读取transient对象
    private void readObject(ObjectInputStream inputStream){
        try {
            inputStream.defaultReadObject();
            age = inputStream.readInt();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
