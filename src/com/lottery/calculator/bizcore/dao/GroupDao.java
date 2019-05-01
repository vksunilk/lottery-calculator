package com.lottery.calculator.bizcore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lottery.calculator.bizcore.database.DatabaseManager;
import com.lottery.calculator.bizcore.entity.GroupEntity;

public class GroupDao {

	private static final String INSERT_QUERY = "Insert into GROUPS " + "(GROUP_UUID,GROUP_NAME, UPDATED_DATE_TIME) "
			+ "VALUES(?,?, CURRENT_TIMESTAMP)";
	private DatabaseManager db;

	public GroupDao() {
		db = new DatabaseManager();
	}

	public boolean addGroup(String groupName) throws SQLException, InstantiationException, IllegalAccessException {
		Connection conn = db.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QUERY);
		preparedStatement.setString(1, UUID.randomUUID().toString());
		preparedStatement.setString(2, groupName);
		return preparedStatement.executeUpdate() == 1;
	}

	public List<GroupEntity> getGroups() throws InstantiationException, IllegalAccessException, SQLException {
		List<GroupEntity> entityList = new ArrayList<>();
		Connection conn = db.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT * from GROUPS");
		while (resultset.next()) {
			GroupEntity entity = new GroupEntity();
			entity.setGroupUUID(UUID.fromString(resultset.getString("GROUP_UUID")));
			entity.setGroupName(resultset.getString("GROUP_NAME"));
			entity.setUpdatedDateTime(resultset.getTimestamp("UPDATED_DATE_TIME"));
			entityList.add(entity);
		}
		conn.close();
		return entityList;
	}
}
