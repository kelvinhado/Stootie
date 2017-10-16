package com.kelvinhado.stootie.data.source.remote.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kelvin on 12/10/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String response_rate;

    private String eval_count;

    private String thumb_picture_url;

    private String last_sign_in_at;

    private String lastname;

    private String firstname;

    private String followed;

    private String eval_avg;

    private String id;

    private String response_time;

    private String created_at;

    private String profile_picture_url;

    private String common_friends;

    public String getResponse_rate() {
        return response_rate;
    }

    public void setResponse_rate(String response_rate) {
        this.response_rate = response_rate;
    }

    public String getEval_count() {
        return eval_count;
    }

    public void setEval_count(String eval_count) {
        this.eval_count = eval_count;
    }

    public String getThumb_picture_url() {
        return thumb_picture_url;
    }

    public void setThumb_picture_url(String thumb_picture_url) {
        this.thumb_picture_url = thumb_picture_url;
    }

    public String getLast_sign_in_at() {
        return last_sign_in_at;
    }

    public void setLast_sign_in_at(String last_sign_in_at) {
        this.last_sign_in_at = last_sign_in_at;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

    public String getEval_avg() {
        return eval_avg;
    }

    public void setEval_avg(String eval_avg) {
        this.eval_avg = eval_avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getProfile_picture_url() {
        return profile_picture_url;
    }

    public void setProfile_picture_url(String profile_picture_url) {
        this.profile_picture_url = profile_picture_url;
    }

    public String getCommon_friends() {
        return common_friends;
    }

    public void setCommon_friends(String common_friends) {
        this.common_friends = common_friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "response_rate='" + response_rate + '\'' +
                ", eval_count='" + eval_count + '\'' +
                ", thumb_picture_url='" + thumb_picture_url + '\'' +
                ", last_sign_in_at='" + last_sign_in_at + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", followed='" + followed + '\'' +
                ", eval_avg='" + eval_avg + '\'' +
                ", id='" + id + '\'' +
                ", response_time='" + response_time + '\'' +
                ", created_at='" + created_at + '\'' +
                ", profile_picture_url='" + profile_picture_url + '\'' +
                ", common_friends='" + common_friends + '\'' +
                '}';
    }
}
