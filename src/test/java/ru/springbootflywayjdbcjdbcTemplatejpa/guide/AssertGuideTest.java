package ru.springbootflywayjdbcjdbcTemplatejpa.guide;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;

@Slf4j
public class AssertGuideTest {

    @Test

    public void test() {
        int a = 1000;
        int b = 1000;

        // assertSame(a,b); //сравнение по ссылке
        // assertNotSame(a,b); //сравнение по ссылке

//        assertEquals(a, b); //сравнение equals
//        assertNotEquals(a, b, "если упала проверка, то это выведется в консоль"); //сравнение equals

        // assertArrayEquals(); сравнить 2 массива
        // assertIterableEquals(); сравнить 2 коллекции
        // assertLinesMatch(); сравнить, что 2 коллекции имеют одни и те же строки (стринг)

        // assertNull();
        //assertNotNull();

//        assertTrue();
//        assertFalse();

//        assertTimeout(Duration.ofSeconds(1), () -> {
//            Thread.sleep(5000);
//        });  //проверка на время выполнения, полностью выполняет метод и сообщает о времени, даже если оно было превышено


//       assertTimeoutPreemptively(Duration.ofSeconds(1),()->{
//            Thread.sleep(5000);
//       }); // проверяет время выполнения, если время было превышено, то прерывает выполнение

//        assertThrows(RuntimeException.class,()->{
//            throw new IOException();
//        });


//        fail(); //просто зафейлить тест

    }
}
