package vn.edu.fpt.mola.bom.entity;

import java.io.Serializable;
import java.util.List;

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


/**
 * The persistent class for the lesson database table.
 * 
 */
@Entity
@NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")
public class Lesson implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long id;
    private String description;
    private int duration;
    private String title;
    private Chapter chapter;
    private List<Meeting> meetingList;
    private List<Rank> rankList;

    public Lesson()
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

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getDuration()
    {
        return this.duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
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
    // bi-directional many-to-one association to Chapter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChapterId")
    public Chapter getChapter()
    {
        return this.chapter;
    }

    public void setChapter(Chapter chapter)
    {
        this.chapter = chapter;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Meeting
    @OneToMany(mappedBy = "lesson")
    public List<Meeting> getMeetingList()
    {
        return this.meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList)
    {
        this.meetingList = meetingList;
    }

    public Meeting addMeeting(Meeting meeting)
    {
        getMeetingList().add(meeting);
        meeting.setLesson(this);

        return meeting;
    }

    public Meeting removeMeeting(Meeting meeting)
    {
        getMeetingList().remove(meeting);
        meeting.setLesson(null);

        return meeting;
    }

    @JsonIgnore
    // bi-directional many-to-one association to Rank
    @OneToMany(mappedBy = "lesson")
    public List<Rank> getRankList()
    {
        return this.rankList;
    }

    public void setRankList(List<Rank> rankList)
    {
        this.rankList = rankList;
    }

    public Rank addRank(Rank rank)
    {
        getRankList().add(rank);
        rank.setLesson(this);

        return rank;
    }

    public Rank removeRank(Rank rank)
    {
        getRankList().remove(rank);
        rank.setLesson(null);

        return rank;
    }

}