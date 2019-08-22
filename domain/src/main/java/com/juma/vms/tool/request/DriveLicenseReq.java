package com.juma.vms.tool.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 10:58 2019-03-29
 */
@ApiModel
public class DriveLicenseReq implements Serializable {
    @ApiModelProperty(value = "图片地址")
    private String imageUrl;
    @ApiModelProperty(value = "正反面标识(正面:face,反面:back)")
    private String faceback;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFaceback() {
        return faceback;
    }

    public void setFaceback(String faceback) {
        this.faceback = faceback;
    }
}
