# Realm Helper on Android


A simple Helper to manage informations on Realm (https://realm.io) on Android.


Install
-------
 - Install Realm Java on your project: https://realm.io/docs/java/latest/#getting-started;
 - Import RealmManager.java to your project;
 - Create a class to extends Application, and identify in the AndroidManifest.xml. See the example: App.java

Usage
-------
**Add**:
User user = new User();

user.name = "John Test";

user.id = "1";

RealmManager.add(user);

**List**:
RealmManager.list(User.class);


**Find By**:
RealmManger.findBy("id", "1", User.class);

**Update**:
RealmManager.update(user, User.class, "setName", "Paul Test");

**Remove**:
RealmManager.remove(user);

Next Steps
-------

- Migrations;
- Seeds;
