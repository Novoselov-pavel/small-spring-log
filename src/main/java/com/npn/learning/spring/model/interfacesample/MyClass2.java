package com.npn.learning.spring.model.interfacesample;

import org.springframework.stereotype.Service;

@Service
public class MyClass2 implements MyInterface {
    /**
     * Возвращает строковое наименование типа класса для связывания в фабрике
     *
     * @return типа класса
     */
    @Override
    public String getType() {
        return "myClass2";
    }

    /**
     * Выполняет какую-то работу
     *
     * @param a параметр 1
     * @param b параметр 2
     * @return результат
     */
    @Override
    public String doWork(String a, String b) {
        return a.compareTo(b)>0? a : b;
    }

}
