package edu.escuelaing.arep.util;

import java.util.Iterator;

/**
 * Implementacion de Iterador para la lista encadenada
 *
 * Autor: Juan Sebastian Ramos Isaza
 */
public class IteratorList<T> implements Iterator<T> {

    private Node<T> actual;

    public IteratorList(Node<T> node){
        this.actual=node;
    }
    @Override
    public boolean hasNext() {
        return actual!=null;
    }

    @Override
    public T next() {
        T data = this.actual.getData();
        Node<T> node= this.actual.getNext();
        this.actual=node;
        return data;
    }
}
