package com.onehilltech.selfsigned;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class DefaultHostnameVerifier extends SimpleHostnameVerifier
{
  private final HostnameVerifier default_;

  DefaultHostnameVerifier (HostnameVerifier defaultHostnameVerifier)
  {
    this.default_ = defaultHostnameVerifier;
  }

  @Override
  public boolean verify (String hostname, SSLSession session)
  {
    return this.default_.verify (hostname, session) || super.verify (hostname, session);
  }
}
