package io.radika.textviewtest;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by greenapsis on 1/07/16.
 */
public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
   }


}
