package com.intern.response;

import com.intern.dto.Employee;

import java.util.List;

public class ListEmployeeResponse extends CommonResponse {

    private List<Employee> listEmployee;

    public ListEmployeeResponse(String statusCode, List<Employee> listEmployee) {

        super(statusCode);
        this.listEmployee = listEmployee;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
}
