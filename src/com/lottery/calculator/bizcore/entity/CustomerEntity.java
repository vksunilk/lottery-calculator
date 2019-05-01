package com.lottery.calculator.bizcore.entity;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CustomerEntity {

	private UUID customerUUID;

	private UUID groupUUID;

	private String customerName;

	private String phoneNumber;

	private String emailAddress;

	private String place;

	private Timestamp updatedDateTime;

}
