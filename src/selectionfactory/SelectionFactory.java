package selectionfactory;

import exception.DataEmptyException;

/**
 * Created by Admin on 4/21/2017.
 */
public interface SelectionFactory {

    public String search(Object searchCriteria) throws DataEmptyException;
}
