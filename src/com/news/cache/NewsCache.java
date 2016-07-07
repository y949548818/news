package com.news.cache;
/**
 * ����ദ�ڶ������Ż��Ŀ��ǡ�ǰ��ٵ����ŵļ�鶼��������л��档����ÿ��5���ӽ���ˢ��
 * @author asus
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.news.dao.proxy.NewsDaoProxy;
import com.news.entity.News;
public class NewsCache {
	/**
	 * ������󻺴���ǰ��ٸ�����
	 */
	private static List<News>lists;
	private static Timer timer;
	/**
	 * ��������Ƿ����ڽ��С�������ڽ��еĻ���������ж���lists���в�����������쳣
	 */
	public  static boolean isRunning=false;
	private static NewsDaoProxy proxy;
	/**
	 * ������������
	 */
	private static final int MAXCOUNT=500;
	/**
	 * ˢ�»���
	 */
	public static synchronized void refresh(){
		System.out.println("���ڽ��л������");
		isRunning=true;
		lists=proxy.findListByNumber(0, MAXCOUNT);
		isRunning=false;
		System.out.println("������³ɹ�");
	}
	/**
	 * ��ʼ
	 */
	public static synchronized void start(){
		timer=new Timer();
		proxy=new NewsDaoProxy();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("���ڽ��л������");
				isRunning=true;
				lists=proxy.findListByNumber(0, MAXCOUNT);
				isRunning=false;
			}
		}, 0,1000*60*10);
	}
	public static List<News> getLists(int start,int count) {
		List<News>lists2=null;
		if(isRunning&&lists.size()!=0)
		{
			System.out.println("��Ϊ�������У�����dao���ص�");
			return proxy.findListByNumber(start, count);
		}
		else
		{
			System.out.println(lists+"\n"+"start:"+start+"\n"+"count:"+count);
			System.out.println("���ڽ��ж�ȡlist");
			lists2=new ArrayList<News>();
			for(int i=start;i<start+count&&i<lists.size();i++)
			{
				lists2.add(lists.get(i));
			}
		}
		return lists2;
	}
	public static void setLists(List<News> lists) {
		NewsCache.lists = lists;
	}
	
}
