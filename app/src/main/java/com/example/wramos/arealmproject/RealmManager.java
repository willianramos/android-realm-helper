package com.example.wramos.arealmproject;

import java.lang.reflect.Method;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by wramos on 13/04/17.
 */

class RealmManager {
    private static final RealmManager instance = new RealmManager();
    private Realm realm;

    static RealmManager getInstance() {
        return instance;
    }

    private RealmManager() {
        Realm.init(App.get().getApplicationContext());
        this.realm = Realm.getDefaultInstance();
    }

    static String getFilePath() {
        return instance.realm.getPath();
    }

    static int nextID(Class table) {
        return instance.realm.where(table).findAll().max("id").intValue() + 1;
    }

    static void add(RealmObject object) {
        instance.realm.beginTransaction();

        instance.realm.insert(object);

        instance.realm.commitTransaction();
    }

    static void update(final RealmObject object, Class table, String method, Object value) {

        instance.realm.beginTransaction();

        try {
            Method methodUpdate = table.getDeclaredMethod(method, value.getClass());
            methodUpdate.invoke(object, value);
            instance.realm.insertOrUpdate(object);
            instance.realm.commitTransaction();

        } catch (Exception e) {
            instance.realm.cancelTransaction();
            e.printStackTrace();
        }
    }

    static void remove(final RealmObject object) {
        instance.realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                object.deleteFromRealm();
            }
        });
    }

    static RealmResults<RealmObject> list(Class table) {
        RealmResults<RealmObject> objects = instance.realm.where(table).findAll();

        return objects;
    }

    static RealmObject findBy(String field, String value, Class table) {
        RealmResults<RealmObject> objects = list(table);
        RealmObject object = objects.where().equalTo(field, value).findFirst();

        return object;
    }



}
