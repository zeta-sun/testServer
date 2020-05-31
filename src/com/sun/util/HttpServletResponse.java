package com.sun.util;

import java.io.Writer;

public class HttpServletResponse {

    private Writer writer;

    public HttpServletResponse(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }
}
