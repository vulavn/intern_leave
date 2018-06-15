package com.intern.dto;

public class LeaveInfo {

    private int leave_id;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private String reason;
    // ...

    public LeaveInfo(int leave_id, String fromDate, String toDate, String fromTime, String toTime, String reason) {
        this.leave_id = leave_id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.reason = reason;
    }

    public int getLeave_id() {
        return leave_id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public String getReason() {
        return reason;
    }
}
