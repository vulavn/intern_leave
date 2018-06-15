package com.intern.model_attribute;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;

public class CreateLeaveModelAttribute {

    @NotEmpty(message = "fromDate is required")
    private String fromDate;

    @NotEmpty(message = "toDate is required")
    private String toDate;

    @NotEmpty(message = "reason is required")
    private String reason;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
