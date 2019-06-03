package com.hva.tradeforgoals.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "middle_name")
    private String middleName;

	@Column(name = "last_name")
    private String lastName;
	
    @Column(name = "display_name")
    private String displayName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "zipcode")
    private String zipCode;
    
    @Column(name = "housenumber")
    private String houseNumber;
    
    @Column(name = "photo_url")
    private String photoUrl;
    
    @Column(name = "providerid")
    private String providerId;

    @OneToMany(mappedBy = "customer")
    private Set<Product> products;
    
//
//    @OneToMany(mappedBy = "customer")
//    private Set<Advertisement> advertisements;

    public Customer() {

    }
    
    public Customer(String firstname, String lastname, String email, String zipcode, String housenumber, String id) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.zipCode = zipcode;
        this.houseNumber = housenumber;
        this.id = id;
        this.products = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getMiddlename() {
		return middleName;
	}

	public void setMiddlename(String middlename) {
		this.middleName = middlename;
	}
	
    public String getDisplayname() {
		return displayName;
	}

	public void setDisplayname(String displayname) {
		this.displayName = displayname;
	}

	public String getPhonenumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phoneNumber = phonenumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipcode) {
        this.zipCode = zipcode;
    }

    public String getHousenumber() {
        return houseNumber;
    }

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHousenumber(String housenumber) {
        this.houseNumber = housenumber;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
//
//    public Set<Advertisement> getAdvertisements() {
//        return advertisements;
//    }
//
//    public void setAdvertisements(Set<Advertisement> advertisements) {
//        this.advertisements = advertisements;
//    }
}

