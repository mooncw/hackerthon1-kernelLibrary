package kernel.hackerthon.library.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request.getSession : "+request.getSession().getAttribute("loginUser"));
        String[] allowedURLs = {
                "/user/login",
                "/user/loginProcess",
                "/user/join",
                "/user/logout"
        };

        String requestURI = request.getRequestURI();

        if (compareRequestUriWithAllowedUri(allowedURLs, requestURI)) return true;

        return !interruptWhenNotPermitted(request, response);
    }

    private static boolean interruptWhenNotPermitted(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("loginUser") == null) {
            response.sendRedirect(request.getContextPath() + "/user/login");
            return true;
        }
        return false;
    }

    private static boolean compareRequestUriWithAllowedUri(String[] allowedURLs, String requestURI) {
        for (String allowedURL : allowedURLs) {
            if (requestURI.endsWith(allowedURL)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
