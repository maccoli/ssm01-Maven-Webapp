package com.cn.hnust.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.DBRService;

@Service("DBRService")
public class DBRServiceImpl implements DBRService {

	@Resource
	private UserMapper mapper;
	
	@Override
	public List<User> getInfo() {
		// TODO Auto-generated method stub
		List<User> users = this.mapper.selectAllUser();
		Iterator<User> iterator = users.iterator();
		List<String[]> infos = new ArrayList<String[]>();
		while(iterator.hasNext()){
			User user = iterator.next();
			String[] info = user.getFavorite().split(",");
			infos.add(info);
		}
		String[] a,b;
		List<String> favorites =new ArrayList<String>();
		for (int m = 0; m < infos.size(); m++) {
			for (int n = m+1; n < infos.size(); n++) {
				a = infos.get(m);
				b = infos.get(n);
				for (int i = 0; i < b.length; i++){
					   for (int j = 0; j < a.length; j++){
					      if (a[j].equals(b[i])){
					    	  favorites.add(a[j]);
					          }
					    }
					 }
				double similary = (double)favorites.size()/((double)a.length+(double)b.length-(double)favorites.size());
				favorites.clear();
				System.out.println("final:"+similary);
			}
		}
		return null;
	}

	/**
	 * 用户注册或者登陆的时候推荐以相似的用户
	 */
	@Override
	public List<User> getinfow(User newuser) {
		// TODO Auto-generated method stub
		String[] favorites = newuser.getFavorite().split(","); //new user's favorites
		Date age = newuser.getBirth();	//new user's birth
		String sex = newuser.getSex();
		List<User> users = this.mapper.selectAllUser();     //all user
		Iterator<User> iterator = users.iterator();
		Iterator<User> iterator2 = users.iterator();
		Iterator<User> iterator3 = users.iterator();
		List<String> samefavorites =new ArrayList<String>();  //save same favorites
		String[] a; 		//one user's favorites
		Date userAge;		//one user's age
		String userSex;		//one user's sex
		List<Double> favoritesSimilarity = new ArrayList<Double>();	//favorites similarity between users
		List<Double> sexSimilarity = new ArrayList<Double>();	//sex similarity between users
		List<Double> ageSimilarity = new ArrayList<Double>();	//age similarity between users
		List<Double> finals  =new ArrayList<Double>();			//final theory
		while(iterator.hasNext()){
			User user = iterator.next();
			a = user.getFavorite().split(",");
			for (int i = 0; i < favorites.length; i++){
				   for (int j = 0; j < a.length; j++){
				      if (a[j].equals(favorites[i])){
				    	  samefavorites.add(a[j]);
				          }
				    }
				 }
			double similary = (double)samefavorites.size()/((double)a.length+(double)favorites.length-(double)samefavorites.size());
			samefavorites.clear();
			favoritesSimilarity.add(similary);
		}
		while(iterator2.hasNext()){
			User user = iterator2.next();
			userAge = user.getBirth();
			if(Math.abs(age.getYear()-userAge.getYear()-1900)>=10){
				ageSimilarity.add(0d);
			}else{
				ageSimilarity.add((Math.abs(Math.abs(age.getYear()-userAge.getYear()-1900)-10d)/10d));
			}
		}
		while(iterator3.hasNext()){
			User user = iterator3.next();
			userSex = user.getSex();
			if(userSex.equals(sex)){
				sexSimilarity.add(1d);
			}else{
				sexSimilarity.add(0.5d);
			}
		}
		System.out.println(favoritesSimilarity.toString());
		System.out.println(sexSimilarity.toString());
		System.out.println(ageSimilarity.toString());
		for (int i = 0; i < favoritesSimilarity.size(); i++) {
			finals.add(favoritesSimilarity.get(i)*0.4+sexSimilarity.get(i)*0.3+ageSimilarity.get(i)*0.3);
		}
		System.out.println(finals.toString());
		return null;
	}
}
