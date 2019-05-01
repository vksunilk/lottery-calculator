package com.lottery.calculator.biz.group;

import java.sql.SQLException;
import java.util.List;

import com.lottery.calculator.bizcore.dao.GroupDao;
import com.lottery.calculator.bizcore.entity.GroupEntity;

public class GroupService {

	private GroupDao dao;

	public GroupService() {
		dao = new GroupDao();
	}

	public boolean addGroups(String groupName) throws SQLException, InstantiationException, IllegalAccessException {
		return dao.addGroup(groupName);
	}

	public List<GroupEntity> getGroups() throws InstantiationException, IllegalAccessException, SQLException {
		return dao.getGroups();
	}

}
