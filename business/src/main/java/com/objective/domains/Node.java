package com.objective.domains;

public class Node {

    private final String key;
    private Node next;

    public Node(String next) {
        this.key = next;
    }

    public Node(String key, String next) {
        this.key = key;
        this.next = new Node(next);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public Node getNext() {
        return next;
    }
}