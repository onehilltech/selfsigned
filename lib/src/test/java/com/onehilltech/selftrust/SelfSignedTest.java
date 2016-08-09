package com.onehilltech.selftrust;

import com.onehilltech.selfsigned.DefaultHostnameVerifier;
import com.onehilltech.selfsigned.SelfSigned;

import junit.framework.Assert;

import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;

public class SelfSignedTest
{
  @Test
  public void testInitDefaultHostnameVerifier ()
  {
    DefaultHostnameVerifier verify = SelfSigned.getDefaultHostnameVerifier ();
    Assert.assertSame (verify, HttpsURLConnection.getDefaultHostnameVerifier ());
  }
}
