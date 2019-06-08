package com.next.proj.nextG_proj.infra.entities;

public class SearchItem {

	public String searchTerm;
	public int itemIndex;
	public String expectedResult;
	
	public SearchItem(String searchterm, int itemIndex, String expectedResult) {
		this.searchTerm = searchterm;
		this.itemIndex = itemIndex;
		this.expectedResult = expectedResult;
	}
	
	public String toString() {
		return "Search item: " + searchTerm + "; Check index: " + itemIndex + "; Expected result: " + expectedResult;
	}
	
}
