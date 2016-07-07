package com.news.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewsCategoryImp;
import com.news.dao.impl.NewsCategoryImpl;
import com.news.entity.NewsCategoryEnt;
import com.news.utils.Utils;

public class NewsCategoryPro implements NewsCategoryImp{
	
	private NewsCategoryImpl nci;
	
	public NewsCategoryPro(){
		this.nci=new NewsCategoryImpl(Utils.getConnection());
	}
	@Override
	public int addCategory(String category) {
		// TODO Auto-generated method stub
		int num=nci.addCategory(category);
		if(num==1){
			System.out.println("插入成功");
			return num;
		}else
			return 0;
		
	}

	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		int num=nci.deleteCategory(id);
		if(num==1){
			System.out.println("删除成功");
			return num;
		}else
			return 0;
	}

	@Override
	public int updateCategory(int id,String category) {
		// TODO Auto-generated method stub
		int num=nci.updateCategory(id,category);
		if(num!=0){
			System.out.println("更新成功");
			return num;
		}else
			return 0;
	}
	
	@Override
	public NewsCategoryEnt findById(int id){
		NewsCategoryEnt nce=null;
		return nce;
	}
	@Override
	public List<NewsCategoryEnt> findAll() {
		// TODO Auto-generated method stub
		return nci.findAll();
	}

}
