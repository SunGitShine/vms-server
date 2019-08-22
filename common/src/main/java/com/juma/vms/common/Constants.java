package com.juma.vms.common;

public class Constants {

    public static final String SYSTEM_NAME = "VMS";

    public static final String AUTH_KEY_VMS_MANAGE = "VMS_MANAGE";

    public static final String AUTH_KEY_TGM_DRIVER = "TGM_DRIVER";

    public static final String ROLE_KEY_VENDOR = "LESSEE";

    public static final String ROLE_KEY_DRIVER = "DRIVER";
    // 后台代码
    public static final Byte SYSTEM_TYPE = 1;

    /** SCM:厢型KEY */
    public static final String SCM_BOX_LEVEL = "boxLevel";
    /** SCM:车厢长度KEY */
    public static final String SCM_BOX_TYPE = "boxType";
    
    public static final String DEFAULT_AREA_CODE = "00";

    /** SCM:牌照类型 */
    public static final String LINCENCE_PLATE_TYPE = "pzlx31";
    /** SCM:能耗类型 */
    public static final String ENERGY_TYPE = "energyType";
    /** SCM:能耗排放 */
    public static final String EMISSION_STANDARD = "emissionStandard";

    public static final String MESSAGE_AUTHENTICATION_CODE  = "VMS_MESSAGE_AUTHENTICATION_CODE";
    public static final String MESSAGE_DRIVER_PAST_PHONE  = "VMS_MESSAGE_DRIVER_PAST_PHONE";
    public static final String MESSAGE_DRIVER_NEW_PHONE  = "VMS_MESSAGE_DRIVER_NEW_PHONE";
    public static final String MESSAGE_DRIVER_CREATE  = "VMS_MESSAGE_DRIVER_CREATE";
    public static final String MESSAGE_DRIVER_CHANGE_VENDOR  = "VMS_MESSAGE_DRIVER_CHANGE_VENDOR";
    public static final String MESSAGE_TRUCK_CHANGE_VENDOR_PAST_PHONE  = "VMS_MESSAGE_TRUCK_CHANGE_VENDOR_PAST_PHONE";
    public static final String MESSAGE_TRUCK_CHANGE_VENDOR_NEW_PHONE  = "VMS_MESSAGE_TRUCK_CHANGE_VENDOR_NEW_PHONE";
    public static final String MESSAGE_TRUCK_CHANGE_DRIVER_PAST_PHONE  = "VMS_MESSAGE_TRUCK_CHANGE_DRIVER_PAST_PHONE";
    public static final String MESSAGE_TRUCK_CHANGE_DRIVER_NEW_PHONE  = "VMS_MESSAGE_TRUCK_CHANGE_DRIVER_NEW_PHONE";
    public static final String MESSAGE_COMPLETE_TRANSPORT_VENDOR  = "VMS_COMPLETE_TRANSPORT_VENDOR";
    public static final String MESSAGE_COMPLETE_TRANSPORT_DRIVER  = "VMS_COMPLETE_TRANSPORT_DRIVER";


    /** 准驾车型 */
    public static final String CRM_DRIVERS_LICENSE_TYPE  = "CRM_DRIVERS_LICENSE_TYPE";

    /**工作流发起重新申请,放弃申请KEY 工作流项目定义**/
    public static final String WORK_FLOW_EXTERNAL_NEXT_EVENT_BUS_KEY = "WorkflowExternalNextEventBusKey";
    /** 卡车退库之后,SCM入库单通过消息告知 **/
    public static final String EVENT_NAME_SCM_TO_VMS_RETURN_STORAGE_NO = "transport_truck_refund";
    /** 输送运力 **/
    public static final String EVENT_NAME_TRANSPORT_SEND = "transport_send";

}
