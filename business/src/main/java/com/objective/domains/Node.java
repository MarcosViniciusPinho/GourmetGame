package com.objective.domains;

import java.util.*;
import java.util.stream.Collectors;

public class Node {

//    private final String key;
//    private final String value;
//    private Node next;
//
//    public Node(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public Node getNext() {
//        return next;
//    }

    private final Map<String, Object> attributes;
//    private final static String CHILDREN = "children";

    public Node() {
        attributes = new HashMap<>();
//        attributes.put(CHILDREN, new ArrayList<Node>());
    }

    public void setAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

//    public void addChild(Node child) {
//        List<Node> children = (List<Node>) attributes.get(CHILDREN);
//        children.add(child);
//    }

//    public List<Node> getChildren() {
//        return (List<Node>) attributes.get(CHILDREN);
//    }

    public List<String> getAttributeKeys() {
        return attributes.keySet().stream().toList();
//        return new ArrayList<>(keys)
//                .stream()
//                .filter(key -> !CHILDREN.equals(key))
//                .collect(Collectors.toList());
    }
}