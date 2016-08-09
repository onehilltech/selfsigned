selfsigned
==========

[![Download](https://jitpack.io/v/onehilltech/selfsigned.svg)](https://jitpack.io/#onehilltech/selfsigned)
[![Build Status](https://travis-ci.org/onehilltech/selfsigned.svg)](https://travis-ci.org/onehilltech/selfsigned)
[![codecov.io](http://codecov.io/github/onehilltech/selfsigned/coverage.svg?branch=master)](http://codecov.io/github/onehilltech/selfsigned?branch=master)

A simple library for supporting self-signed certificates in Java

* Integrate with services that use **self-signed certificates**.
* **Preserve** existing security measures on the client.
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
  compile com.github.onehilltech.selfsigned:x.y.z
}
```

## Getting Started

Initialize the default hostname verifier with a set of hostnames that
you trust.

```java
SelfSigned.getDefaultHostnameVerifier ().add ("10.0.2.2");
```

### Android

* See [[android-selfsigned|https://github.com/onehilltech/android-selfsigned]]
