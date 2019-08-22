package com.juma.vms.tool.service.impl;

import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import com.juma.auth.employee.domain.LoginEmployee;
import com.juma.auth.tenant.domain.Tenant;
import com.juma.auth.tenant.service.TenantService;
import com.juma.auth.user.domain.LoginUser;
import com.juma.server.vm.common.LicenseImgTypeEnum;
import com.juma.server.vm.domain.LicenseImg;
import com.juma.server.vm.domain.Vehicle;
import com.juma.server.vm.domain.bo.TenantVehicleBo;
import com.juma.server.vm.domain.dto.VehicleQueryConditionDTO;
import com.juma.server.vm.domain1.VehicleExtraFunction;
import com.juma.server.vm.domain1.bo.VehicleBo;
import com.juma.server.vm.domain1.bo.VehicleOwnerDeptBo;
import com.juma.server.vm.domain1.vo.VehicleVO;
import com.juma.server.vm.service.vehicle.AmsService;
import com.juma.server.vm.service.vehicle.AmsServiceV2;
import com.juma.vms.tool.service.AmsCommonService;
import com.juma.vms.vendor.vo.QueryVehicleVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AmsCommonServiceImpl implements AmsCommonService {

    private Logger log = LoggerFactory.getLogger(AmsCommonServiceImpl.class);

    @Resource
    private AmsService amsService;
    @Resource
    private AmsServiceV2 amsServiceV2;
    @Resource
    private TenantService tenantService;

    @Override
    public VehicleBo findByPlateNumber(String plateNumber, Integer tenantId, String tenantCode)
            throws BusinessException {
        if (StringUtils.isBlank(plateNumber) || null == tenantId) {
            return null;
        }

        if (StringUtils.isBlank(tenantCode)) {
            Tenant tenant = tenantService.loadTenant(tenantId);
            if (null == tenant) {
                return null;
            }

            tenantCode = tenant.getTenantCode();
        }

        VehicleQueryConditionDTO dto = new VehicleQueryConditionDTO();
        dto.setPlateNumber(plateNumber);
        dto.setTenantId(tenantId);
        dto.setTenantCode(tenantCode);

        try {
            return amsServiceV2.getByPlateNumber(dto);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            log.warn("amsServiceError->findByPlateNumber:{}", e.getMessage());
            throw new BusinessException("amsServiceError", "errors.amsServiceError");
        }
    }

    @Override
    public VehicleBo findByVehicleId(Integer vehicleId, Integer tenantId, String tenantCode) throws BusinessException {
        if (null == vehicleId || null == tenantId || StringUtils.isBlank(tenantCode)) {
            return null;
        }

        VehicleQueryConditionDTO dto = new VehicleQueryConditionDTO();
        dto.setVehicleId(vehicleId);
        dto.setTenantId(tenantId);
        dto.setTenantCode(tenantCode);

        try {
            return amsServiceV2.getVehicleById(dto);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            log.warn("amsServiceError->findByVehicleId:{}", e.getMessage());
            throw new BusinessException("amsServiceError", "errors.amsServiceError");
        }
    }

    @Override
    public List<QueryVehicleVo> listByPlateNumber(String plateNumber, LoginUser loginUser) throws BusinessException {
        List<QueryVehicleVo> result = new ArrayList<QueryVehicleVo>();
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("plateNumber", plateNumber);
        paramsMap.put("tenantId", loginUser.getTenantId());
        List<VehicleVO> list = null;
        try {
            list = amsServiceV2.listByPlateNumber(paramsMap);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }

            log.warn("amsServiceError->listByPlateNumber:{}", e.getMessage());
            throw new BusinessException("amsServiceError", "errors.amsServiceError");
        }

        if (CollectionUtils.isEmpty(list)) {
            return result;
        }

        for (VehicleVO vo : list) {
            QueryVehicleVo q = new QueryVehicleVo();
            q.setVehicleId(vo.getVehicleId());
            q.setPlateNumber(vo.getPlateNumber());
            q.setVehicleFrameNo(vo.getVehicleFrameNo());
            result.add(q);
        }
        return result;
    }

    @Override
    public void changeCompany2Ams(TenantVehicleBo tenantVehicleBo) throws BusinessException {
        try {
            amsServiceV2.updateVehicleUseRight(tenantVehicleBo);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                throw e;
            }
            throw new BusinessException("amsServiceError", "errors.amsServiceError");
        }
    }

    @Override
    public VehicleBo getVehicleBoById(VehicleQueryConditionDTO vehicleQueryConditionDTO) throws BusinessException{
        return amsServiceV2.getVehicleBoById(vehicleQueryConditionDTO);
    }

    @Override
    public Vehicle getByVehicleFrameNo(String vehicleFrameNo) throws BusinessException{
        return amsService.getByVehicleFrameNo(vehicleFrameNo);
    }

    @Override
    public List<VehicleBo> getVehicleListByPlateNo(List<String> plateNoList) throws BusinessException{
        return amsServiceV2.getVehicleListByPlateNo(plateNoList);
    }

    @Override
    public VehicleBo getByVehicleId(Integer vehicleId, LoginEmployee loginEmployee) throws BusinessException{
        return amsServiceV2.getByVehicleId(vehicleId,loginEmployee);
    }

    @Override
    public VehicleExtraFunction getByVehicleIdFunctionId(VehicleQueryConditionDTO vehicleQueryConditionDTO) throws BusinessException{
        return amsServiceV2.getByVehicleIdFunctionId(vehicleQueryConditionDTO);
    }

    @Override
    public LicenseImg getLicenseImgByVehicleIdAndType(Integer vehicleId, LicenseImgTypeEnum licenseImgTypeEnum) throws BusinessException{
        return amsServiceV2.getLicenseImgByVehicleIdAndType(vehicleId,licenseImgTypeEnum);
    }

    @Override
    public Page<VehicleBo> queryVehicleBoForInner(PageCondition pageCondition, LoginEmployee loginEmployee) throws BusinessException{
        return amsServiceV2.queryVehicleBoForInner(pageCondition,loginEmployee);
    }

    @Override
    public VehicleOwnerDeptBo getOwnVehicleBOByVehicleFrameNo(String vehicleFrameNo) throws BusinessException{
        return amsServiceV2.getOwnVehicleBOByVehicleFrameNo(vehicleFrameNo);
    }

    @Override
    public List<VehicleBo> getVehicleBoListById(Integer vehicleId) throws BusinessException {
        return amsServiceV2.getVehicleBoListById(vehicleId);
    }
}
