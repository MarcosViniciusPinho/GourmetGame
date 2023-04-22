package com.objective.config;

import com.google.inject.AbstractModule;
import com.objective.adapter.NodeServicePortImpl;
import com.objective.ports.inbound.NodeServicePort;

public class AppDependenciesConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(NodeServicePort.class).to(NodeServicePortImpl.class);
    }

}