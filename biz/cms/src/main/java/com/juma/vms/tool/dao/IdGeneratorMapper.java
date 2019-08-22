package com.juma.vms.tool.dao;

public interface IdGeneratorMapper {

    Integer genId(String tableName);
    
    Integer excuteSQL(String sql);

}
