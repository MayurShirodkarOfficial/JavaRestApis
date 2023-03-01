package controller;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Timed
public class TimedInterceptor {

    @AroundInvoke
    public Object timeInvocation(InvocationContext ctx) throws Exception{
        long start = System.currentTimeMillis();
        Object result = ctx.proceed();
        return result.toString()+"calculated in" +(System.currentTimeMillis()- start) + "ms";
    }
}
