package com.knightonline.shared.persistence.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.knightonline.shared.data.constants.NamedQueriesConstants;

/**
 * @author Mamaorha
 *
 */
@javax.persistence.Entity()
@Table(name = "APPLICATION_PROPERTIES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({ @NamedQuery(name = NamedQueriesConstants.GET_APPLICATION_PROPERTIES, query = "from ApplicationProperties") })
public class ApplicationProperties implements Serializable
{
	private static final long serialVersionUID = -4716781085067787064L;

	private String key;
	private String value;

	@Id()
	@Basic()
	@Column(name = "KEY", nullable = false, length = 50)
	public String getKey()
	{
		return this.key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	@Basic()
	@Column(name = "VALUE", nullable = false, length = 500)
	public String getValue()
	{
		return this.value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationProperties other = (ApplicationProperties) obj;
		if (key == null)
		{
			if (other.key != null)
				return false;
		}
		else if (!key.equals(other.key))
			return false;
		if (value == null)
		{
			if (other.value != null)
				return false;
		}
		else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ApplicationProperties [key=" + key + ", value=" + value + "]";
	}
}
