package com.tot.query;

import java.util.List;

public class OrderBy {

    private List<OrderItem> by;


    public static class OrderItem{
        private String colName;
        private OrderType type =  OrderType.ASC;

        public String getColName() {
            return colName;
        }

        public void setColName(String colName) {
            this.colName = colName;
        }

        public OrderType getType() {
            return type;
        }

        public void setType(OrderType type) {
            this.type = type;
        }
    }

    public enum OrderType {
        /**
         * 正序
         */
        ASC,
        /**
         * 逆序
         */
        DESC
    }

    public List<OrderItem> getBy() {
        return by;
    }

    public void setBy(List<OrderItem> by) {
        this.by = by;
    }
}
