package com.demo.news;

import com.demo.common.model.News;
import com.jfinal.plugin.activerecord.Page;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogService
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
public class NewsService {
	
	/**
	 * 所有的 dao 对象也放在 Service 中
	 */
	private static final News dao = new News().dao();
	
	public Page<News> paginate(int pageNumber, int pageSize, int col) {
	    //根据是否有栏目id来决定是否分栏目显示新闻
	    String sql;
	    if (col != 0) {
	        sql = "from news where col = " + col + " order by id asc";
	    } else {
	        sql = "from news order by id asc";
	    }
		return dao.paginate(pageNumber, pageSize, "select *", sql);
	}
	
	public News findById(int id) {
		return dao.findById(id);
	}
	
	public void deleteById(int id) {
		dao.deleteById(id);
	}
}
