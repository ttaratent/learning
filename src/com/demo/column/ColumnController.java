package com.demo.column;

import com.demo.common.model.Columns;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(ColumnInterceptor.class)
public class ColumnController extends Controller {
	
	static ColumnService service = new ColumnService();
	
	public void index() {
		setAttr("columnPage", service.paginate(getParaToInt(0, 1), 10));
		render("column.html");
	}
	
	public void add() {
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(ColumnValidator.class)
	public void save() {
		getModel(Columns.class).save();
		redirect("/column");
	}
	
	public void edit() {
		setAttr("column", service.findById(getParaToInt()));
	}
	
	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
	 * 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(ColumnValidator.class)
	public void update() {
		getModel(Columns.class).update();
		redirect("/column");
	}
	
	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/column");
	}
}


