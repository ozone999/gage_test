package android_serialport_api.sample;

import android.content.SharedPreferences;
import android_serialport_api.SerialPort;
import android_serialport_api.SerialPortFinder;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public class Application extends android.app.Application
{
  private SerialPort mSerialPort = null;
  public SerialPortFinder mSerialPortFinder = new SerialPortFinder();

  public void closeSerialPort()
  {
    if (this.mSerialPort != null)
    {
      this.mSerialPort.close();
      this.mSerialPort = null;
    }
  }

  public SerialPort getSerialPort()
    throws SecurityException, IOException, InvalidParameterException
  {
    if (this.mSerialPort == null)
    {
      SharedPreferences localSharedPreferences = getSharedPreferences("android_serialport_api.sample_preferences", 0);
      String str = localSharedPreferences.getString("DEVICE", "");
      int i = Integer.decode(localSharedPreferences.getString("BAUDRATE", "-1")).intValue();
      if ((str.length() == 0) || (i == -1))
        throw new InvalidParameterException();
      this.mSerialPort = new SerialPort(new File(str), i, 0);
    }
    return this.mSerialPort;
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.Application
 * JD-Core Version:    0.6.0
 */