package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the agenda database table.
 * 
 */
@Entity
@NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
public class Agenda implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private byte dailyAgenda;
    private int weeklyAgenda;
    private List<TimeFrame> timeFrameList;

    public Agenda()
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

    public byte getDailyAgenda()
    {
        return this.dailyAgenda;
    }

    public void setDailyAgenda(byte dailyAgenda)
    {
        this.dailyAgenda = dailyAgenda;
    }

    public int getWeeklyAgenda()
    {
        return this.weeklyAgenda;
    }

    public void setWeeklyAgenda(int weeklyAgenda)
    {
        this.weeklyAgenda = weeklyAgenda;
    }

    @JsonIgnore
    // bi-directional many-to-one association to TimeFrame
    @OneToMany(mappedBy = "agenda")
    public List<TimeFrame> getTimeFrameList()
    {
        return this.timeFrameList;
    }

    public void setTimeFrameList(List<TimeFrame> timeFrameList)
    {
        this.timeFrameList = timeFrameList;
    }

    public TimeFrame addTimeFrame(TimeFrame timeFrame)
    {
        getTimeFrameList().add(timeFrame);
        timeFrame.setAgenda(this);

        return timeFrame;
    }

    public TimeFrame removeTimeFrame(TimeFrame timeFrame)
    {
        getTimeFrameList().remove(timeFrame);
        timeFrame.setAgenda(null);

        return timeFrame;
    }

}