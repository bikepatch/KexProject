interface I {
    int nextValue();
    String name();
}

public class Example {
    int mut(I i) {
        if (i.nextValue() > 0) {
            if (i.nextValue() < 0) {
                System.out.println(i.name() + " is unstable");
                throw new IllegalStateException();
            } else {
                System.out.println(i.name() + " is stable");
                return i.nextValue();
            }
        }
        if (i.name().equals("negative")) {
            return -i.nextValue();
        }
        return 0;
    }
}
