package com.objective.ports.inbound;

import com.objective.domains.Node;

import java.util.Optional;

public interface NodeServicePort {

    void add(Node node);
    Optional<Node> get();

}