/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellisoft.intellibusinessws.entities.system;


import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

@SuppressWarnings("serial")
public class Configuration extends Entity {

	@KeyField
	private Long id;
	private String alias;
	private String name;
	private String value;

	public Configuration() {
	}

	public Configuration(Long id) {
		this.id = id;
	}

	public Configuration(String alias, String name, String value) {
		this.alias = alias;
		this.name = name;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SystemConfiguration{" + "id=" + id + ", alias=" + alias + ", name=" + name + ", value=" + value + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Configuration other = (Configuration) obj;
		if (this.id == null || !this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash = 19 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

}
