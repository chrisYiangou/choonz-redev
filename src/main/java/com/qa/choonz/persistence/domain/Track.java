package com.qa.choonz.persistence.domain;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Album album;

    @OneToOne() // cascade = CascadeType.REMOVE)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "fk_artist_id")
    private Artist artist;

    // in seconds
    private Integer duration;

    private String lyrics;

    public Track() {
        super();
    }

    public Track(int id, @NotNull @Size(max = 100) String name, Album album, Integer duration, String lyrics) {
        super();
        this.id = id;
        this.name = name;
        this.album = album;
        this.duration = duration;
        this.lyrics = lyrics;
    }
    
    public Track(int id, @NotNull @Size(max = 100) String name, Integer duration, String lyrics) {
    	super();
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.lyrics = lyrics;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Track [id=").append(id).append(", name=").append(name).append(", album=").append(album)
                .append(", duration=").append(duration).append(", lyrics=").append(lyrics).append(", artist=")
                .append(artist).append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, album, duration, lyrics, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return Objects.equals(album, other.album) && Objects.equals(duration, other.duration )&&  Objects.equals(lyrics, other.lyrics) && Objects.equals(name, other.name)
                && Objects.equals(artist, other.artist);
    }

}
