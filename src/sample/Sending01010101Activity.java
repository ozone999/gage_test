package android_serialport_api.sample;

import android.os.Bundle;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Sending01010101Activity extends SerialPortActivity
{
  byte[] mBuffer;
  SendingThread mSendingThread;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    this.mBuffer = new byte[1024];
    Arrays.fill(this.mBuffer, 85);
    if (this.mSerialPort != null)
    {
      this.mSendingThread = new SendingThread(null);
      this.mSendingThread.start();
    }
  }

  protected void onDataReceived(byte[] paramArrayOfByte, int paramInt)
  {
  }

  private class SendingThread extends Thread
  {
    private SendingThread()
    {
    }

    public void run()
    {
      while (true)
      {
        if (isInterrupted())
          label7: return;
        try
        {
          if (Sending01010101Activity.this.mOutputStream == null)
            break label7;
          Sending01010101Activity.this.mOutputStream.write(Sending01010101Activity.this.mBuffer);
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
 * Qualified Name:     android_serialport_api.sample.Sending01010101Activity
 * JD-Core Version:    0.6.0
 */