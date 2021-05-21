package com.zinio.config;

public class CreditCard {

	private final String firstName;
	private final String lastName;
	private final String creditCardNumber;
	private final String cvv;
	private final String expirationYear;
	private final String expirationMonth;
	private final String address;
	private final String city;
	private final String zipCode;
	private final String country;
	public static  String hung;

	  /**
	   * Class constructor
	   * 
	   * @param creditCardNumber
	   *          User credit card number
	   * @param cvv
	   *          Card verification value
	   * @param expirationYear
	   *          Year of card expiration
	   * @param expirationMonth
	   *          Month of card expiration
	   */
	  public CreditCard(final String firstName, final String lastName, final String creditCardNumber, final String cvv, final String expirationYear,
	      final String expirationMonth, final String address, final String city, final String zipCode, final String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.creditCardNumber = creditCardNumber;
		this.cvv = cvv;
		this.expirationYear = expirationYear;
		this.expirationMonth = expirationMonth;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	  }

	  public String getFirstName() {
		    return this.firstName;
	  }
	  
	  public String getLaseName() {
		    return this.lastName;
	  }
	  
	  public String getCreditCardNumber() {
	    return this.creditCardNumber;
	  }

	  public String getCvv() {
	    return this.cvv;
	  }

	  public String getExpirationYear() {
	    return this.expirationYear;
	  }

	  public String getExpirationMonth() {
	    return this.expirationMonth;
	  }
	  
	  public String getAddress() {
		    return this.address;
	 }
	  
	  public String getCity() {
		    return this.city;
	  }
	  
	  public String getZipCode() {
		    return this.zipCode;
	  }
	  
	  public String getCountry() {
		    return this.country;
	  }
}
