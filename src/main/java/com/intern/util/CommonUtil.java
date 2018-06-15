package com.intern.util;

import com.intern.dto.LeaveInfo;
import com.intern.response.ListLeaveResponse;

import java.util.List;

public class CommonUtil {

    public static boolean isStringNull(String string) {

        if (string == null || string.equals("")) {
            return true;
        }
        return false;
    }

}
