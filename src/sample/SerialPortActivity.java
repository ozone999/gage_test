package android_serialport_api.sample;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android_serialport_api.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;

public abstract class SerialPortActivity extends Activity
{
  protected Application mApplication;
  private InputStream mInputStream;
  protected OutputStream mOutputStream;
  private ReadThread mReadThread;
  protected SerialPort mSerialPort;

  private void DisplayError(int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Error");
    localBuilder.setMessage(paramInt);
    localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        SerialPortActivity.this.finish();
      }
    });
    localBuilder.show();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApplication = ((Application)getApplication());
    try
    {
      this.mSerialPort = this.mApplication.getSerialPort();
      this.mOutputStream = this.mSerialPort.getOutputStream();
      this.mInputStream = this.mSerialPort.getInputStream();
      this.mReadThread = new ReadThread(null);
      this.mReadThread.start();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      DisplayError(2131099651);
      return;
    }
    catch (IOException localIOException)
    {
      DisplayError(2131099652);
      return;
    }
    catch (InvalidParameterException localInvalidParameterException)
    {
      DisplayError(2131099650);
    }
  }

  protected abstract void onDataReceived(byte[] paramArrayOfByte, int paramInt);

  protected void onDestroy()
  {
    if (this.mReadThread != null)
      this.mReadThread.interrupt();
    this.mApplication.closeSerialPort();
    this.mSerialPort = null;
    super.onDestroy();
  }

  private class ReadThread extends Thread
  {
    private ReadThread()
    {
    }

    public void run()
    {
      super.run();
      while (true)
      {
        if (isInterrupted())
          label11: return;
        try
        {
          byte[] arrayOfByte = new byte[64];
          if (SerialPortActivity.this.mInputStream == null)
            break label11;
          int i = SerialPortActivity.this.mInputStream.read(arrayOfByte);
          if (i <= 0)
            continue;
          SerialPortActivity.this.onDataReceived(arrayOfByte, i);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
    }
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.SerialPortActivity
 * JD-Core Version:    0.6.0
 */