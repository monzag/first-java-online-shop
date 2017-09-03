package frompythontojava.onlineshop.part2;

public abstract class AbstractProcess {

    public void process(Orderable item) {
        stepBefore();
        action(item);
        stepAfter();
    }

    public void stepBefore() {
        System.out.println("Process");
    }

    public abstract void action(Orderable item);

    public void stepAfter() {
        System.out.println("Done");
    }
}