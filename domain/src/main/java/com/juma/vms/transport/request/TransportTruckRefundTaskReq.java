package com.juma.vms.transport.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-26 14:17
 **/
@ApiModel("退车任务参数")
public class TransportTruckRefundTaskReq implements Serializable{

	@ApiModelProperty("运力退回单ID")
	private Integer refundId;

	@ApiModelProperty("任务ID")
	private String taskId;

	@ApiModelProperty("审批Key")
	private String approvalKey;

	@ApiModelProperty("审批意见")
	private String comment;

	public Integer getRefundId() {
		return refundId;
	}

	public void setRefundId(Integer refundId) {
		this.refundId = refundId;
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
