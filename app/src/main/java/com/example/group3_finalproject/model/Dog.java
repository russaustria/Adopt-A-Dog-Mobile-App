package com.example.group3_finalproject.model;

import java.util.Objects;

public class Dog {
    private int id;
    private String dogname;
    private String dogbreed;
    private String dognature;
    private String dogcolor;
    private String dogsize;
    private String dogage;

    public Dog(){
    }

    public Dog(int id, String dogname, String dogbreed, String dognature, String dogcolor, String dogsize, String dogage) {
        this.id = id;
        this.dogname = dogname;
        this.dogbreed = dogbreed;
        this.dognature = dognature;
        this.dogcolor = dogcolor;
        this.dogsize = dogsize;
        this.dogage = dogage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogname() {
        return dogname;
    }

    public void setDogname(String dogname) {
        this.dogname = dogname;
    }

    public String getDogbreed() {
        return dogbreed;
    }

    public void setDogbreed(String dogbreed) {
        this.dogbreed = dogbreed;
    }

    public String getDognature() {
        return dognature;
    }

    public void setDognature(String dognature) {
        this.dognature = dognature;
    }

    public String getDogcolor() {
        return dogcolor;
    }

    public void setDogcolor(String dogcolor) {
        this.dogcolor = dogcolor;
    }

    public String getDogsize() {
        return dogsize;
    }

    public void setDogsize(String dogsize) {
        this.dogsize = dogsize;
    }

    public String getDogage() {
        return dogage;
    }

    public void setDogage(String dogage) {
        this.dogage = dogage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dogname);
        hash = 79 * hash + + Objects.hashCode(this.dogbreed);
        hash = 79 * hash + + Objects.hashCode(this.dognature);
        hash = 79 * hash + + Objects.hashCode(this.dogcolor);
        hash = 79 * hash + + Objects.hashCode(this.dogsize);
        hash = 79 * hash + + Objects.hashCode(this.dogage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Dog dog = (Dog) obj;
        return id == dog.id && dogname.equals(dog.dogname) && dogbreed.equals(dog.dogname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog{");
        sb.append("id=").append(id);
        sb.append(", Dog Name='").append(dogname).append('\'');
        sb.append(", Dog Breed=").append(dogbreed).append('\'');
        sb.append(", Dog Nature=").append(dognature).append('\'');
        sb.append(", Dog Color=").append(dogcolor).append('\'');
        sb.append(", Dog Size=").append(dogsize).append('\'');
        sb.append(", Dog Age=").append(dogage);
        sb.append('}');
        return sb.toString();
    }

}
