package com.npn.learning.spring.model.interfacesample;

public interface MyInterface {

    /**
     * Возвращает строковое наименование типа класса для связывания в фабрике
     *
     * @return типа класса
     */
    String getType();

    /**
     * Выполняет какую-то работу
     *
     * @param a параметр 1
     * @param b параметр 2
     * @return результат
     */
    String doWork(String a, String b);
}
