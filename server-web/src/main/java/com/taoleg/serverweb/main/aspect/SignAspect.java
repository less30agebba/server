package com.taoleg.serverweb.main.aspect;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.taoleg.servercore.common.signatrue.Signature;
import com.taoleg.servercore.common.signatrue.SignatureExecutor;
import com.taoleg.serverweb.main.common.BodyReaderHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 校验签名的切面
 */
@Aspect
@Component
public class SignAspect {

    static private Logger logger = LoggerFactory.getLogger(SignAspect.class);

    private static Map<String, Method> MethodCaches = new HashMap<>();

    @Autowired
    private SignatureExecutor signatureExecutor;

    @Pointcut("@annotation(com.taoleg.servercore.common.signatrue.annotation.SignSecret)")
    public void signAspect() {
    }

    @Before("signAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {

        //Note:这里用到的Request其实是拦截器包装后的WrapperRequest对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        BodyReaderHttpServletRequestWrapper requestWrapper = (BodyReaderHttpServletRequestWrapper) request;

        Object[] args = joinPoint.getArgs();
        String targetClassName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        String key = targetClassName + methodName;
        Method method = MethodCaches.get(key);
        if (null == method) {
            Class<?> targetClass = Class.forName(targetClassName);
            List<Method> collect = Stream.of(targetClass.getMethods())
                    .filter(targetMethod -> methodName.equals(targetMethod.getName())).collect(Collectors.toList());
            method = collect.get(0);
            MethodCaches.put(key, method);
        }

        //1.验证接口签名完整性
        //获取签名（请求Header，或者Body）
        String signatureStr = request.getHeader("signature");
        Signature signature;
        if (StringUtils.isEmpty(signatureStr)) {
            signature = JSON.parseObject(new String(requestWrapper.getRequestBody()), Signature.class);
        } else {
            signature = new Signature().parse(signatureStr);
        }

        //2.校验签名
        signatureExecutor.validate(signature, args[0]);
    }

}
