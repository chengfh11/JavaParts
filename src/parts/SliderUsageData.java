package junk;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class SliderUsageData {

	private String date;
	private String usage;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	@Override
	public boolean equals(Object o) {
		return new EqualsBuilder().append(getDate(), ((SliderUsageData)o).getDate()).isEquals();
	}
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getDate()).toHashCode();
	}
	@Override
	public String toString(){
		return "Date: "+getDate()+" Usage: "+getUsage();
	}
	
}
