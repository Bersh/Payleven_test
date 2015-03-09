package com.example.payleventest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author <a href="mailto:iBersh20@gmail.com">Iliya Bershadskiy</a>
 * @since 09.03.2015
 */
public class SharedPreferencesManager {

    /**
     * Gets a preference key from strings
     *
     * @param context the context
     * @param keyId   key string resource id
     */
    public static String getKey(Context context, int keyId) {
        return context.getString(keyId);
    }

    /**
     * Gets a boolean preference value.
     *
     * @param context      the context
     * @param keyId        key string resource id
     * @param defaultValue the default value
     */
    public static boolean getBoolean(Context context, int keyId, boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(getKey(context, keyId), defaultValue);
    }

    /**
     * Gets a boolean preference value.
     *
     * @param context      the context
     * @param key          key
     * @param defaultValue the default value
     */
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    /**
     * Removes given item from shared preferences
     *
     * @param context context
     * @param keyId   key string resource id
     */
    public static void remove(Context context, int keyId) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(getKey(context, keyId));
        editor.apply();
    }

    /**
     * Removes given item from shared preferences
     *
     * @param context context
     * @param key     key string resource id
     */
    public static void remove(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * Sets a boolean preference value.
     *
     * @param context the context
     * @param keyId   key string resource id
     * @param value   the value
     */
    public static void putBoolean(Context context, int keyId, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(getKey(context, keyId), value);
        editor.apply();
    }

    /**
     * Sets a boolean preference value.
     *
     * @param context the context
     * @param key     key
     * @param value   the value
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Gets a string preference value.
     *
     * @param context      the context
     * @param keyId        key string resource id
     * @param defaultValue default value
     */
    public static String getString(Context context, int keyId, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(getKey(context, keyId), defaultValue);
    }

    /**
     * Gets a string preference value.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue default value
     */
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * Sets a string preference value.
     *
     * @param context the context
     * @param keyId   key string resource id
     * @param value   the value
     */
    public static void putString(Context context, int keyId, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getKey(context, keyId), value);
        editor.apply();
    }

    /**
     * Sets a string preference value.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Puts float preference value.
     *
     * @param context the context
     * @param key     key string
     * @param value   the value
     */
    public static void putFloat(Context context, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Gets float preference value.
     *
     * @param context      the context
     * @param key          key string
     * @param defaultValue the default value
     */
    public static float getFloat(Context context, String key, float defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultValue);
    }

    /**
     * Gets an integer preference value.
     *
     * @param context      the context
     * @param keyId        key string resource id
     * @param defaultValue the default value
     */
    public static int getInt(Context context, int keyId, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt(getKey(context, keyId), defaultValue);
    }

    /**
     * Gets an integer preference value.
     *
     * @param context      the context
     * @param key          key
     * @param defaultValue the default value
     */
    public static int getInt(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * Gets long preference value.
     *
     * @param context      the context
     * @param key          key
     * @param defaultValue the default value
     */
    public static long getLong(Context context, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * Sets an integer preference value.
     *
     * @param context the context
     * @param keyId   key string resource id
     * @param value   the value
     */
    public static void putInt(Context context, int keyId, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(getKey(context, keyId), value);
        editor.apply();
    }

    /**
     * Sets an integer preference value.
     *
     * @param context the context
     * @param key     key
     * @param value   the value
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Sets long preference value.
     *
     * @param context the context
     * @param key     key
     * @param value   the value
     */
    public static void putLong(Context context, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static boolean contains(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                Constants.SharedPreferences.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    public static boolean isCatalogLoaded(Context context) {
        return getBoolean(context, Constants.SharedPreferences.SHARED_PREFERENCES_KEY_CATALOG_LOADED, false);
    }

    public static void setCatalogLoaded(Context context, boolean catalogLoaded) {
        putBoolean(context, Constants.SharedPreferences.SHARED_PREFERENCES_KEY_CATALOG_LOADED, catalogLoaded);
    }
}
