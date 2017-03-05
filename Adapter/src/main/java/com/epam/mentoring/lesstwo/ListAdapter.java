package com.epam.mentoring.lesstwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Liahushau on 3/5/2017.
 */
public class ListAdapter<E> extends ArrayList<E> implements Adapter<E> {

    public ListAdapter() {
        super();
    }

    public ListAdapter(int capacity) {
        super(capacity);
    }

    @Override
    public boolean push(E obj) {
        return this.add(obj);
    }

    @Override
    public E pop() {
        return this.remove(this.size() - 1);
    }
}
