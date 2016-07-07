package com.news.cache;
/**
 * 这个类处于对性能优化的考虑。前五百的新闻的简介都在这个类中缓存。并且每隔5分钟进行刷新
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
	 * 这个对象缓存了前五百个对象
	 */
	private static List<News>lists;
	private static Timer timer;
	/**
	 * 缓存更新是否正在进行。如果正在进行的话不允许进行对于lists进行操作。否则会异常
	 */
	public  static boolean isRunning=false;
	private static NewsDaoProxy proxy;
	/**
	 * 缓存的最大数量
	 */
	private static final int MAXCOUNT=500;
	/**
	 * 刷新缓存
	 */
	public static synchronized void refresh(){
		System.out.println("正在进行缓存更新");
		isRunning=true;
		lists=proxy.findListByNumber(0, MAXCOUNT);
		isRunning=false;
		System.out.println("缓存更新成功");
	}
	/**
	 * 开始
	 */
	public static synchronized void start(){
		timer=new Timer();
		proxy=new NewsDaoProxy();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("正在进行缓存更新");
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
			System.out.println("因为正在运行，返回dao返回的");
			return proxy.findListByNumber(start, count);
		}
		else
		{
			System.out.println(lists+"\n"+"start:"+start+"\n"+"count:"+count);
			System.out.println("正在进行读取list");
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
