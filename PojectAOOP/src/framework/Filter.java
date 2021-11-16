package framework;

public interface Filter{
	/**
	 * Transform a picture
	 * @param p Picture to be transformed
	 * @return The transformed picture
	 */
	public Picture transform(Picture p);
}
