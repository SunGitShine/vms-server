package com.juma.vms.transport.domain;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-27 16:01
 **/
public class TransportCapacityEnum implements Serializable{

	// 审核状态
	public enum AuditStatus {

		Append(0,"UNSUBMIT","未提交"),
		SUBMIT(1,"AUDITING","审核中"),
		REJECT(2,"REJECT","被驳回"),
		AGREE(3,"AUDITED","已通过"),
		REVOKE(4,"REVOKE","已撤销"),
		CANCEL(5,"CANCEL","已放弃"),
		PROCESS(6,"PROCESS","处理中");

		private int code;
		private String workFlowKey;
		private String descr;

		private AuditStatus(int code, String workFlowKey, String descr) {
			this.code = code;
			this.workFlowKey = workFlowKey;
			this.descr = descr;
		}

		public int getCode() {
			return code;
		}

		public String getWorkFlowKey() {
			return workFlowKey;
		}
		public String getDescr() {
			return descr;
		}

		public static String getdescByCode(Integer code) {
			if (null == code) {
				return null;
			}

			for (AuditStatus a : AuditStatus.values()) {
				if (a.getCode() == code) {
					return a.getDescr();
				}
			}

			return null;
		}

		public static Integer getCodeByWorkFlowKey(String workFlowKey) {
			if (StringUtils.isBlank(workFlowKey)) {
				return null;
			}

			for (AuditStatus a : AuditStatus.values()) {
				if (a.getWorkFlowKey().equals(workFlowKey)) {
					return a.getCode();
				}
			}

			return null;
		}
	}
}
