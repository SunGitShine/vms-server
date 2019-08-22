package com.juma.vms.common.id;

public class IdGeneratorTable {

    /**
     * 
     * 业务标识+时间(yyyyMMddHHmmss)+随机
     *
     */
    
    public enum  IdType {
        
        SS("transport_capacity","输送单编号"),
        TC("transport_truck_refund","运力退回单编号")
        ;

        private String tableName;
        
        private String descr;
        
        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getDescr() {
            return descr;
        }

        public void setDescr(String descr) {
            this.descr = descr;
        }

        private IdType(String tableName,String descr) {
            this.tableName = tableName;
            this.descr = descr;
        }
        
    } 
}
