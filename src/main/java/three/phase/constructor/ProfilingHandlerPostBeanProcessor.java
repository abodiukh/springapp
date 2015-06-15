package three.phase.constructor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author andrii
 */
public class ProfilingHandlerPostBeanProcessor implements BeanPostProcessor {
    private Map<String, Class> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerPostBeanProcessor() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> oClass = o.getClass();
        if (oClass.isAnnotationPresent(Profiling.class)) {
            map.put(s, oClass);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        Class oClass = map.get(s);
        if (oClass != null) {
            return Proxy.newProxyInstance(oClass.getClassLoader(), oClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    if (controller.isEnabled()) {
                        System.out.println("Putin huylo");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(o, objects);
                        long after = System.nanoTime();
                        System.out.println(after-before);
                        System.out.println("Again");
                        return retVal;
                    } else {
                        return method.invoke(o, objects);
                    }
                }
            });
        }
        return o;
    }
}
