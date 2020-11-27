package app.interfaces;
import app.utility.Trigger;


public interface TransitionI {
    public Trigger trigger(Trigger type);
    public String getData();
}