package android_serialport_api.sample;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    ((Button)findViewById(2131165199)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        MainMenu.this.startActivity(new Intent(MainMenu.this, SerialPortPreferences.class));
      }
    });
    ((Button)findViewById(2131165200)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        MainMenu.this.startActivity(new Intent(MainMenu.this, ConsoleActivity.class));
      }
    });
    ((Button)findViewById(2131165201)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        MainMenu.this.startActivity(new Intent(MainMenu.this, LoopbackActivity.class));
      }
    });
    ((Button)findViewById(2131165202)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        MainMenu.this.startActivity(new Intent(MainMenu.this, Sending01010101Activity.class));
      }
    });
    ((Button)findViewById(2131165203)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(MainMenu.this);
        localBuilder.setTitle("About");
        localBuilder.setMessage(2131099649);
        localBuilder.show();
      }
    });
    ((Button)findViewById(2131165204)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        MainMenu.this.finish();
      }
    });
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.MainMenu
 * JD-Core Version:    0.6.0
 */