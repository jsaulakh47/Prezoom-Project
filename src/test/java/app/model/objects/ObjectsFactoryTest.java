package app.model.objects;

import app.interfaces.ObjectsI;
import app.model.attributes.Text;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObjectsFactoryTest {

    ObjectFactory objectFactory;

    @BeforeAll
    public void setup() {
        objectFactory = new ObjectFactory();
    }
}
