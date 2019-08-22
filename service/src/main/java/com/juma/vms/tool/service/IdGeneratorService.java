package com.juma.vms.tool.service;

import com.juma.vms.common.id.IdGeneratorTable;

public interface IdGeneratorService {

    String genId(IdGeneratorTable.IdType idType);
    
    String genTransportSendNo(IdGeneratorTable.IdType idType);
    
    Integer excuteSQL(String sql);
    
}
