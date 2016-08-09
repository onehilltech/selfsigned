package com.onehilltech.selftrust;

import com.onehilltech.selfsigned.SimpleHostnameVerifier;

import org.junit.Test;
import org.junit.Assert;

public class SimpleHostnameVerifierTest
{
  @Test
  public void testVerify ()
  {
    SimpleHostnameVerifier verifier = new SimpleHostnameVerifier ();
    verifier.add ("1.2.3.4");

    Assert.assertTrue (verifier.verify ("1.2.3.4", null));
    Assert.assertFalse (verifier.verify ("4.3.2.1", null));
  }
}
