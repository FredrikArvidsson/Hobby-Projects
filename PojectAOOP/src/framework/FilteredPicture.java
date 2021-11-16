package framework;

public class FilteredPicture {
	private Picture thePicture;
	private Filter theFilter;
	
	public FilteredPicture(Picture p) {
		setPicture(p);
		theFilter = null;
	}
	public FilteredPicture(Picture p, Filter f) {
		this(p);
		setFilter(f);
	}
	
	public void setFilter(Filter f){
		if(f != null) {
			theFilter = f;
			setPicture(theFilter.transform(thePicture));
		}
	}
	public Picture getPicture() {
		return thePicture;
	}
	public void setPicture(Picture p) {
		thePicture = p;
	}
	public Filter getFilter() {
		return theFilter;
	}
}
