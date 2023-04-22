package com.objective.adapter;

import com.objective.domains.Node;
import com.objective.ports.inbound.NodeServicePort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class NodeServicePortImpl implements NodeServicePort {

    private final List<Node> elements;

    public NodeServicePortImpl() {
        this.elements = new CopyOnWriteArrayList<>();
    }

    @Override
    public void add(Node node) {
        this.elements.add(node);
    }

    @Override
    public Optional<Node> get() {
        for(int i = 0; i < this.elements.size(); i++) {
            Node nodeOld;
            if(i > 0) {
                nodeOld = this.elements.get(i - 1);
                nodeOld.setNext(this.elements.get(i));
            }
        }
        return this.elements.stream().findFirst();
    }

}