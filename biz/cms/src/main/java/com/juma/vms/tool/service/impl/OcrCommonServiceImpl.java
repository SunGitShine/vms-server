package com.juma.vms.tool.service.impl;

import com.bruce.tool.rpc.http.core.Https;
import com.giants.common.exception.BusinessException;
import com.juma.auth.common.SystemAuthKey;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.thirdparty.aliyun.domain.DriveLicense;
import com.juma.thirdparty.aliyun.domain.IdentificationCard;
import com.juma.thirdparty.service.DriveLicenseService;
import com.juma.thirdparty.service.IdentificationCardOcrService;
import com.juma.vms.common.DateUtils;
import com.juma.vms.tool.domain.DriveLicenseInfo;
import com.juma.vms.tool.domain.IdentificationCardInfo;
import com.juma.vms.tool.request.DriveLicenseReq;
import com.juma.vms.tool.request.IdentificationReq;
import com.juma.vms.tool.service.OcrCommonService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 11:06 2019-03-27
 */
@Service
public class OcrCommonServiceImpl implements OcrCommonService {

    private static final Logger log = LoggerFactory.getLogger(OcrCommonServiceImpl.class);

    private final static int DUBBO_INTERFACE_PARAM_LIMIT = 8388608;

    @Resource
    private DriveLicenseService driveLicenseService;

    @Resource
    private IdentificationCardOcrService identificationCardOcrService;

    /**
     * (OCR图像识别)根据身份证图片地址,获取身份证的内容(身份证正面/反面)
     * faceback:face正面,back反面
     */
    @Override
    public DriveLicenseInfo ocrDriveLicenseInfo(DriveLicenseReq request, LoginEmployee loginUser) throws BusinessException {
        String url = validOcrParams(request.getImageUrl(), request.getFaceback());
        byte[] imageBytes = Https.create().url(url).download();
        if( null == imageBytes || imageBytes.length == 0 ){
            throw new BusinessException("imageDataNull","请上传正确的驾驶证照片");
        }

        String imgBase64 = Base64Utils.encodeToString(imageBytes);
        // dubbo接口数据大小限制1024 * 1024 * 8=8388608
        if( DUBBO_INTERFACE_PARAM_LIMIT < imgBase64.length() ){
            return new DriveLicenseInfo();
        }

        // 暂时硬编码,后续其他地方调用再考虑提取到common包中
        SystemAuthKey systemAuthKey = new SystemAuthKey();
        systemAuthKey.setAuthKey(loginUser.getLoginAuthKey());

        DriveLicense driveLicense;
        try {
            driveLicense = driveLicenseService.ocrDriveLicenseInfo(imgBase64,request.getFaceback(),loginUser,systemAuthKey);
        } catch (BusinessException e) {
            log.error("ocr系统识别异常:{}",e);
            throw new BusinessException("ocrIdentifyException","请上传正确的驾驶证照片");
        }
        if( null == driveLicense ){
            throw new BusinessException("ocrIdentifyNull","请上传正确的驾驶证照片");
        }

        DriveLicenseInfo driveLicenseInfo = new DriveLicenseInfo();
        BeanUtils.copyProperties(driveLicense,driveLicenseInfo);

        driveLicenseInfo.setArchiveNo(driveLicense.getArchive_no());
        driveLicenseInfo.setVehicleType(driveLicense.getVehicle_type());

        if( StringUtils.isNotBlank(driveLicense.getStart_date()) ){
            DateTime startDate = DateUtils.parse(driveLicense.getStart_date(),DateUtils.Parttern.FORMAT_YYMMDD_NON);
            driveLicenseInfo.setStartDate(DateUtils.format(startDate,DateUtils.Parttern.FORMAT_YYMMDD_MID));
        }

        if(StringUtils.isNotBlank(driveLicense.getEnd_date()) && driveLicense.getEnd_date().length() == 8){
            DateTime endDate = DateUtils.parse(driveLicense.getEnd_date(),DateUtils.Parttern.FORMAT_YYMMDD_NON);
            driveLicenseInfo.setEndDate(DateUtils.format(endDate,DateUtils.Parttern.FORMAT_YYMMDD_MID));
        }

        if( StringUtils.isNotBlank(driveLicense.getStart_date()) && StringUtils.isNotBlank(driveLicense.getEnd_date())
                && driveLicense.getEnd_date().length() < 8){
            String endPoint = driveLicense.getEnd_date();
            endPoint = endPoint.replace("年","");
            DateTime startDate = DateUtils.parse(driveLicense.getStart_date(),DateUtils.Parttern.FORMAT_YYMMDD_NON);
            if( null != startDate ){
                DateTime endDate = DateUtils.addMonths(startDate,Integer.parseInt(endPoint));
                driveLicenseInfo.setEndDate(DateUtils.format(endDate,DateUtils.Parttern.FORMAT_YYMMDD_MID));
            }
        }

        return driveLicenseInfo;
    }

