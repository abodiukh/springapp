package three.phase.constructor;

import javax.annotation.PostConstruct;

/**
 * @author andrii
 */
public class SimpleMessenger implements Messenger {

    @IntRandomGenerator(min = 2, max = 9)
    private int repeat;

    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Phase 2");
        System.out.println(repeat);
    }

    public SimpleMessenger() {
        System.out.println("Phase 1");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    @PostProxy
    public void say() {
        System.out.println("Phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("Just sing :" + message);
        }
    }
}
