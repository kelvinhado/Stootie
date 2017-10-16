package com.kelvinhado.stootie.data.source.remote.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kelvin on 12/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {

    private String total;

    private String per_page;

    private String current_page;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    @Override
    public String toString() {
        return "ClassPojo [total = " + total + ", per_page = " + per_page + ", current_page = " + current_page + "]";
    }
}
