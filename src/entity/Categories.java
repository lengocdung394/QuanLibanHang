package entity;

import java.util.Objects;

public class Categories {
	
	private String categoryID;
	private String categoryName;
	private String description;
	public Categories() {
		super();
	}
	public Categories(String categoryID) {
		super();
		this.categoryID = categoryID;
	}
	public Categories(String categoryID, String categoryName, String description) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.description = description;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		return Objects.equals(categoryID, other.categoryID);
	}
	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", categoryName=" + categoryName + ", description="
				+ description + "]";
	}
	
}
