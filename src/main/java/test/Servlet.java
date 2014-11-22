package test;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/")) {
            InputStream input = getServletContext().getResourceAsStream("/templates/index.html");
            resp.getWriter().write(IOUtils.toString(input));
        } else if (req.getRequestURI().equals("/runtime.js")) {
            InputStream input = getServletContext().getResourceAsStream("/js/teavm/runtime.js");
            resp.getWriter().write(IOUtils.toString(input));
        } else if (req.getRequestURI().equals("/classes.js")) {
            InputStream input = getServletContext().getResourceAsStream("/js/teavm/classes.js");
            resp.getWriter().write(IOUtils.toString(input));
        }
    }
}
