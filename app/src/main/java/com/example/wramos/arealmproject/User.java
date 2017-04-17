package com.example.wramos.arealmproject;

import io.realm.RealmObject;
import io.realm.annotations.*;

/**
 * Created by wramos on 13/04/17.
 */

public class User extends RealmObject {
    @PrimaryKey
    private int id;
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
