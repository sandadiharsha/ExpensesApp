package com.har.ui.model;

import java.util.HashSet;
import java.util.Set;

public class EntityBean {
	private String name;
	private String displayName;
	private Set<AttributeBean> attributes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Set<AttributeBean> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<AttributeBean> attributes) {
		this.attributes = attributes;
	}

	public void addAttributes(AttributeBean attributeBean) {
		if (attributes == null)
			attributes = new HashSet<AttributeBean>();
		attributes.add(attributeBean);
	}
}
