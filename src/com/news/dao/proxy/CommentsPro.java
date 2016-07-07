package com.news.dao.proxy;

import java.util.List;

import com.news.dao.CommentsInt;
import com.news.dao.impl.CommentsImpl;
import com.news.entity.CommentsEnt;
import com.news.utils.Utils;

public class CommentsPro implements CommentsInt{

	private CommentsImpl cimp;
	public CommentsPro() {
		// TODO Auto-generated constructor stub
		cimp=new CommentsImpl(Utils.getConnection());
	}
	@Override
	public List<CommentsEnt> selectComm(int news_id) {
		// TODO Auto-generated method stub
		return cimp.selectComm(news_id);
	}

	@Override
	public int deleteComm(CommentsEnt ent) {
		// TODO Auto-generated method stub
		if(cimp.deleteComm(ent)==1){
			System.out.println("ɾ���ɹ�");
			return 1;
		}else{
			System.out.println("ɾ��ʧ��");
			return 0;
		}
	}

	@Override
	public int insertComm(CommentsEnt ent) {
		// TODO Auto-generated method stub
		
		if(cimp.insertComm(ent)==1){
			System.out.println("����ɹ�");
			return 1;
		}else{
			System.out.println("��������");
			return 0;
		}
	}

	@Override
	public CommentsEnt findById(int id) {
		// TODO Auto-generated method stub
		return cimp.findById(id);
	}

}
