package android_serialport_api.sample;

import android.os.Bundle;
import android.widget.TextView;

public class LoopbackActivity extends SerialPortActivity
{
  boolean mByteReceivedBack;
  Object mByteReceivedBackSemaphore = new Object();
  Integer mCorrupted = new Integer(0);
  Integer mIncoming = new Integer(0);
  Integer mLost = new Integer(0);
  Integer mOutgoing = new Integer(0);
  SendingThread mSendingThread;
  TextView mTextViewCorrupted;
  TextView mTextViewIncoming;
  TextView mTextViewLost;
  TextView mTextViewOutgoing;
  byte mValueToSend;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    this.mTextViewOutgoing = ((TextView)findViewById(2131165188));
    this.mTextViewIncoming = ((TextView)findViewById(2131165191));
    this.mTextViewLost = ((TextView)findViewById(2131165194));
    this.mTextViewCorrupted = ((TextView)findViewById(2131165197));
    if (this.mSerialPort != null)
    {
      this.mSendingThread = new SendingThread(null);
      this.mSendingThread.start();
    }
  }

  // ERROR //
  protected void onDataReceived(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	android_serialport_api/sample/LoopbackActivity:mByteReceivedBackSemaphore	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore 4
    //   10: iload 4
    //   12: iload_2
    //   13: if_icmplt +6 -> 19
    //   16: aload_3
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: iload 4
    //   22: baload
    //   23: aload_0
    //   24: getfield 88	android_serialport_api/sample/LoopbackActivity:mValueToSend	B
    //   27: if_icmpne +25 -> 52
    //   30: aload_0
    //   31: getfield 90	android_serialport_api/sample/LoopbackActivity:mByteReceivedBack	Z
    //   34: ifne +18 -> 52
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 90	android_serialport_api/sample/LoopbackActivity:mByteReceivedBack	Z
    //   42: aload_0
    //   43: getfield 31	android_serialport_api/sample/LoopbackActivity:mByteReceivedBackSemaphore	Ljava/lang/Object;
    //   46: invokevirtual 93	java/lang/Object:notify	()V
    //   49: goto +29 -> 78
    //   52: aload_0
    //   53: iconst_1
    //   54: aload_0
    //   55: getfield 44	android_serialport_api/sample/LoopbackActivity:mCorrupted	Ljava/lang/Integer;
    //   58: invokevirtual 97	java/lang/Integer:intValue	()I
    //   61: iadd
    //   62: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: putfield 44	android_serialport_api/sample/LoopbackActivity:mCorrupted	Ljava/lang/Integer;
    //   68: goto +10 -> 78
    //   71: astore 5
    //   73: aload_3
    //   74: monitorexit
    //   75: aload 5
    //   77: athrow
    //   78: iinc 4 1
    //   81: goto -71 -> 10
    //
    // Exception table:
    //   from	to	target	type
    //   16	18	71	finally
    //   19	49	71	finally
    //   52	68	71	finally
    //   73	75	71	finally
  }

  protected void onDestroy()
  {
    if (this.mSendingThread != null)
      this.mSendingThread.interrupt();
    super.onDestroy();
  }

  private class SendingThread extends Thread
  {
    private SendingThread()
    {
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 27	android_serialport_api/sample/LoopbackActivity$SendingThread:isInterrupted	()Z
      //   4: ifeq +4 -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   12: getfield 33	android_serialport_api/sample/LoopbackActivity:mByteReceivedBackSemaphore	Ljava/lang/Object;
      //   15: astore_1
      //   16: aload_1
      //   17: monitorenter
      //   18: aload_0
      //   19: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   22: iconst_0
      //   23: putfield 37	android_serialport_api/sample/LoopbackActivity:mByteReceivedBack	Z
      //   26: aload_0
      //   27: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   30: getfield 41	android_serialport_api/sample/LoopbackActivity:mOutputStream	Ljava/io/OutputStream;
      //   33: ifnull +116 -> 149
      //   36: aload_0
      //   37: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   40: getfield 41	android_serialport_api/sample/LoopbackActivity:mOutputStream	Ljava/io/OutputStream;
      //   43: aload_0
      //   44: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   47: getfield 45	android_serialport_api/sample/LoopbackActivity:mValueToSend	B
      //   50: invokevirtual 51	java/io/OutputStream:write	(I)V
      //   53: aload_0
      //   54: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   57: astore 4
      //   59: aload 4
      //   61: iconst_1
      //   62: aload 4
      //   64: getfield 55	android_serialport_api/sample/LoopbackActivity:mOutgoing	Ljava/lang/Integer;
      //   67: invokevirtual 61	java/lang/Integer:intValue	()I
      //   70: iadd
      //   71: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   74: putfield 55	android_serialport_api/sample/LoopbackActivity:mOutgoing	Ljava/lang/Integer;
      //   77: aload_0
      //   78: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   81: getfield 33	android_serialport_api/sample/LoopbackActivity:mByteReceivedBackSemaphore	Ljava/lang/Object;
      //   84: ldc2_w 66
      //   87: invokevirtual 73	java/lang/Object:wait	(J)V
      //   90: aload_0
      //   91: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   94: getfield 37	android_serialport_api/sample/LoopbackActivity:mByteReceivedBack	Z
      //   97: ifeq +63 -> 160
      //   100: aload_0
      //   101: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   104: astore 7
      //   106: aload 7
      //   108: iconst_1
      //   109: aload 7
      //   111: getfield 76	android_serialport_api/sample/LoopbackActivity:mIncoming	Ljava/lang/Integer;
      //   114: invokevirtual 61	java/lang/Integer:intValue	()I
      //   117: iadd
      //   118: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   121: putfield 76	android_serialport_api/sample/LoopbackActivity:mIncoming	Ljava/lang/Integer;
      //   124: aload_0
      //   125: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   128: new 78	android_serialport_api/sample/LoopbackActivity$SendingThread$1
      //   131: dup
      //   132: aload_0
      //   133: invokespecial 81	android_serialport_api/sample/LoopbackActivity$SendingThread$1:<init>	(Landroid_serialport_api/sample/LoopbackActivity$SendingThread;)V
      //   136: invokevirtual 85	android_serialport_api/sample/LoopbackActivity:runOnUiThread	(Ljava/lang/Runnable;)V
      //   139: aload_1
      //   140: monitorexit
      //   141: goto -141 -> 0
      //   144: astore_2
      //   145: aload_1
      //   146: monitorexit
      //   147: aload_2
      //   148: athrow
      //   149: aload_1
      //   150: monitorexit
      //   151: return
      //   152: astore_3
      //   153: aload_3
      //   154: invokevirtual 88	java/io/IOException:printStackTrace	()V
      //   157: aload_1
      //   158: monitorexit
      //   159: return
      //   160: aload_0
      //   161: getfield 10	android_serialport_api/sample/LoopbackActivity$SendingThread:this$0	Landroid_serialport_api/sample/LoopbackActivity;
      //   164: astore 6
      //   166: aload 6
      //   168: iconst_1
      //   169: aload 6
      //   171: getfield 91	android_serialport_api/sample/LoopbackActivity:mLost	Ljava/lang/Integer;
      //   174: invokevirtual 61	java/lang/Integer:intValue	()I
      //   177: iadd
      //   178: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   181: putfield 91	android_serialport_api/sample/LoopbackActivity:mLost	Ljava/lang/Integer;
      //   184: goto -60 -> 124
      //   187: astore 5
      //   189: goto -50 -> 139
      //
      // Exception table:
      //   from	to	target	type
      //   18	26	144	finally
      //   26	53	144	finally
      //   53	77	144	finally
      //   77	124	144	finally
      //   124	139	144	finally
      //   139	141	144	finally
      //   145	147	144	finally
      //   149	151	144	finally
      //   153	159	144	finally
      //   160	184	144	finally
      //   26	53	152	java/io/IOException
      //   77	124	187	java/lang/InterruptedException
      //   124	139	187	java/lang/InterruptedException
      //   160	184	187	java/lang/InterruptedException
    }
  }
}

/* Location:           C:\Users\hjpark\Downloads\dex2jar-0.0.9.15\dex2jar-0.0.9.15\SerialPort_1.1_dex2jar.jar
 * Qualified Name:     android_serialport_api.sample.LoopbackActivity
 * JD-Core Version:    0.6.0
 */