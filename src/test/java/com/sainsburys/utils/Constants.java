package com.sainsburys.utils;

public class Constants {
    // @Paths
    public static final String home = System.getProperty("user.dir");
    public static final String logDirectory = home + "//logs//";
    public static final String logArchiveDirectory = home + "//logs//Archive//";

    // @Header Response
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_CONTENT_VALUE = "application/json";

    // @Azure Token Config
    public static final String GRAPH_AZURE_SCOPE = "GRAPH_AZURE_SCOPE";
    public static final String TOKEN_ISSUER_URL = "TOKEN_ISSUER_URL";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String BEARER = "Bearer";
    public static final String JDBC = "JDBC";

    // JSON Fields
    public static final String MESSAGE = "message";
    public static final String MESSAGE_HEADER = "messageHeader";
    public static final String CORRELATION_ID = "correlationId";
    public static final String CREATION_TIMESTAMP = "creationTimestamp";

    // JSON
    public static final String TRANSFER = "transfer";
    public static final String ALLOCATION = "allocation";

    // Date Format
    public static final String DATE_FORMAT = "yyy-MM-dd'T'HH:mm:ss";
}
