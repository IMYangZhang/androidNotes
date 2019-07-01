package com.example.androidnotes.Serializable;

import android.support.annotation.NonNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MySerializable{
    String filePath;
    People people;

    public MySerializable(@NonNull People people,@NonNull String filePath) {
        this.people = people;
        this.filePath = filePath;
    }

    public void writeFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(people);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public People readFile(){
        People p=null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            p = (People) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  p;
    }

    public ByteArrayOutputStream writeArrayByte(){
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream  = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(people);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    public People readArrayByte(ByteArrayOutputStream byteArrayOutputStream) {
        People p =null;
        try {
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream);
            p= (People) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return p;
    }
}
