package com.onehilltech.selfsigned;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @class SimpleHostnameVerifier
 *
 * Implementation of HostnameVerifier that built atop a list of trusted hostnames
 * and/or IP addresses.
 */
public class SimpleHostnameVerifier
    implements HostnameVerifier, Set <String>
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
  @Override
  public boolean add (String hostname)
  {
    return this.hostnames_.add (hostname);
  }


  @Override
  public boolean addAll (Collection<? extends String> collection)
  {
    return this.hostnames_.addAll (collection);
  }

  @Override
  public void clear ()
  {
    this.hostnames_.clear ();
  }

  @Override
  public boolean contains (Object object)
  {
    return this.hostnames_.contains (object);
  }

  @Override
  public boolean containsAll (Collection<?> collection)
  {
    return this.hostnames_.containsAll (collection);
  }

  @Override
  public boolean isEmpty ()
  {
    return this.hostnames_.isEmpty ();
  }

  @Override
  public Iterator<String> iterator ()
  {
    return this.hostnames_.iterator ();
  }

  @Override
  public boolean remove (Object object)
  {
    return this.hostnames_.remove (object);
  }

  @Override
  public boolean removeAll (Collection<?> collection)
  {
    return this.hostnames_.removeAll (collection);
  }

  @Override
  public boolean retainAll (Collection<?> collection)
  {
    return this.hostnames_.retainAll (collection);
  }

  @Override
  public int size ()
  {
    return this.hostnames_.size ();
  }

  @Override
  public Object[] toArray ()
  {
    return this.hostnames_.toArray ();
  }

  @Override
  public <T> T[] toArray (T[] array)
  {
    return this.hostnames_.toArray (array);
  }
}
