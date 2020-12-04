package com.hello.singleton;

/**
 * 饱汉模式的双重锁模式，提高效率
 */
public class SingletonDouble {
	private static SingletonDouble singleton;
	
	private SingletonDouble(){
	}
	
	public static SingletonDouble getInstance(){
		if(singleton == null){
			synchronized(SingletonDouble.class){
				if(singleton == null){
					singleton = new SingletonDouble();
				}
			}
		}
		return singleton;
	}
}