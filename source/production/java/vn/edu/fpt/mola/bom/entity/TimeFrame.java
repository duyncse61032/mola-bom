package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;
import vn.edu.fpt.mola.bom.entity.converter.LocalDateConverter;
import vn.edu.fpt.mola.bom.entity.converter.LocalTimeConverter;


/**
 * The persistent class for the timeframe database table.
 * 
 */
@Entity
@NamedQuery(name = "TimeFrame.findAll", query = "SELECT t FROM TimeFrame t")
public class TimeFrame implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private LocalDate endDate;
    private LocalDate startDate;
    private LocalTime fromTime;
    private LocalTime toTime;
    private Boolean dailyAgenda;
    private Integer weeklyAgenda;
    private List<Slot> slotList;
    private UserPrincipal userPrincipal;

    public TimeFrame()
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

    @Convert(converter = LocalDateConverter.class)
    public LocalDate getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate)
    {
        this.endDate = endDate;
    }

    @Convert(converter = LocalDateConverter.class)
    public LocalDate getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate)
    {
        this.startDate = startDate;
    }

    @Convert(converter = LocalTimeConverter.class)
    public LocalTime getFromTime()
    {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime)
    {
        this.fromTime = fromTime;
    }

    @Convert(converter = LocalTimeConverter.class)
    public LocalTime getToTime()
    {
        return toTime;
    }

    public void setToTime(LocalTime toTime)
    {
        this.toTime = toTime;
    }

    @Basic
    public Boolean getDailyAgenda()
    {
        return dailyAgenda;
    }

    public void setDailyAgenda(Boolean dailyAgenda)
    {
        this.dailyAgenda = dailyAgenda;
    }

    @Basic
    public Integer getWeeklyAgenda()
    {
        return weeklyAgenda;
    }

    public void setWeeklyAgenda(Integer weeklyAgenda)
    {
        this.weeklyAgenda = weeklyAgenda;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Slot
    @OneToMany(mappedBy = "timeFrame")
    public List<Slot> getSlotList()
    {
        return this.slotList;
    }

    public void setSlotList(List<Slot> slotList)
    {
        this.slotList = slotList;
    }

    public Slot addSlot(Slot slot)
    {
        getSlotList().add(slot);
        slot.setTimeFrame(this);

        return slot;
    }

    public Slot removeSlot(Slot slot)
    {
        getSlotList().remove(slot);
        slot.setTimeFrame(null);

        return slot;
    }

    @JsonIgnore
    // bi-directional many-to-one association to UserPrincipal
    @ManyToOne(fetch = FetchType.LAZY)
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