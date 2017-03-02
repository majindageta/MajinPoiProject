package com.majin.mappoi.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by davidericci on 02/03/17.
 */

public class SharedPreferencesManager {

    private static String PREFERENZE_NOME = "MapPoiPreferences";

    private static SharedPreferencesManager manager_;

    public static String PREFERENZE_PULL_SERVICE = "PullServiceBootReceiver_AVVIATO";

    private Context context_;

    private SharedPreferencesManager(Context context)
    {
        super();
        context_ = context;

    }

    public static SharedPreferencesManager getManager(Context context)
    {
        if (manager_ == null)
        {
            manager_ = new SharedPreferencesManager(context);
        }
        return manager_;
    }

    public void removePref(String pref)
    {
        SharedPreferences valPref = context_.getSharedPreferences(PREFERENZE_NOME, 0);
        if(valPref.contains(pref)){
            SharedPreferences.Editor editor = valPref.edit();
            editor.remove(pref);
            editor.commit();
        }
    }

    public void clearAllPreferences()
    {
        SharedPreferences valPref = context_.getSharedPreferences(PREFERENZE_NOME, 0);
        SharedPreferences.Editor editor = valPref.edit();
        editor.clear();
        editor.commit();
    }

    public boolean contains(String key)
    {
        SharedPreferences valPref = context_.getSharedPreferences(PREFERENZE_NOME, 0);
        return valPref.contains(key);
    }

}
