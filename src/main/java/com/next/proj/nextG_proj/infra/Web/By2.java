package com.next.proj.nextG_proj.infra.Web;

import org.openqa.selenium.By;

public class By2 {

	public By by;
	public String description;
	
	public By2 (String description, By by) {
		this.by = by;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description + " (" + by + ")";
	}
}
