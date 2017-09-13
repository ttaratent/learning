package com.demo.column;

import com.demo.common.model.Columns;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogValidator.
 */
public class ColumnValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("columns.name", "titleMsg", "请输入栏目名称!");
//		validateRequiredString("column.content", "contentMsg", "请输入栏目内容!");
	}
	
	protected void handleError(Controller controller) {
		controller.keepModel(Columns.class);
		
		String actionKey = getActionKey();
		if (actionKey.equals("/column/save"))
			controller.render("add.html");
		else if (actionKey.equals("/column/update"))
			controller.render("edit.html");
	}
}
