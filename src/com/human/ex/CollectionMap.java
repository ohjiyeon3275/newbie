package com.human.ex;

import java.util.HashMap;
import java.util.Iterator;

public class CollectionMap {
	public static void main(String[] args) {
		
		//객체로 map을 사용하기
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
			//제네릭 <key, value> 
		
		//추가
		hm.put("삼십", 30);
		hm.put("십", 10);
		hm.put("사십", 40);
		hm.put("오십", 50);
		
		//key값들을 배열로 리턴함
		System.out.println(hm.keySet());
		
		//순회하면서 구현
		for(String key : hm.keySet()) {
			System.out.println(key);
		}
		
		//삭제
		hm.remove("사십");
		
		Iterator<String> keys = hm.keySet().iterator();
								//set Collection
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("key:%s value:%d", key, hm.get(key)));
		}
		
		//대체(값 변경)
		hm.replace("이십",200);
		for(String key : hm.keySet()) {
			System.out.println(String.format("key:%s value:%d", key, hm.get(key)));
		}
		
		System.out.println("사이즈"+hm.size());
		
		
		
	}
}
