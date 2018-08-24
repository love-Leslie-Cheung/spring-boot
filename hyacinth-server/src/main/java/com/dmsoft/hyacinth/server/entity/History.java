/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "t_history")
public class History {

    @Id
    private Long id;
    private String operator_code;
    private String operation_target;
    private String operation_type;
    private Date operating_time;
    private String operate_result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator_code() {
        return operator_code;
    }

    public void setOperator_code(String operator_code) {
        this.operator_code = operator_code;
    }

    public String getOperation_target() {
        return operation_target;
    }

    public void setOperation_target(String operation_target) {
        this.operation_target = operation_target;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public Date getOperating_time() {
        return operating_time;
    }

    public void setOperating_time(Date operating_time) {
        this.operating_time = operating_time;
    }

    public String getOperate_result() {
        return operate_result;
    }

    public void setOperate_result(String operate_result) {
        this.operate_result = operate_result;
    }
}
