package com.juma.vms.transport.external;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-06-20 10:49
 **/
public class TruckReturn implements Serializable{

	//车架号
	private String uniqueCode;
	//退回单号
	private String sourceNo;
	//单据类型
	private String transactionType = "TRANSPORT_IN";
	//退回id
	private Integer sourceId;

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public String getSourceNo() {
		return sourceNo;
	}

	public void setSourceNo(String sourceNo) {
		this.sourceNo = sourceNo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
}
