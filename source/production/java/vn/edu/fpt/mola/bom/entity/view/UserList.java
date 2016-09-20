package vn.edu.fpt.mola.bom.entity.view;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import vn.edu.fpt.mola.bom.entity.UserPrincipal;


@XmlRootElement(name = "users")
public class UserList
{
    private List<UserPrincipal> users;

    @XmlElement(name = "user")
    public List<UserPrincipal> getList()
    {
        return users;
    }

    public void setList(List<UserPrincipal> list)
    {
        this.users = list;
    }

}
