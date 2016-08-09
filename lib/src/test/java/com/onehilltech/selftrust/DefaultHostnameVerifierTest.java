package com.onehilltech.selftrust;

import com.onehilltech.selfsigned.SelfSigned;

import org.junit.Assert;
import org.junit.Test;

public class DefaultHostnameVerifierTest
{
  @Test
  public void testVerify () throws Exception
  {
    SelfSigned.getDefaultHostnameVerifier ().add ("10.0.2.2");
    Assert.assertTrue (SelfSigned.getDefaultHostnameVerifier ().verify ("10.0.2.2", null));
  }
}
