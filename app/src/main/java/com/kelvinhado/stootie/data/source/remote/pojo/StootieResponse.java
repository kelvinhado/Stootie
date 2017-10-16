package com.kelvinhado.stootie.data.source.remote.pojo;

/**
 * Created by kelvin on 12/10/2017.
 */

public class StootieResponse {
    private Collection[] collection;

    private Pagination pagination;

    public Collection[] getCollection() {
        return collection;
    }

    public void setCollection(Collection[] collection) {
        this.collection = collection;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "ClassPojo [collection = " + collection + ", pagination = " + pagination + "]";
    }
}
