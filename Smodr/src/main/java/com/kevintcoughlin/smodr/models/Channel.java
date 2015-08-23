package com.kevintcoughlin.smodr.models;

import org.parceler.Parcel;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Model representing an RSS feed's channel.
 *
 * @author kevincoughlin
 */
@Parcel
@Root(name = "channel", strict = false)
public final class Channel {
	private String shortName;

    @Element(name = "title", required = false)
    private String title;

    @Element(name = "description", required = false)
    private String description;

    @ElementList(name = "item", required = false, inline = true)
    private ArrayList<Item> items = new ArrayList<>();

	@Element(name = "pubDate", required = false)
	private String pubDate;

	@ElementList(name = "image", required = false, inline = true)
	private List<Image> image = new ArrayList<>();

	public Channel() {
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

	public List<Image> getImages() {
		return image;
	}

	public void setImages(List<Image> image) {
		this.image = image;
	}
}