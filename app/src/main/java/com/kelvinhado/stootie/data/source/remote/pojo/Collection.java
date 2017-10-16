package com.kelvinhado.stootie.data.source.remote.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kelvin on 12/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection {
    private String purchases_price;

    private String asker_id;

    private String state;

    private String lng;

    private String unit_price;

    private String id;

    private String title;

    private String description;

    private String answer_id;

    private String pricing_type;

    private String share_url;

    private String comission;

    private String created_at;

    private String lat;

    private String offers_count;

    private String category_id;

    private String online_payment;

    private String updated_at;

    private String address;

    private String stoot_type;

    private String messages_count;

    private String package_id;

    private User user;

    private String deadline;

    public String getPurchases_price() {
        return purchases_price;
    }

    public void setPurchases_price(String purchases_price) {
        this.purchases_price = purchases_price;
    }

    public String getAsker_id() {
        return asker_id;
    }

    public void setAsker_id(String asker_id) {
        this.asker_id = asker_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public String getPricing_type() {
        return pricing_type;
    }

    public void setPricing_type(String pricing_type) {
        this.pricing_type = pricing_type;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getComission() {
        return comission;
    }

    public void setComission(String comission) {
        this.comission = comission;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getOffers_count() {
        return offers_count;
    }

    public void setOffers_count(String offers_count) {
        this.offers_count = offers_count;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getOnline_payment() {
        return online_payment;
    }

    public void setOnline_payment(String online_payment) {
        this.online_payment = online_payment;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStoot_type() {
        return stoot_type;
    }

    public void setStoot_type(String stoot_type) {
        this.stoot_type = stoot_type;
    }

    public String getMessages_count() {
        return messages_count;
    }

    public void setMessages_count(String messages_count) {
        this.messages_count = messages_count;
    }

    public String getPackage_id() {
        return package_id;
    }

    public void setPackage_id(String package_id) {
        this.package_id = package_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "purchases_price='" + purchases_price + '\'' +
                ", asker_id='" + asker_id + '\'' +
                ", state='" + state + '\'' +
                ", lng='" + lng + '\'' +
                ", unit_price='" + unit_price + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", answer_id='" + answer_id + '\'' +
                ", pricing_type='" + pricing_type + '\'' +
                ", share_url='" + share_url + '\'' +
                ", comission='" + comission + '\'' +
                ", created_at='" + created_at + '\'' +
                ", lat='" + lat + '\'' +
                ", offers_count='" + offers_count + '\'' +
                ", category_id='" + category_id + '\'' +
                ", online_payment='" + online_payment + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", address='" + address + '\'' +
                ", stoot_type='" + stoot_type + '\'' +
                ", messages_count='" + messages_count + '\'' +
                ", package_id='" + package_id + '\'' +
                ", user=" + user +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
