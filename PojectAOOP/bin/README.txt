README FOR DEVELOPERS
How to create a function for a PictureEditorFAO
1. Create a class that extends Fuction from the framework.
2. Implement the abstract method whatToDo()
3. Add the Function to your PictureEditorFAO with the method addFuction(Function)

How to create a Filter
1. Create class that implements the interface Filter or FilterWithScale
2. Implement the required method(s).

README FOR USERS
How to create and start a PictureEditorFAO with custom made filters.
1. Create classes that implements the interface Filter or FilterWithScale
2. Implement the required method(s).
3. Create class that extends AdditionalFilters and implement the method getAdditionalFilters()
4. Create a class with a main method
5. Construct your PictureEditorFAO, use an instance of the class you made in step 4 as a parameter in the constructor.
5. setVisable(true) for the PictureEditorFAO

How to create and start a default PictureEditorFAO.
1. Create a class with a main method. 
2. Construct an instance of PictureEditorFAO with no parameters.
3. setVisable(true) for the PictureEditorFAO