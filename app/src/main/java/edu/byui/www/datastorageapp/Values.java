package edu.byui.www.datastorageapp;

/**
 * Created by Julian on 11/12/2016.
 */

public class Values {
    private int _id;
    private String _value;

    public Values(){
    }

    public Values(String value) {
        this._value = value;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public int get_id() {
        return _id;
    }

    public String get_value() {
        return _value;
    }
}
