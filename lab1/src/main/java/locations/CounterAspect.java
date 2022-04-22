package locations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CounterAspect {

    private Map<Character, Integer> map = new HashMap<>();

    @Around("execution(* locations.LocationService.createLocation(..))")
    public Object doLocationCount(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Counter called.");

        Object[] params = pjp.getArgs();
        if (params.length == 3 && params[0] instanceof String) {
            Character startChar = ((String) params[0]).charAt(0);
            map.put(startChar, map.get(startChar) == null ? 1 : map.get(startChar) + 1 );
            params[0] = ((String) params[0]).toUpperCase();
        }

        Object ret = pjp.proceed();

        for (Character key : map.keySet()) {
            System.out.println("Char: " + key + "; Count: " + map.get(key));
        }

        return ret;
    }

    public Integer getCount(Character c) {
        return map.get(c);
    }

    public void resetCounter() {
        map.clear();
    }
}
