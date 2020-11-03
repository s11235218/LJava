package serein.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义拦截器：只有配置的拦截路径匹配请求路径时，才会执行拦截器中的方式
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
    * Controller中请求方法执行前，就会调用preHandle，返回值决定是否再继续执行Controller中方法
     * return true：继续执行Controller中的方法
     * return false：不执行
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
