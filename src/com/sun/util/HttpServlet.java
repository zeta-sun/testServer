package com.sun.util;

import java.io.IOException;

//请求规则类
public abstract class HttpServlet {

    public abstract void service(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
