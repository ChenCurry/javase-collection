package com.hello.collection.array;

//ArrayList 动态数组集合
public class MyArrayList {
    //数组保存数据
    private Object[] elementData;

    //定义数组长度
    private int size;

    //初始容量为10
    public MyArrayList() {
        elementData = new Object[10];
    }

    public void add(Object obj) {
        if (size >= elementData.length) {
            Object[] temp = new Object[elementData.length * 2];
            System.arraycopy(elementData, 0, temp, 0, size);
            elementData = temp;
        }
        elementData[size++] = obj;
        System.out.println("============================================");
        System.out.println("size:"+size);
        System.out.println("elementData.length:"+elementData.length);
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 11; i++) {
            myArrayList.add(i);
        }
    }
}
