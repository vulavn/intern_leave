package com.intern.repository.implement;

import com.intern.dto.LeaveInfo;
import com.intern.exception.NoDataException;
import com.intern.repository.LeaveRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeaveRepositoryImpl implements LeaveRepository {

    @Override
    public List<LeaveInfo> getAllLeave() throws SQLException, NoDataException {

        List<LeaveInfo> listLeaveInfo = new ArrayList<LeaveInfo>();




        // ************** Test Connection error *************
        /*if (listLeaveInfo.isEmpty()) {
            throw new SQLException();
        }*/
        // ************** Test Connection error *************





        // thưc hiện select leave info dưới DB và trả ra List<LeaveInfo>
        // ...

        // Giả sử get được list 3 leave
        // public LeaveInfo(int leave_id, String fromDate, String toDate, String fromTime, String toTime, String reason)
        LeaveInfo leaveInfo1 = new LeaveInfo(
                1,
                "20180511",
                "20180511",
                "08:00",
                "17:00",
                "Leave 1");
        LeaveInfo leaveInfo2 = new LeaveInfo(
                2,
                "20180517",
                "20180517",
                "08:00",
                "17:00",
                "Leave 2");
        LeaveInfo leaveInfo3 = new LeaveInfo(
                3,
                "20180522",
                "20180522",
                "08:00",
                "12:00",
                "Leave 3");

        listLeaveInfo.add(leaveInfo1);
        listLeaveInfo.add(leaveInfo2);
        listLeaveInfo.add(leaveInfo3);




        // ************** Test no data error *************
        //listLeaveInfo.clear();
        // ************** Test no data error *************



        // kiểm tra nếu list kết quả ko có data thì throw exception NoDataException
        // NoDataException là exception mà mình tự định nghĩa -> tìm hiểu thêm về custom exception
        if (listLeaveInfo == null || listLeaveInfo.isEmpty()) {
            throw new NoDataException();
        }

        return listLeaveInfo;
    }
}
