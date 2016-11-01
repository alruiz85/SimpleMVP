package es.alruiz.awesomeapp.core;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by AlfonsoRuiz on 01/11/2016.
 */

public class PreferencesManager {

    private static final List<Class<?>> CLASSES = new ArrayList<>();

    static {
        CLASSES.add(String.class);
        CLASSES.add(Boolean.class);
        CLASSES.add(Integer.class);
        CLASSES.add(Long.class);
        CLASSES.add(Float.class);
        CLASSES.add(Set.class);
    }

    private SharedPreferences prefs;

    public PreferencesManager(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void removeKeyFromPreferences(String key) {
        prefs.edit().remove(key).apply();
    }

    public void removeAll() {
        prefs.edit().clear().apply();
    }

    public <T> void persist(String key, T value) {
        final SharedPreferences.Editor ed = prefs.edit();
        if (value == null) {
            ed.putString(key, null);
        } else if (value instanceof String) {
            ed.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            ed.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            ed.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            ed.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            ed.putFloat(key, (Float) value);
        } else if (value instanceof Set) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                throw new IllegalStateException(
                        "You can add sets in the preferences only after API "
                                + Build.VERSION_CODES.HONEYCOMB);
            }
            @SuppressWarnings({"unchecked", "unused"}) SharedPreferences.Editor
                    soIcanAddSuppress = ed.putStringSet(key, (Set<String>) value);
        } else {
            throw new IllegalArgumentException(
                    "The given value : " + value + " cannot be persisted");
        }
        ed.apply();
    }

    public <T> T retrieve(String key, T defaultValue) {
        if (defaultValue == null) {
            if (!prefs.contains(key)) {
                return null;
            }
            // if the key does exist I get the value and..
            final Object value = prefs.getAll().get(key);
            // ..if null I return null
            if (value == null) {
                return null;
            }

            final Class<?> clazz = value.getClass();
            for (Class<?> cls : CLASSES) {
                if (clazz.isAssignableFrom(cls)) {
                    try {
                        return (T) clazz.cast(value);
                    } catch (ClassCastException e) {
                        String msg = "Value : "
                                + value
                                + " stored for key : "
                                + key
                                + " is not assignable to variable of given type.";
                        throw new IllegalStateException(msg, e);
                    }
                }
            }
            // that's really Illegal State I guess
            throw new IllegalStateException(
                    "Unknown class for value :\n\t" + value + "\nstored in preferences");
        } else if (defaultValue instanceof String) {
            return (T) prefs.getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Boolean) {
            return (T) (Boolean) prefs.getBoolean(key, (Boolean) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return (T) (Integer) prefs.getInt(key, (Integer) defaultValue);
        } else if (defaultValue instanceof Long) {
            return (T) (Long) prefs.getLong(key, (Long) defaultValue);
        } else if (defaultValue instanceof Float) {
            return (T) (Float) prefs.getFloat(key, (Float) defaultValue);
        } else if (defaultValue instanceof Set) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                throw new IllegalStateException("You can add sets in the preferences only after API"
                        + Build.VERSION_CODES.HONEYCOMB);
            }
            return (T) prefs.getStringSet(key, (Set<String>) defaultValue);
        } else {
            throw new IllegalArgumentException(
                    defaultValue + "cannot be persisted in SharedPreferences");
        }
    }
}