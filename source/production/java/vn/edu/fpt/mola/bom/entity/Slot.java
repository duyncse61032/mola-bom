package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;


/**
 * The persistent class for the slot database table.
 * 
 */
@Entity
@NamedQuery(name = "Slot.findAll", query = "SELECT s FROM Slot s")
public class Slot implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private Instant fromTime;
    private Instant toTime;
    private List<Meeting> meetingList;
    private TimeFrame timeFrame;

    public Slot()
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

    @Convert(converter = InstantConverter.class)
    public Instant getFromTime()
    {
        return this.fromTime;
    }

    public void setFromTime(Instant fromTime)
    {
        this.fromTime = fromTime;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getToTime()
    {
        return this.toTime;
    }

    public void setToTime(Instant toTime)
    {
        this.toTime = toTime;
    }

    @JsonIgnore
    // bi-directional many-to-many association to Meeting
    @ManyToMany
    @JoinTable(
            name = "register", joinColumns = {
                    @JoinColumn(name = "SlotId")
            }, inverseJoinColumns = {
                    @JoinColumn(name = "MeetingId")
            })
    public List<Meeting> getMeetingList()
    {
        return this.meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList)
    {
        this.meetingList = meetingList;
    }

    @JsonIgnore
    // bi-directional many-to-one association to TimeFrame
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TimeFrameId")
    public TimeFrame getTimeFrame()
    {
        return this.timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame)
    {
        this.timeFrame = timeFrame;
    }

}