package com.esport.tournamentapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode != null && Integer.parseInt(statusCode.toString()) == 404) {
            String uri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
            if (uri != null) {
                if (uri.startsWith("/admin")) {
                    return "admin/404";
                } else {
                    return "user/404";
                }
            }
            // fallback to generic
            return "error/404";
        }

        return "error"; // fallback to a generic error page (optional)
    }
}
