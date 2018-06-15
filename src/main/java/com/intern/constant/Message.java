package com.intern.constant;

public class Message {

    // Error code
    public static final String VALIDATION_ERROR_CODE = "1000";
    public static final String DATABASE_ERROR_CODE = "2000";
    public static final String INTERNAL_ERROR_CODE = "3000";
    public static final String NO_DATA_ERROR_CODE = "4000";

    // Error message
    public static final String VALIDATION_ERROR_MESSAGE = "VALIDATION ERROR";
    public static final String DATABASE_ERROR_MESSAGE = "DATABASE ERROR";
    public static final String INTERNAL_ERROR_MESSAGE = "INTERNAL ERROR";
    public static final String NO_DATA_ERROR_MESSAGE = "NO DATA ERROR";

    // Error detail
    // Validation error detail is the message of each request param
    public static final String DATABASE_ERROR_DETAIL = "DATABASE OR CONNECTION ERROR";
    public static final String INTERNAL_ERROR_DETAIL = "AN INTERNAL ERROR HAS OCCUR";
    public static final String NO_DATA_ERROR_DETAIL = "NO DATA FOUND FROM DATABASE";

}
