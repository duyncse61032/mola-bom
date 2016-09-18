package vn.edu.fpt.mola.bom.entity.view;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import vn.edu.fpt.mola.bom.entity.MolaUser;


@XmlRootElement(name = "users")
public class MolaUserList
{
    private List<MolaUser> list;

    @XmlElement(name = "user")
    public List<MolaUser> getList()
    {
        return list;
    }

    public void setList(List<MolaUser> list)
    {
        this.list = list;
    }

}
