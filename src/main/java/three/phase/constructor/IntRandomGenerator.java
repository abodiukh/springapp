package three.phase.constructor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author andrii
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IntRandomGenerator {

    int max();

    int min();
}
