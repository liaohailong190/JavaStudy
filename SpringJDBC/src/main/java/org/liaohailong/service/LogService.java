package org.liaohailong.service;

import org.liaohailong.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

	@Autowired
	private LogDao logDao;
	
	public void add() {
		logDao.add("LogService", "≤Â»Î»’÷æ£°£°");
	}
}
