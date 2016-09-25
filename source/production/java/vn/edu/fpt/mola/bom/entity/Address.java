package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String userId;
    private String buildingNumber;
    private String country;
    private String name;
    private String state;
    private String street;
    private String town;
    private UserPrincipal userPrincipal;

    public Address()
    {
    }

    @Id
    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getBuildingNumber()
    {
        return this.buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber)
    {
        this.buildingNumber = buildingNumber;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getTown()
    {
        return this.town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    @JsonIgnore
    // bi-directional one-to-one association to UserPrincipal
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    public UserPrincipal getUserPrincipal()
    {
        return this.userPrincipal;
    }

    public void setUserPrincipal(UserPrincipal userPrincipal)
    {
        this.userPrincipal = userPrincipal;
    }

}