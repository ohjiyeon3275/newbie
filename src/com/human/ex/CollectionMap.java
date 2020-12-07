package com.human.ex;

import java.util.HashMap;
import java.util.Iterator;

public class CollectionMap {
	public static void main(String[] args) {
		
		//��ü�� map�� ����ϱ�
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
			//���׸� <key, value> 
		
		//�߰�
		hm.put("���", 30);
		hm.put("��", 10);
		hm.put("���", 40);
		hm.put("����", 50);
		
		//key������ �迭�� ������
		System.out.println(hm.keySet());
		
		//��ȸ�ϸ鼭 ����
		for(String key : hm.keySet()) {
			System.out.println(key);
		}
		
		//����
		hm.remove("���");
		
		Iterator<String> keys = hm.keySet().iterator();
								//set Collection
		while(keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("key:%s value:%d", key, hm.get(key)));
		}
		
		//��ü(�� ����)
		hm.replace("�̽�",200);
		for(String key : hm.keySet()) {
			System.out.println(String.format("key:%s value:%d", key, hm.get(key)));
		}
		
		System.out.println("������"+hm.size());
		
		
		
	}
}
