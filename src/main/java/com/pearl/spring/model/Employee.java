package com.pearl.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Employee {

//    @javax.persistence.Id
    private Integer Id;

    private Integer DeptId;
    private Integer EName;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDeptId() {
        return DeptId;
    }

    public void setDeptId(Integer deptId) {
        DeptId = deptId;
    }

    public Integer getEName() {
        return EName;
    }

    public void setEName(Integer EName) {
        this.EName = EName;
    }
}
