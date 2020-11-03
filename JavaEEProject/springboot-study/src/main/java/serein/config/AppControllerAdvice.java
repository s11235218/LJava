package serein.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import serein.model.ResponseResult;

// 指定身份：拦截Controller中web请求的类
@ControllerAdvice
/**
 * 异常：1.自定义异常（可以携带自定义的错误信息->可以给用户看的）
 * 2.JDK和框架，程序代码运行时抛出，携带的错误一般是英文->用户看不了的转换
 * web项目中所起的作用：
 *
 * @author Sssserein
 * @creed: Talk is cheap,show me the code
 * @date 2020/11/3 19:41
 */

public class AppControllerAdvice implements ResponseBodyAdvice<Object> {

    // 指定处理请求方法中抛出的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handle(Exception e) {
        e.printStackTrace();
        return null;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;// 执行Controller中的web请求方法结束时，返回数据到前端时，是否要重写响应体
    }

    @Override
    public ResponseResult beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseResult r = new ResponseResult();
        r.setSuccess(true);
        r.setData(body);
        return r;
    }
}
