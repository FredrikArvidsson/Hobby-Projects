package framework;

import java.util.ArrayList;

public class DefaultFilters extends AdditionalFilters{

	@Override
	public ArrayList<Filter> getAdditionalFilters() {
		ArrayList<Filter> filters = new ArrayList<Filter>();
		
		filters.add(new Swirl());
		filters.add(new Grayscale());
		filters.add(new FlipX());
		filters.add(new Redscale());
		filters.add(new VerticalStripes());
		filters.add(new Chessboard());
		filters.add(new BlackCircle());
		
		return filters;
	}

}
