package app.interfaces;

public interface TransitionI {
    public Trigger trigger(Trigger keyed,Trigger timed);
    public String getData();
}