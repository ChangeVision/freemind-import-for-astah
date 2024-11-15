package com.github.astah.mm2asta.usericon;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder={ "name", "userIcons" })
public class MmUserIconInfo {
	@XmlElement
	private String name = "jude.usericons";
	
	@XmlElement(name="userIcon")
	private List<UserIcon> userIcons;
	
	public MmUserIconInfo() {
		userIcons = new ArrayList<UserIcon>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserIcon> getUserIcons() {
		if (userIcons == null) {
			return new ArrayList<UserIcon>();
		}
		return userIcons;
	}

	public void setUserIcons(List<UserIcon> userIcons) {
		this.userIcons = userIcons;
	}
}