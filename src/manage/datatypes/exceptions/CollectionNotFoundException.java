package manage.datatypes.exceptions;

/**
 * Exception which is thrown when collection with a name could be found.
 * 
 * @author J Blackmore
 */
public class CollectionNotFoundException extends DataObjectNotFoundException {

    /**
     * Creates a CollectionNotFoundException where the message is the collection name.
     * 
     * @param collectionName message of the exception, the collection name.
     */
    public CollectionNotFoundException(String collectionName) {
        super(collectionName);
    }
}