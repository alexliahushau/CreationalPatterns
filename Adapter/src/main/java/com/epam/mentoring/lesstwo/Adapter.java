package com.epam.mentoring.lesstwo;

/**
 * Created by Aliaksandr_Liahushau on 3/5/2017.
 */
public interface Adapter<E> {
    public boolean push( final E obj);
    public E pop();
}