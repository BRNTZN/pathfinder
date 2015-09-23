package beans;

import java.io.Serializable;

public class Tyle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String radioelement, divelement, breakelement, beginelement, endelement, routeelement, name, id;
	private int x,y;
	
	public Tyle(){
		
	}
	
	public Tyle(int x, int y){
		this.x = x;
		this.y = y;
		this.name=x+"name"+y;
		this.id=x+"//"+y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getRouteelement() {
		return routeelement;
	}

	public void setRouteelement(String routeelement) {
		this.routeelement = routeelement;
	}

	public String getBeginelement() {
		return beginelement;
	}

	public void setBeginelement(String beginelement) {
		this.beginelement = beginelement;
	}

	public String getEndelement() {
		return endelement;
	}

	public void setEndelement(String endelement) {
		this.endelement = endelement;
	}

	public String getRadioelement() {
		return radioelement;
	}

	public void setRadioelement(String radioelement) {
		this.radioelement = radioelement;
	}

	public String getDivelement() {
		return divelement;
	}

	public void setDivelement(String divelement) {
		this.divelement = divelement;
	}

	public String getBreakelement() {
		return breakelement;
	}

	public void setBreakelement(String breakelement) {
		this.breakelement = breakelement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tyle other = (Tyle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tyle [radioelement=" + radioelement + ", divelement=" + divelement + ", breakelement=" + breakelement
				+ ", beginelement=" + beginelement + ", endelement=" + endelement + ", routeelement=" + routeelement
				+ ", name=" + name + ", id=" + id + ", x=" + x + ", y=" + y + "]";
	}



}
