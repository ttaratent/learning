package com.demo.news;

import com.demo.common.model.News;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogValidator.
 */
public class NewsValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("news.col", "columnMsg", "请输入新闻栏目!");
		validateRequiredString("news.title", "titleMsg", "请输入新闻标题!");
//		validateRequiredString("news.content", "contentMsg", "请输入新闻内容!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(News.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/news/save"))
			controller.render("add.html");
		else if (actionKey.equals("/news/update"))
			controller.render("edit.html");
	}
}
