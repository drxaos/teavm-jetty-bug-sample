package test;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/")) {
            InputStream input = getServletContext().getResourceAsStream("/templates/index.html");
            resp.getOutputStream().write(IOUtils.toString(input).getBytes(Charset.defaultCharset()));
        } else if (req.getRequestURI().equals("/runtime.js")) {
            InputStream input = getServletContext().getResourceAsStream("/js/teavm/runtime.js");
            resp.getOutputStream().write(IOUtils.toString(input).getBytes(Charset.defaultCharset()));
        } else if (req.getRequestURI().equals("/classes.js")) {
            InputStream input = getServletContext().getResourceAsStream("/js/teavm/classes.js");
            resp.getOutputStream().write(IOUtils.toString(input).getBytes(Charset.defaultCharset()));
        }
    }
}
