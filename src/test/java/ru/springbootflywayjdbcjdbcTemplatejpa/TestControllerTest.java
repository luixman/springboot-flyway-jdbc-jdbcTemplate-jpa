package ru.springbootflywayjdbcjdbcTemplatejpa;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.springbootflywayjdbcjdbcTemplatejpa.controller.StudentController;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestControllerTest extends SpringbootFlywayJdbcJdbcTemplateJpaApplicationTests {

    @Mock
    StudentController testController;






    @Test()
    public void getAllTest(){

        assertEquals(ResponseEntity.class,testController.getAll().getClass());

    }

    @Test()
    public void lambdaTest () {

        List<String> list = Arrays.asList("3","1","2");

       String result = list.stream().sorted(String::compareTo).findFirst().get();
        System.out.println(result);

        Mockito.when(testController.getAll()).thenReturn(ResponseEntity.ok(""));

        // assertTrue(numbers.stream().mapToInt(Integer::intValue).sum()>5,()->"sum oo");
        assertEquals(testController.getAll(), ResponseEntity.ok(""));
    }
}
