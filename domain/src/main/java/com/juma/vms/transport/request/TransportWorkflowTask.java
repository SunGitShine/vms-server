package com.juma.vms.transport.request;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-26 14:17
 **/
public class TransportWorkflowTask implements Serializable{

	private Integer transportId;

	private String taskId;

	private String approvalKey;

	private String comment;

	public Integer getTransportId() {
		return transportId;
	}

	public void setTransportId(Integer transportId) {
		this.transportId = transportId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getApprovalKey() {
		return approvalKey;
	}

	public void setApprovalKey(String approvalKey) {
		this.approvalKey = approvalKey;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
