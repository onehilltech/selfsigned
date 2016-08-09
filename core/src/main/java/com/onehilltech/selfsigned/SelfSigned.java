package com.onehilltech.selfsigned;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class SelfSigned
{
  static private DefaultHostnameVerifier defaultHostnameVerifier_;

  public static DefaultHostnameVerifier getDefaultHostnameVerifier ()
  {
    if (defaultHostnameVerifier_ != null)
      return defaultHostnameVerifier_;

    initDefaultHostnameVerifier ();
    return defaultHostnameVerifier_;
  }

  private static void initDefaultHostnameVerifier ()
  {
    HostnameVerifier currentDefault = HttpsURLConnection.getDefaultHostnameVerifier ();

    if ((currentDefault instanceof DefaultHostnameVerifier))
    {
      defaultHostnameVerifier_ = (DefaultHostnameVerifier) currentDefault;
    }
    else
    {
      defaultHostnameVerifier_ = new DefaultHostnameVerifier (currentDefault);
      HttpsURLConnection.setDefaultHostnameVerifier (defaultHostnameVerifier_);
    }
  }

  private SelfSigned ()
  {

  }
}
