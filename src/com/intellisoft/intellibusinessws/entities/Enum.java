package com.intellisoft.intellibusinessws.entities;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Enum implements Serializable {
	private String name;
	private int value;

	public Enum(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Enum other = (Enum) obj;
		if (this.value == 0 || !(this.value == other.value)) {
			return false;
		}
		return true;
	}

}