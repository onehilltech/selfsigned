android-selftrust
=================

[![Download](https://jitpack.io/v/onehilltech/android-selftrust.svg)](https://jitpack.io/#onehilltech/android-selftrust)
[![Build Status](https://travis-ci.org/onehilltech/android-selftrust.svg)](https://travis-ci.org/onehilltech/android-selftrust)
[![codecov.io](http://codecov.io/github/onehilltech/android-selftrust/coverage.svg?branch=master)](http://codecov.io/github/onehilltech/android-selftrust?branch=master)

A simple library for supporting self-signed certificates in Android

* Integrate with services that use **self-signed certificates**: 
* **Preserve** existing security measures on the mobile device
* Ideal for **prototyping and testing** using secure protocols.

**NOTE.** We strongly recommend that you purchase a certificate from a trusted authority 
when you move to production.

## Installation

#### Gradle

```
buildscript {
  repositories {
    maven { url "https://jitpack.io" }
  }
}

dependencies {
  compile com.github.onehilltech:android-selftrust:x.y.z
}
```

## Getting Started

Manually define the list of hostnames/IP addresses that are using self-signed 
certificates. It is easiest to define the list as a resource:

```xml
<resources>
    <string-array name="hostnames">
        <!-- localhost on the Android emulator -->
        <item>10.0.2.2</item>
    </string-array>
</resources>
```

Define an `Application` class to initialize the `HostnameVerifier` for
the `HttpsURLConnection`.

```java
public class TheApplication extends Application 
{
  /// Collection of HostnameVerifier objects, such as the default one 
  private final HostnameVerifiers verifiers_ = new HostnameVerifiers ();
  
  /// Simple verifier that uses a set of hostnames/IP addresses.
  private final SimpleHostnameVerifier simpleHostnameVerifier_ = new SimpleHostnameVerifier ();

  @Override
  public void onCreate ()
  {
    super.onCreate ();

    // Get default verifier. Use it and the simple one.
    HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier ();

    if (!(defaultHostnameVerifier instanceof HostnameVerifiers))
      this.initHostnameVerifiers ();

    // Load the hostnames, and add to the simple verifier.
    String [] hostnames = this.getResources ().getStringArray (R.array.hostnames);
    this.simpleHostnameVerifier_.addAll (Arrays.asList (hostnames));
  }

  private void initHostnameVerifiers ()
  {
    this.verifiers_.add (HttpsURLConnection.getDefaultHostnameVerifier ());
    this.verifiers_.add (this.simpleHostnameVerifier_);

    HttpsURLConnection.setDefaultHostnameVerifier (this.verifiers_);
  }
}
```

Make sure you add the `Application` class to `AndroidManifest.xml`.

```
    <application
        android:name="[package].TheApplication"
        
        >
        
    </application>
```