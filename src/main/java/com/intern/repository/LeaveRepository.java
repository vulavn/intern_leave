package com.intern.repository;

import com.intern.dto.LeaveInfo;
import com.intern.exception.NoDataException;

import java.sql.SQLException;
import java.util.List;

public interface LeaveRepository {

    List<LeaveInfo> getAllLeave() throws SQLException, NoDataException;
}
