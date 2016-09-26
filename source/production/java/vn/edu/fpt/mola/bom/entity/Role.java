package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private String title;
    private List<UserPrincipal> userList;

    public Role()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @JsonIgnore
    // bi-directional many-to-many association to UserPrincipal
    @ManyToMany(mappedBy = "roleList")
    public List<UserPrincipal> getUserList()
    {
        return this.userList;
    }

    public void setUserList(List<UserPrincipal> userList)
    {
        this.userList = userList;
    }

}