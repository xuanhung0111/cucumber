package com.zinio.config;

public enum Browser {
	  FIREFOX("firefox"), CHROME("chrome"), IE("ie"), SAFARI("safari"), MOBILE("mobile");

	  private final String browserName;

	  private Browser(final String s) {
	    browserName = s;
	  }

	  public boolean equalsName(final String otherName) {
	    return (otherName == null) ? false : browserName.equals(otherName);
	  }

	  @Override
	  public String toString() {
	    return this.browserName;
	  }
	}
