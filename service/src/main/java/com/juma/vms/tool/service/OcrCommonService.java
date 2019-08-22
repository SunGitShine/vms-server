package com.juma.vms.tool.service;

import com.giants.common.exception.BusinessException;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.vms.tool.domain.DriveLicenseInfo;
import com.juma.vms.tool.domain.IdentificationCardInfo;
import com.juma.vms.tool.request.DriveLicenseReq;
import com.juma.vms.tool.request.IdentificationReq;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 11:05 2019-03-27
 */
public interface OcrCommonService {

    /**
     * (OCR图像识别)根据身份证图片地址,获取身份证的内容(身份证正面)
     */
    DriveLicenseInfo ocrDriveLicenseInfo(DriveLicenseReq request, LoginEmployee loginUser) throws BusinessException;

    /**
     * (OCR图像识别)根据驾驶证图片地址,获取驾驶证的内容(驾驶证正面)
     */
    IdentificationCardInfo ocrIdentificationInfo(IdentificationReq request, LoginEmployee loginUser) throws BusinessException;
}
