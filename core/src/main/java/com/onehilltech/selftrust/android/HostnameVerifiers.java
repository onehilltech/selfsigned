package com.onehilltech.selftrust.android;

import java.util.HashSet;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class HostnameVerifiers implements HostnameVerifier
{
  private HashSet <HostnameVerifier> verifiers_ = new HashSet<> ();

  public HostnameVerifiers ()
  {

  }

  public boolean add (HostnameVerifier verifier)
  {
    return this.verifiers_.add (verifier);
  }

  public boolean remove (HostnameVerifier verifier)
  {
    return this.verifiers_.remove (verifier);
  }

  @Override
  public boolean verify (String hostname, SSLSession session)
  {
    for (HostnameVerifier verifier : this.verifiers_)
      if (verifier.verify (hostname, session))
        return true;

    return false;
  }
}
