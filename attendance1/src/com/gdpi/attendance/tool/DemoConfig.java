package com.gdpi.attendance.tool;

import com.gdpi.attendance.dao.StudentDao;
import com.gdpi.attendance.webiter.StudentServlet;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configPlugin(Plugins me) {
		DruidPlugin db = new DruidPlugin(
				"jdbc:mysql://Localhost:3306/attendance_sys?useUnicode=true&characterEncoding=UTF-8",
				"root", "root");
		me.add(db);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(db);
		arp.setShowSql(true);
		me.add(arp);

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/student", StudentDao.class);
	}

	@Override
	public void configHandler(Handlers me) {

	}

	@Override
	public void configInterceptor(Interceptors me) {

	}

}
