package meetup.droid.miidroid.menu;

import android.app.Activity;

/**
 */
public class MenuItem {

    private String title;

    private Class<?> aClass;

    public MenuItem(String title, Class<?> clazz) {
        this.title = title;
        this.aClass = clazz;
    }

    public String getTitle() {
        return title;
    }

    public Class<?> getClazz() {
        return aClass;
    }
}
