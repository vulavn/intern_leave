package com.intern.exception;

import com.intern.constant.Message;

public class NoDataException extends  Exception{

    public NoDataException() {
        super(Message.NO_DATA_ERROR_MESSAGE);
    }
}
