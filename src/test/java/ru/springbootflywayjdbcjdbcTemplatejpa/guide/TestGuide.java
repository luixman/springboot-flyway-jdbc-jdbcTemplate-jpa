package ru.springbootflywayjdbcjdbcTemplatejpa.guide;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
@DisplayName("Test guide class")
public class TestGuide {

    @BeforeAll//выполняется один раз при создании класса, метод должны быть статическими
    public static void beforeAll(){
        log.info("beforeAll");
    }


    @BeforeEach //будет выполняться перед каждым тестовым методом
    public void beforeEach(){
        log.info("beforeEach");
    }

    @AfterEach //будет выполняться после каждого теста
    public void afterEach(){
        log.info("afterEach");
    }

    @Test
    @DisplayName("name test 1")
    @Disabled ("ne nravitsya")//отключает выполнение теста
    public void test(){
        log.info("test");
    }


    @AfterAll //выполняется 1 рвз после отработки тестов, метод должен быть статическим
    public static void afterAll(){
        log.info("afterAll");
    }

    //Новое в Junit 5
    @Nested //вложенный класс, который выполняет before и after методы предыдущего класса. Нельзя использовать beforeAll и AfterAll
    @TestInstance(TestInstance.Lifecycle.PER_CLASS) //это разрешит использовать beforeAll и AfterAll
    public class InnerClassTest{
        @Test
        public void test(){
            log.info("test inner");
        }
    }



}
