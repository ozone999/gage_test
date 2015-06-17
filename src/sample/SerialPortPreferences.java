package android_serialport_api.sample;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android_serialport_api.SerialPortFinder;

public class SerialPortPreferences extends PreferenceActivity
{
  private Application mApplication;
  private SerialPortFinder mSerialPortFinder;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApplication = ((Application)getApplication());
    this.mSerialPortFinder = this.mApplication.mSerialPortFinder;
    addPreferencesFromResource(2130968576);
    ListPreference localListPreference1 = (ListPreference)findPreference("DEVICE");
    String[] arrayOfString1 = this.mSerialPortFinder.getAllDevices();
    String[] arrayOfString2 = this.mSerialPortFinder.getAllDevicesPath();
    localListPreference1.setEntries(arrayOfString1);
    localListPreference1.setEntryValues(arrayOfString2);
    localListPreference1.setSummary(localListPreference1.getValue());
    localListPreference1.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
    {
      public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
      {
        paramPreference.setSummary((String)paramObject);
        return true;
      }
    });
    ListPreference localListPreference2 = (ListPreference)findPreference("BAUDRATE");
    localListPreference2.setSummary(localListPreference2.getValue());
    localListPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
    {
      public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
      {
        paramPreference.setSummary((String)paramObject);
        return true;
      }
    });
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.SerialPortPreferences
 * JD-Core Version:    0.6.0
 */