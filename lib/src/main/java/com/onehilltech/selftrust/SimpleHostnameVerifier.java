package com.onehilltech.selftrust;

import java.util.Collection;
import java.util.HashSet;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class SimpleHostnameVerifier implements HostnameVerifier
{
  /// Collection of host names we accept.
  private final HashSet <String> hostnames_ = new HashSet<> ();

  /**
   * Default constructor.
   */
  public SimpleHostnameVerifier ()
  {

  }

  /**
   * Initializing constructor.
   *
   * @param hostnames         Collection of hostnames
   */
  public SimpleHostnameVerifier (Collection <String> hostnames)
  {
    this.hostnames_.addAll (hostnames);
  }

  @Override
  public boolean verify (String hostname, SSLSession session)
  {
    return this.hostnames_.contains (hostname);
  }

  /**
   * Add a new hostname of the verifier.
   *
   * @param hostname
   * @return
   */
  public boolean add (String hostname)
  {
    return this.hostnames_.add (hostname);
  }

  /**
   * Remove a hostname from the verifier.
   *
   * @param hostname
   * @return
   */
  public boolean remove (String hostname)
  {
    return this.hostnames_.remove (hostname);
  }
}
