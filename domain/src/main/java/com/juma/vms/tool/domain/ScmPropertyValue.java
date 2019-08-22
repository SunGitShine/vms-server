package com.juma.vms.tool.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @description: ${description}
 *
 * @author: xieqiang
 *
 * @create: 2019-03-20 13:44
 **/
public class ScmPropertyValue implements Serializable{

	private List<BaseEnumDomian> licenceTypePropertyValues;//牌照类型

	private List<BaseEnumDomian> energyTypePropertyValues;//能耗类型

	private List<BaseEnumDomian> emissionStandardPropertyValues;//排放标准

	public List<BaseEnumDomian> getLicenceTypePropertyValues() {
		return licenceTypePropertyValues;
	}

	public void setLicenceTypePropertyValues(List<BaseEnumDomian> licenceTypePropertyValues) {
		this.licenceTypePropertyValues = licenceTypePropertyValues;
	}

	public List<BaseEnumDomian> getEnergyTypePropertyValues() {
		return energyTypePropertyValues;
	}

	public void setEnergyTypePropertyValues(List<BaseEnumDomian> energyTypePropertyValues) {
		this.energyTypePropertyValues = energyTypePropertyValues;
	}

	public List<BaseEnumDomian> getEmissionStandardPropertyValues() {
		return emissionStandardPropertyValues;
	}

	public void setEmissionStandardPropertyValues(
		List<BaseEnumDomian> emissionStandardPropertyValues) {
		this.emissionStandardPropertyValues = emissionStandardPropertyValues;
	}
}
