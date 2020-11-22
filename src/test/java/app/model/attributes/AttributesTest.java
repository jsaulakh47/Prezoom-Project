package app.model.attributes;

import app.model.objects.ObjectFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttributesTest {

    Attributes attributes;

    @BeforeAll
    public void setup() {
        attributes = new Attributes("", "");
    }

    @Test
    public void testSetData() {
        // TODO: Add test case code here for setData() method.
    }
}
