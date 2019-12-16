package com.test1;

import java.io.Serializable;
import java.util.Objects;

/**
 * Immutable Class for keeping phone number. Use fabric method getInstance to create new instance
 * */
public final class Phone implements Serializable {

    private String mobPhone;

    public String getMobPhone() {
        return mobPhone;
    }

    private Phone (String mobPhone){
        this.mobPhone = mobPhone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobPhone);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.hashCode() != this.hashCode()) return false;
        if (!(obj instanceof Phone)) return false;
        Phone phone = (Phone) obj;
        return mobPhone.equals(phone.getMobPhone());
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mobPhone='" + mobPhone + '\'' +
                '}';
    }

    /**
     * factory method
     * */
    public static Phone getInstance (String mobPhone){
        return new Phone(mobPhone);
    }
}
