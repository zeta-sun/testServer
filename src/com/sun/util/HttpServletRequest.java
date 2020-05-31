package com.sun.util;

public class HttpServletRequest {

    //请求方法
    private String method;

    //请求资源地址，请求名
    private String requestPath;

    private String version;

    public HttpServletRequest(String method, String requestPath, String version) {
        this.method = method;
        this.requestPath = requestPath;
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public String getVersion() {
        return version;
    }
}
