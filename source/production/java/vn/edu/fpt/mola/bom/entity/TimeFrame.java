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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vn.edu.fpt.mola.bom.entity.converter.InstantConverter;


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
    private Instant endDate;
    private Instant startDate;
    private List<Slot> slotList;
    private Agenda agenda;
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

    @Convert(converter = InstantConverter.class)
    public Instant getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Instant endDate)
    {
        this.endDate = endDate;
    }

    @Convert(converter = InstantConverter.class)
    public Instant getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(Instant startDate)
    {
        this.startDate = startDate;
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

    // bi-directional many-to-one association to Agenda
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AgendaId")
    public Agenda getAgenda()
    {
        return this.agenda;
    }

    public void setAgenda(Agenda agenda)
    {
        this.agenda = agenda;
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