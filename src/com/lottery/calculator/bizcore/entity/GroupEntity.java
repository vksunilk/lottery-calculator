package com.lottery.calculator.bizcore.entity;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupEntity {

	private UUID groupUUID;

	private String groupName;

	private Timestamp updatedDateTime;

	@Override
	public String toString() {
		return groupName;
	}
}
