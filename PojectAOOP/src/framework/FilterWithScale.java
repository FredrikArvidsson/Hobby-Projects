package framework;

public interface FilterWithScale extends Filter{
	/**
	 * 
	 * @param x preferably between 0-10 to change the amount applied in the
	 *  filters algorithm
	 */
	public void change(int x);
}
