package com.intern.response;

import com.intern.dto.LeaveInfo;

import java.util.List;

public class ListLeaveResponse extends CommonResponse {

    private List<LeaveInfo> listLeaveInfo;

    public ListLeaveResponse(String statusCode, List<LeaveInfo> listLeaveInfo) {
        super(statusCode);
        this.listLeaveInfo = listLeaveInfo;
    }

    public List<LeaveInfo> getListLeaveInfo() {
        return listLeaveInfo;
    }

    public void setListLeaveInfo(List<LeaveInfo> listLeaveInfo) {
        this.listLeaveInfo = listLeaveInfo;
    }
}
