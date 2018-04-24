/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.connectiontest;

/**
 *
 * @author emil
 */
public class Person {
    private String id;
    private String name;
    private String job;
    private String birthday;

    public Person() {
    }

    public Person(String id, String name, String job, String birthday) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.birthday = birthday;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    
    
}
