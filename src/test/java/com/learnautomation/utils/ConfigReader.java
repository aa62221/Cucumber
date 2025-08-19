package com.learnautomation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

  private static final Properties PROPERTIES = new Properties();
  private static final Object LOCK = new Object();
  private static volatile boolean initialized = false;

  private ConfigReader() {}

  private static void ensureInitialized() {
    if (initialized) return;
    synchronized (LOCK) {
      if (initialized) return;
      try (InputStream inputStream = ConfigReader.class.getClassLoader()
          .getResourceAsStream("config.properties")) {
        if (inputStream != null) {
          PROPERTIES.load(inputStream);
        } else {
          throw new IllegalStateException("config.properties not found on classpath");
        }
      } catch (IOException e) {
        throw new RuntimeException("Failed to load config.properties", e);
      }
      initialized = true;
    }
  }

  public static String getProperty(String key, String defaultValue) {
    ensureInitialized();
    return PROPERTIES.getProperty(key, defaultValue);
  }

  public static boolean getBooleanProperty(String key, boolean defaultValue) {
    ensureInitialized();
    String value = PROPERTIES.getProperty(key);
    return value == null ? defaultValue : Boolean.parseBoolean(value.trim());
  }

  public static int getIntProperty(String key, int defaultValue) {
    ensureInitialized();
    String value = PROPERTIES.getProperty(key);
    try {
      return value == null ? defaultValue : Integer.parseInt(value.trim());
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }
}


