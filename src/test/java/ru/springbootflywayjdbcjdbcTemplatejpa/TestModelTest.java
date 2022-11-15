package ru.springbootflywayjdbcjdbcTemplatejpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.springbootflywayjdbcjdbcTemplatejpa.model.TestModel;

public class TestModelTest extends SpringbootFlywayJdbcJdbcTemplateJpaApplicationTests{
    TestModel testModel = new TestModel();

    @Test
    public void testException(){
        assertThrows(IllegalArgumentException.class,()->{
            testModel.testException();
        });
    }
}
