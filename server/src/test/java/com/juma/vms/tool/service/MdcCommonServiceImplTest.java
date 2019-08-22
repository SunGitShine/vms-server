package com.juma.vms.tool.service;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.juma.auth.conf.domain.BusinessArea;
import com.juma.auth.employee.domain.Department;
import com.juma.auth.employee.domain.LoginEmployee;
import org.testng.annotations.Test;

import com.juma.auth.user.domain.LoginUser;
import com.juma.vms.vendor.domain.Vendor;
import com.juma.vms.vendor.service.VendorService;
import com.juma.vms.vendor.vo.VendorIdentification;

import testng.BaseTestNGTest;

import java.util.List;

public class MdcCommonServiceImplTest extends BaseTestNGTest {

    @Resource
    private MdcCommonService mdcCommonService;
    @Resource
    private VendorService vendorService;
    @Resource
    private BusinessAreaCommonService businessAreaCommonService;
    @Resource
    private AuthCommonService authCommonService;

    @Test
    public void add1 () {
        Vendor vendor = new Vendor();
        vendor.setVendorId(16442);
        vendor.setVendorName("江素兰");
        vendor.setVendorType((byte) 1);
        vendor.setIdCardNo("320625196902047687");
        VendorIdentification vendorIdentification = new VendorIdentification(vendor);

        String s = mdcCommonService.addVendorToMdata(vendorIdentification, new LoginUser(9, 1));

        System.out.println(s);
    }

    @Test
    public void add() throws Exception {
        //vendorService.getVendor(2);

        // mdcCommonService.addVendorToMdata(vendorService.getVendor(2), new LoginUser(9, 1));

        /*LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1);

        List<Certification> rows = XlsxReader.fromInputStream(new FileInputStream("E:/承运商明细汇总（4-2） 15884条.xlsx"),
                Certification.class, 1);

        for (Certification idCard : rows) {
            loginUser.setTenantId(idCard.getTenantId());
            VendorIdentification vendorIdentification = new VendorIdentification();
            vendorIdentification.setIdCardNo(idCard.getIdCardNo());
            vendorIdentification.setEnterpriseCode(idCard.getIdCardNo());
            vendorIdentification.setVendorId(idCard.getVendorId());
            if (StringUtils.isBlank(idCard.getVendorType())) continue;
            String vendorType = idCard.getVendorType().trim();
            vendorIdentification.setVendorType(
                    vendorType.equals("个人") ? 1 : (vendorType.equals("车队") ? 2 : (vendorType.equals("公司") ? 3 : 0)));
            vendorIdentification.setVendorName(idCard.getVendorName());
            String jumaPin = null;
            try {
                jumaPin = mdcCommonService.addVendorToMdata(vendorIdentification, loginUser);
            } catch (Exception e) {
                jumaPin = "认证不通过："+e.getMessage();
            }
            idCard.setResult(jumaPin);
        }

        FileOutputStream out = new FileOutputStream("E:/承运商验证结果.xlsx");
        new XssfWriter().appendToSheet("承运商验证结果", rows).writeToOutputStream(out);
*/
//        mdcCommonService.addVendorToMdata(vendorService.getVendor(2), new LoginUser(9, 1));
    }

    @Test
    public void listChild() {
        List<BusinessArea> businessAreas = businessAreaCommonService.listChildBusinessArea(0, new LoginUser(19, 1));
        System.out.println(JSON.toJSONString(businessAreas));
    }

    @Test
    public void listChilDepartment() {
        LoginEmployee loginEmployee = new LoginEmployee();
        loginEmployee.setTenantId(19);
        loginEmployee.setUserId(1);
        List<Department> list = authCommonService.listChildDepartment(0, loginEmployee);

        System.out.println(JSON.toJSONString(list));
    }
}
