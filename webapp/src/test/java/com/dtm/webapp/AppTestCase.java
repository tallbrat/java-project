package com.dtm.webapp;

import panda.dao.Dao;
import com.dtm.webapp.tool.AppConsole;


public abstract class AppTestCase {
	protected Dao getDao() {
		return AppConsole.i().getDao();
	}
}
