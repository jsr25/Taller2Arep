package edu.escuelaing.arep.util;

/**
        * Implementacion del nodo para la lsta encadenada
        *
        * Autor: Juan Sebastian Ramos Isaza
        */
public class Node<T> {
    private Node<T> next;
    private T data;


    public Node(T e) {
        this.data = e;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext(){
        return next;
    }

    public boolean hasNext() {
        return next!=null;
    }

}
