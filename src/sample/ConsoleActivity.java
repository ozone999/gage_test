package android_serialport_api.sample;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.io.IOException;
import java.io.OutputStream;

public class ConsoleActivity extends SerialPortActivity
{
  EditText mReception;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    this.mReception = ((EditText)findViewById(2131165184));
    ((EditText)findViewById(2131165185)).setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
      {
        CharSequence localCharSequence = paramTextView.getText();
        char[] arrayOfChar = new char[localCharSequence.length()];
        int i = 0;
        while (true)
        {
          if (i >= localCharSequence.length());
          try
          {
            ConsoleActivity.this.mOutputStream.write(new String(arrayOfChar).getBytes());
            ConsoleActivity.this.mOutputStream.write(10);
            return false;
            arrayOfChar[i] = localCharSequence.charAt(i);
            i++;
          }
          catch (IOException localIOException)
          {
            while (true)
              localIOException.printStackTrace();
          }
        }
      }
    });
  }

  protected void onDataReceived(byte[] paramArrayOfByte, int paramInt)
  {
    runOnUiThread(new Runnable(paramArrayOfByte, paramInt)
    {
      public void run()
      {
        if (ConsoleActivity.this.mReception != null)
          ConsoleActivity.this.mReception.append(new String(this.val$buffer, 0, this.val$size));
      }
    });
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.ConsoleActivity
 * JD-Core Version:    0.6.0
 */