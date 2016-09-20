package vn.edu.fpt.mola.bom.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address
{
    private long userId;
    private String name;
    private String buildingNumber;
    private String street;
    private String town;
    private String state;
    private String country;
    private UserPrincipal user;

    @Id
    public long getUserId()
    {
        return userId;
    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    @Basic
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    public String getBuildingNumber()
    {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber)
    {
        this.buildingNumber = buildingNumber;
    }

    @Basic
    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    @Basic
    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    @Basic
    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Basic
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @XmlTransient
    @JsonIgnore
    //bi-directional one-to-one association to UserPrincipal
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="UserId")
    public UserPrincipal getUser()
    {
        return user;
    }

    public void setUser(UserPrincipal user)
    {
        this.user = user;
    }

}
