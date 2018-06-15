package com.intern.service;

import com.intern.dto.LeaveInfo;
import com.intern.exception.NoDataException;

import java.sql.SQLException;
import java.util.List;

public interface LeaveService {

    List<LeaveInfo> getAllLeave() throws SQLException, NoDataException, Exception;
}
