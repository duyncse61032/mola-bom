package vn.edu.fpt.mola.bom.entity.view;

import java.time.Instant;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import vn.edu.fpt.mola.bom.entity.Gender;
import vn.edu.fpt.mola.bom.entity.MolaRole;


@XmlRootElement(name = "user")
public class MolaUserForm
{
    @NotNull(message = "{validate.user.name}")
    private String name;
    private Gender gender;
    private Instant birthday;
    @NotNull(message = "{validate.user.email}")
    private String email;
    private String telNo;
    @NotNull(message = "{validate.user.role}")
    private MolaRole role;
    private String street;
    private String district;
    private String city;
    private String state;
    private String country;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Instant getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Instant birthday)
    {
        this.birthday = birthday;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelNo()
    {
        return telNo;
    }

    public void setTelNo(String telNo)
    {
        this.telNo = telNo;
    }

    public MolaRole getRole()
    {
        return role;
    }

    public void setRole(MolaRole role)
    {
        this.role = role;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}
