package com.winchampion.credit.pure.equator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *  比较两个list 
 * @author wangzunmin
 *
 */
public class Test {

	public static void main(String[] args) {
//		Equator equator = new GetterBaseEquator();
//		User user1 = new User("tom", 18);
//		User user2 = new User("jack", 20);
//		boolean b = equator.isEquals(user1, user2);
//		System.out.println(b);
//		List<FieldInfo> diff = equator.getDiffFields(user1, user2);
//		System.out.println(diff);
		
//		List<String> list1 = new ArrayList<String>();
//		list1.add("aa");
//		list1.add("cc");
//		list1.add("bb");
//		list1.add("dd");
//		List<String> list2 = new ArrayList<String>();
//		list2.add("aa");
//		list2.add("ee");
//		list2.add("dd");
//		list2.add("ff");
//		list2.add("hh");
//		List<String> different = getDifferent(list1, list2);
//		System.out.println(different);
		
		
//		List<User> list1 = new ArrayList<User>();
//		list1.add(new User("tom1",18));
//		list1.add(new User("tom2",18));
//		list1.add(new User("tom3",18));
//		list1.add(new User("tom4",18));
//		List<User> list2 = new ArrayList<User>();
//		list2.add(new User("tom1",18));
//		list2.add(new User("tom5",18));
//		list2.add(new User("tom2",18));
//		list2.add(new User("tom3",18));
//		List<User> userDiff = getUserDiff(list1, list2);
//		System.out.println(userDiff);
		
		
		removeAllTest();
	}
	
	
	
	public static List<String> getDifferent(List<String> list1, List<String> list2){
		List<String> diff = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
		for(String str : list1) {
			map.put(str, 1);
		}
		for(String str : list2) {
			Integer integer = map.get(str);
			if(integer != null) {
				map.put(str, ++integer);
				continue;
			}
			map.put(str, 1);
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				diff.add(entry.getKey());
			}
		}
		return diff;
	}
	
	/**
	 *  具体user对象 需要复写equals和hashcode方法
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<User> getUserDiff(List<User> list1, List<User> list2){
		List<User> diff = new ArrayList<User>();
		Map<User, Integer> map = new HashMap<User, Integer>(list1.size() + list2.size());
		for(User user : list1) {
			map.put(user,1);
		}
		for(User user : list2) {
			Integer integer = map.get(user);
			if(integer != null) {
				map.put(user, ++integer);
				continue;
			}
			map.put(user,1);
		}
		for (Map.Entry<User, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				diff.add(entry.getKey());
			}
		}
		return diff;
	}
	
	
	public static void removeAllTest() {
		List<User> lists = new ArrayList<User>();
		lists.add(new User("tom1",18));
		lists.add(new User("tom2",20));
		lists.add(new User("tom3",23));
		List<User> list1 = new ArrayList<User>();
		list1.add(new User("tom3",23));
		list1.add(new User("tom4",20));
		list1.add(new User("tom5",23));
		lists.removeAll(list1);
		System.out.println(lists);
	}

}
