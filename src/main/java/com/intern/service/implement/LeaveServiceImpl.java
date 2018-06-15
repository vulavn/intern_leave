package com.intern.service.implement;

import com.intern.dto.LeaveInfo;
import com.intern.exception.NoDataException;
import com.intern.repository.LeaveRepository;
import com.intern.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<LeaveInfo> getAllLeave() throws SQLException, NoDataException, Exception {

        List<LeaveInfo> listLeaveInfo = leaveRepository.getAllLeave();

        // ************** Test internal error *************
        /*if (listLeaveInfo != null) {
            throw new Exception();
        }*/
        // ************** Test internal error *************

        // vì ko có xử lý gì thêm nên return list listLeaveInfo về controller luôn
        // nếu có các xử lý thêm nào khác thì sẽ xử lý tại service (ví dụ như tính toán giờ giấc, sum kết quả, ...)
        //  -> ko được trả kết quả về controller rồi xử lý
        // Vì controller chỉ làm nhiện vụ điều hướng
        // Service làm nhiệm vụ xử lý
        // Repository làm nhiệm vụ dưới database
        return listLeaveInfo;
    }
}
