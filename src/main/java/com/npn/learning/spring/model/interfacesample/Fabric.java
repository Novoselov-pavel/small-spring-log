package com.npn.learning.spring.model.interfacesample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация фабрики
 */
@Service
public class Fabric {

    @Autowired
    private List<MyInterface> myInterfaces;

    private final Map<String, MyInterface> cache = new HashMap<>();

    public Fabric() {
    }

    /**
     * инициализация, выполняется автоматически после конструктора
     */
    @PostConstruct
    public void init() {
        myInterfaces.forEach(x->cache.put(x.getType(),x));
    }

    /**
     * Фабричный метод
     * @param name
     * @return
     */
    public MyInterface getMyInterface(String name) {
        MyInterface myInterface = cache.get(name);
        if (myInterface == null) throw new IllegalArgumentException("MyInterface implementation "+name+" didn't found");
        return myInterface;
    }

}
