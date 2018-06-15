package com.intern.controller;

import com.intern.constant.Constant;
import com.intern.constant.Message;
import com.intern.dto.Error;
import com.intern.dto.LeaveInfo;
import com.intern.exception.NoDataException;
import com.intern.model_attribute.CreateLeaveModelAttribute;
import com.intern.response.CommonResponse;
import com.intern.response.ErrorResponse;
import com.intern.response.ListLeaveResponse;
import com.intern.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping(value = "v1/getAllLeave", method = RequestMethod.GET) // http://localhost:8080/v1/getAllLeave
    public CommonResponse getAllLeave() {

        try {
            // vì ko có request param nên ko cần validate

            // Get danh sách ngày nghỉ
            List<LeaveInfo> listLeaveInfo = leaveService.getAllLeave();

            // Create response
            ListLeaveResponse listLeaveResponse = new ListLeaveResponse(Constant.SUCCESS_STATUS, listLeaveInfo);

            return listLeaveResponse;

        } catch (SQLException e) {

            // DATABASE ERROR (connection, sql, ...)
            return createErrorResponse(Message.DATABASE_ERROR_CODE, Message.DATABASE_ERROR_MESSAGE, Message.DATABASE_ERROR_DETAIL);

        } catch (NoDataException e) {

            // NO DATA FOUND
            return createErrorResponse(Message.NO_DATA_ERROR_CODE, Message.NO_DATA_ERROR_MESSAGE, Message.NO_DATA_ERROR_DETAIL);

        } catch (Exception e) {

            // INTERNAL ERROR -> xảy ra exception ở bất cứ đâu trong source code ngoài các exception đã xử lý
            // -> để tránh trường hợp dù có lỗi vẫn không bị down hệ thống
            return createErrorResponse(Message.INTERNAL_ERROR_CODE, Message.INTERNAL_ERROR_MESSAGE, Message.INTERNAL_ERROR_DETAIL);
        }
    }




    /* Hướng dẫn nhận request param vào 1 model attribute object và validate bằng annotion */
    /* Nếu chỉ có 1 request param thì ko cần tạo model attribute, nhận trực tiếp vào 1 param luôn */

    // http://localhost:8080/v1/createNewLeave
    // dùng postman, method post, add param vào body x-www-form-urlencoded

    @RequestMapping(value = "v1/createNewLeave", method = RequestMethod.POST)
    public CommonResponse createNewLeave(
            @Valid @ModelAttribute CreateLeaveModelAttribute leaveModelAttribute, BindingResult bindingResult) {

        // khi controller nhận được request thì nó đã parse giá trị request param vào leaveModelAttribute
        // thông qua các lệnh validate configuration trong leaveModelAttribute -> nếu validate lỗi thì bindingResult.hasErrors() = true
        // tất cả các thông tin error của các field đều chứa trong bindingResult
        //    -> có thể debug bindingResult để biết thêm các thông tin gì trong đó
        if (bindingResult.hasErrors()) {

            // VALIDATION ERROR

            // tạo nội dung message detail bằng cach tổng hợp tất cả các error message của từng param
            String errorDetail = createValidationMessageDetail(bindingResult.getAllErrors());
            return createErrorResponse(Message.VALIDATION_ERROR_CODE, Message.VALIDATION_ERROR_MESSAGE, errorDetail);
        }

        return null;
    }


    private CommonResponse createErrorResponse(String code, String message, String detail) {

        Error error = new Error(code, message, detail);
        return new ErrorResponse(Constant.ERROR_STATUS, error);
    }

    private String createValidationMessageDetail(List<ObjectError> listObjectError) {

        List<String> listMessageDetail = new ArrayList<>();
        for (ObjectError error : listObjectError) {
            listMessageDetail.add(error.getDefaultMessage());
        }
        return String.join(" , ", listMessageDetail);
    }
}