    /**
     * (OCR图像识别)根据驾驶证图片地址,获取驾驶证的内容(驾驶证正面/反面)
     * faceback:face正面,back反面
     */
    @Override
    public IdentificationCardInfo ocrIdentificationInfo(IdentificationReq request, LoginEmployee loginUser) throws BusinessException{
        String url = validOcrParams(request.getImageUrl(), request.getFaceback());
        byte[] imageBytes = Https.create().url(url).download();
        if( null == imageBytes || imageBytes.length == 0 ){
            throw new BusinessException("imageDataNull","请上传正确的身份证照片");
        }
        String imgBase64 = Base64Utils.encodeToString(imageBytes);
        // dubbo接口数据大小限制1024 * 1024 * 8=8388608
        if( DUBBO_INTERFACE_PARAM_LIMIT < imgBase64.length() ){
            return new IdentificationCardInfo();
        }
        // 暂时硬编码,后续其他地方调用再考虑提取到common包中
        SystemAuthKey systemAuthKey = new SystemAuthKey();
        systemAuthKey.setAuthKey(loginUser.getLoginAuthKey());

        IdentificationCard identificationCard;
        try {
            identificationCard = identificationCardOcrService.ocrIdentificationInfo(imgBase64,request.getFaceback(),loginUser,systemAuthKey);
        } catch (BusinessException e) {
            log.error("ocr系统识别异常:{}",e);
            throw new BusinessException("ocrIdentifyException", "请上传正确的身份证照片");
        }
        if( null == identificationCard ){
            throw new BusinessException("ocrIdentifyNull", "请上传正确的身份证照片");
        }
        IdentificationCardInfo identificationCardInfo = new IdentificationCardInfo();
        BeanUtils.copyProperties(identificationCard,identificationCardInfo);

        if(StringUtils.isNotBlank(identificationCard.getStart_date())){
            DateTime startDate = DateUtils.parse(identificationCard.getStart_date(),DateUtils.Parttern.FORMAT_YYMMDD_NON);
            identificationCardInfo.setStartDate(DateUtils.format(startDate,DateUtils.Parttern.FORMAT_YYMMDD_MID));
        }

        if( StringUtils.isNotBlank(identificationCard.getEnd_date()) ){
            DateTime endDate = DateUtils.parse(identificationCard.getEnd_date(),DateUtils.Parttern.FORMAT_YYMMDD_NON);
            identificationCardInfo.setEndDate(DateUtils.format(endDate,DateUtils.Parttern.FORMAT_YYMMDD_MID));
        }

        return identificationCardInfo;
    }

    private String validOcrParams(String imageUrl, String faceback) {
        if (StringUtils.isBlank(imageUrl)) {
            throw new BusinessException("noImageUrl", "请上传正确的证件照片");
        }
        if (StringUtils.isBlank(faceback)) {
            throw new BusinessException("noImageUrl", "请上传正确的证件照片");
        }
        if (imageUrl.startsWith("//")) {
            imageUrl = "http:" + imageUrl;
        }
        return imageUrl;
    }

}
