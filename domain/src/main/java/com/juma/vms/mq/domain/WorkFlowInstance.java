/**
 * 
 */
package com.juma.vms.mq.domain;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 工作流流程实例
 */
@Data
@Builder
public class WorkFlowInstance implements Serializable {

	/**工作流信息说明,方便日志查看**/
	private String workflowDesc;
	/**每一个工作流唯一的Key**/
	private String processDefinitionKey;
	/**实例id**/
	private String processInstanceId;
	/**工作流对应的业务数据唯一标识:比如订单ID,运单ID等**/
	private String businessKey;
	/**业务编码:比如订单编号**/
	private String number;
	/**工作流其他业务相关变量**/
	@Builder.Default
	private Map<String, Object> variables = Maps.newHashMap();

	/**工作流撤销原因:预留,不一定使用**/
	private String revokeReason;

	/**流程类型 重新申请:REAPPLY_OK 放弃申请:REAPPLY_DIS**/
	private String approvalKey;

	/**兼容运力输送放弃申请**/
	private String transportId;
}
