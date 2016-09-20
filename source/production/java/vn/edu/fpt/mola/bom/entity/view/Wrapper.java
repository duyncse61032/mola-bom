package vn.edu.fpt.mola.bom.entity.view;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Wrapper<T>
{

    private List<T> data;

    public Wrapper()
    {
        data = new ArrayList<T>();
    }

    public Wrapper(List<T> items)
    {
        this.data = items;
    }

    @XmlAnyElement
    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

}