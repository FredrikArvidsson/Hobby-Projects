package application;



import java.util.ArrayList;

import framework.AdditionalFilters;
import framework.Filter;



public class MyFilters extends AdditionalFilters {
	public ArrayList<Filter> getAdditionalFilters(){
		ArrayList<Filter> ret = new ArrayList<Filter>();
		Filter flipY = new FlipY();
		Filter test = new test();
		Filter gs = new Greenscale();
		Filter bri = new Brighter();
		Filter asd = new ACircle();
		Filter dark= new Ahmad();
		ret.add(flipY);
		ret.add(gs);
		ret.add(bri);
		ret.add(asd);
		ret.add(dark);
		ret.add(test);
		
		
		return ret;
		
	}
}
