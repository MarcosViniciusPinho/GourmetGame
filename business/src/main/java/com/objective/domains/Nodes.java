package com.objective.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class Nodes {

//    private Node primary;
    private final List<Node> elements;

    public Nodes() {
        this.elements = new CopyOnWriteArrayList<>();
    }

    public void add(Node node) {
        this.elements.add(node);
//        this.primary = new Node(key, next);
//        Node newNode = new Node(key, next);
//        if (this.primary == null) {
//            this.primary = newNode;
//        } else {
//            Node current = this.primary;
//            while (current.getNext() != null) {
//                current = current.getNext();
//            }
////            current.setNext(newNode);
//        }
    }

//    public void forEach(Consumer<Node> consumer) {
//        Node current = this.primary;
//        while (current != null) {
//            consumer.accept(current);
//            current = current.getNext();
//        }
//    }

//    public List<Node> all() {
//        for(int i = 0; i < this.elements.size(); i++) {
//            Node nodeOld;
//            if(i > 0) {
//                nodeOld = this.elements.get(i - 1);
//                nodeOld.setNext(this.elements.get(i));
//            }
////            var nodeCurrent = this.elements.get(i);
//
////            for(int j = i+1; j <= this.elements.size(); j++) {
////                var nodeOld = this.elements.get(j);
////                nodeCurrent.setNext(nodeOld);
////            }
//        }
//        return this.elements;
//    }

    public Optional<Node> get() {
        for(int i = 0; i < this.elements.size(); i++) {
            Node nodeOld;
            if(i > 0) {
                nodeOld = this.elements.get(i - 1);
                nodeOld.setNext(this.elements.get(i));
            }
        }
        return this.elements.stream().findFirst();
//        return this.elements.stream().filter(it -> next.equals(it.getKey())).findFirst();
    }

//    public Node get() {
//        return primary;
//    }


//    public List<Node> all() {
//        List<Node> nodes = new ArrayList<>();
////        Node current = this.primary;
////        while (this.primary != null) {
//        if (this.primary != null) {
//            nodes.add(this.primary);
//        }
////            current = current.getNext();
////        }
//        return nodes;
//    }

}