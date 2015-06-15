package three.phase.constructor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author a.bodiukh
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
    Class newImpl();
}
