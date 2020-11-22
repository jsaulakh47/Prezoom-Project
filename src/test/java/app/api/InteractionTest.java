package app.api;

import app.model.Sheet;
import app.model.States;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InteractionTest {
    Interaction interaction;

    @BeforeAll
    public void setup() {
        interaction = new Interaction();
    }

    @BeforeEach
    public void resetSingletonSheetInstance() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        // Reference: https://stackoverflow.com/questions/8256989/singleton-and-unit-testing
        Field instance = Sheet.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void testAddState() {
        Interaction.addState();
        assertEquals("Interaction api did not add states correctly.",
                Sheet.getInstance().getStates().size(), 1);

        Interaction.addState();
        Interaction.addState();
        Interaction.addState();
        assertEquals("Interaction api did not add states correctly.",
                Sheet.getInstance().getStates().size(), 4);
    }

    @Test
    public void testGetStates() {
        Interaction.addState();
        assertTrue("Interaction api did not get states correctly.",
                Sheet.getInstance().getStates() instanceof List);
        assertEquals("Interaction api did not get states correctly.",
                Sheet.getInstance().getStates().size(), 1);
    }
}
