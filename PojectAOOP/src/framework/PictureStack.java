package framework;

import java.util.ArrayList;

public class PictureStack{
	private ArrayList <Picture> pictures;
	
	/** Constructor, creates an empty stack. 
	 * @invariant size()>= 0
	 */
	public PictureStack() {
		pictures = new ArrayList<Picture>();
	}
	/** add picture to the stack
	 * @postcondition size()>0
	 * @param p the picture that is added to the stack
	 */
	public void push(Picture p) {
		pictures.add(p);
	}
	
	/** 
	 * @precondition  size()>0 
	 * @return removed picture
	 * @throws IndexOutOfBoundsException
	 */
	public Picture pop() throws IndexOutOfBoundsException{
		if(pictures.size() == 0)
			throw new IndexOutOfBoundsException("Empty Stack");
		else
			return pictures.remove(pictures.size()-1);
	}
	
	/**
	 * @precondition size()>0
	 * @return picture that is top of stack 
	 * @throws IndexOutOfBoundsException
	 */
	public Picture peek() throws IndexOutOfBoundsException{
		if(pictures.size() == 0)
			throw new IndexOutOfBoundsException("Empty Stack");
		else
			return pictures.get(pictures.size()-1);
	}
	
	/**
	 * 
	 * @return size of stack
	 */
	public int size() {
		return pictures.size();
	}
	
}

