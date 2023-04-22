package com.objective.config;

import com.google.inject.Guice;

public class Inject {

    public static <I> I getInstance(Class<I> clazz) {
        return Guice.createInjector(new AppDependenciesConfig())
                .getInstance(clazz);
    }

}