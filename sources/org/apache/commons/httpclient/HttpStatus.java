package org.apache.commons.httpclient;

public class HttpStatus {
    private static final String[][] REASON_PHRASES = {new String[0], new String[3], new String[8], new String[8], new String[25], new String[8]};
    public static final int SC_ACCEPTED = 202;
    public static final int SC_BAD_GATEWAY = 502;
    public static final int SC_BAD_REQUEST = 400;
    public static final int SC_CONFLICT = 409;
    public static final int SC_CONTINUE = 100;
    public static final int SC_CREATED = 201;
    public static final int SC_EXPECTATION_FAILED = 417;
    public static final int SC_FAILED_DEPENDENCY = 424;
    public static final int SC_FORBIDDEN = 403;
    public static final int SC_GATEWAY_TIMEOUT = 504;
    public static final int SC_GONE = 410;
    public static final int SC_HTTP_VERSION_NOT_SUPPORTED = 505;
    public static final int SC_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
    public static final int SC_INSUFFICIENT_STORAGE = 507;
    public static final int SC_INTERNAL_SERVER_ERROR = 500;
    public static final int SC_LENGTH_REQUIRED = 411;
    public static final int SC_LOCKED = 423;
    public static final int SC_METHOD_FAILURE = 420;
    public static final int SC_METHOD_NOT_ALLOWED = 405;
    public static final int SC_MOVED_PERMANENTLY = 301;
    public static final int SC_MOVED_TEMPORARILY = 302;
    public static final int SC_MULTIPLE_CHOICES = 300;
    public static final int SC_MULTI_STATUS = 207;
    public static final int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    public static final int SC_NOT_ACCEPTABLE = 406;
    public static final int SC_NOT_FOUND = 404;
    public static final int SC_NOT_IMPLEMENTED = 501;
    public static final int SC_NOT_MODIFIED = 304;
    public static final int SC_NO_CONTENT = 204;
    public static final int SC_OK = 200;
    public static final int SC_PARTIAL_CONTENT = 206;
    public static final int SC_PAYMENT_REQUIRED = 402;
    public static final int SC_PRECONDITION_FAILED = 412;
    public static final int SC_PROCESSING = 102;
    public static final int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    public static final int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final int SC_REQUEST_TIMEOUT = 408;
    public static final int SC_REQUEST_TOO_LONG = 413;
    public static final int SC_REQUEST_URI_TOO_LONG = 414;
    public static final int SC_RESET_CONTENT = 205;
    public static final int SC_SEE_OTHER = 303;
    public static final int SC_SERVICE_UNAVAILABLE = 503;
    public static final int SC_SWITCHING_PROTOCOLS = 101;
    public static final int SC_TEMPORARY_REDIRECT = 307;
    public static final int SC_UNAUTHORIZED = 401;
    public static final int SC_UNPROCESSABLE_ENTITY = 422;
    public static final int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int SC_USE_PROXY = 305;

    static {
        addStatusCodeMap(200, "OK");
        addStatusCodeMap(201, "Created");
        addStatusCodeMap(202, "Accepted");
        addStatusCodeMap(204, "No Content");
        addStatusCodeMap(301, "Moved Permanently");
        addStatusCodeMap(302, "Moved Temporarily");
        addStatusCodeMap(304, "Not Modified");
        addStatusCodeMap(400, "Bad Request");
        addStatusCodeMap(401, "Unauthorized");
        addStatusCodeMap(403, "Forbidden");
        addStatusCodeMap(SC_NOT_FOUND, "Not Found");
        addStatusCodeMap(500, "Internal Server Error");
        addStatusCodeMap(501, "Not Implemented");
        addStatusCodeMap(502, "Bad Gateway");
        addStatusCodeMap(503, "Service Unavailable");
        addStatusCodeMap(100, "Continue");
        addStatusCodeMap(307, "Temporary Redirect");
        addStatusCodeMap(SC_METHOD_NOT_ALLOWED, "Method Not Allowed");
        addStatusCodeMap(SC_CONFLICT, "Conflict");
        addStatusCodeMap(SC_PRECONDITION_FAILED, "Precondition Failed");
        addStatusCodeMap(SC_REQUEST_TOO_LONG, "Request Too Long");
        addStatusCodeMap(SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long");
        addStatusCodeMap(SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
        addStatusCodeMap(300, "Multiple Choices");
        addStatusCodeMap(303, "See Other");
        addStatusCodeMap(305, "Use Proxy");
        addStatusCodeMap(402, "Payment Required");
        addStatusCodeMap(SC_NOT_ACCEPTABLE, "Not Acceptable");
        addStatusCodeMap(SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
        addStatusCodeMap(SC_REQUEST_TIMEOUT, "Request Timeout");
        addStatusCodeMap(101, "Switching Protocols");
        addStatusCodeMap(203, "Non Authoritative Information");
        addStatusCodeMap(SC_RESET_CONTENT, "Reset Content");
        addStatusCodeMap(SC_PARTIAL_CONTENT, "Partial Content");
        addStatusCodeMap(504, "Gateway Timeout");
        addStatusCodeMap(505, "Http Version Not Supported");
        addStatusCodeMap(SC_GONE, "Gone");
        addStatusCodeMap(SC_LENGTH_REQUIRED, "Length Required");
        addStatusCodeMap(416, "Requested Range Not Satisfiable");
        addStatusCodeMap(SC_EXPECTATION_FAILED, "Expectation Failed");
        addStatusCodeMap(102, "Processing");
        addStatusCodeMap(SC_MULTI_STATUS, "Multi-Status");
        addStatusCodeMap(422, "Unprocessable Entity");
        addStatusCodeMap(SC_INSUFFICIENT_SPACE_ON_RESOURCE, "Insufficient Space On Resource");
        addStatusCodeMap(420, "Method Failure");
        addStatusCodeMap(423, "Locked");
        addStatusCodeMap(507, "Insufficient Storage");
        addStatusCodeMap(424, "Failed Dependency");
    }

    private static void addStatusCodeMap(int i2, String str) {
        int i3 = i2 / 100;
        REASON_PHRASES[i3][i2 - (i3 * 100)] = str;
    }

    public static String getStatusText(int i2) {
        if (i2 >= 0) {
            int i3 = i2 / 100;
            int i4 = i2 - (i3 * 100);
            if (i3 < 1) {
                return null;
            }
            String[][] strArr = REASON_PHRASES;
            if (i3 > strArr.length - 1 || i4 < 0) {
                return null;
            }
            String[] strArr2 = strArr[i3];
            if (i4 > strArr2.length - 1) {
                return null;
            }
            return strArr2[i4];
        }
        throw new IllegalArgumentException("status code may not be negative");
    }
}
