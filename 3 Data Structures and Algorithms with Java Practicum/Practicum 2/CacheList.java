/**
 * Desc: Cache List class is the Singly Linked list class that implements
 *        the caching abilities of the different level of caches.
 */
public class CacheList extends LinkedList<ContentItem> {
    private int remainingSize;  // remaining size after ContentItem objects have been added
    private final int maxSize;  // refers to the max size of the cache, currently set at 200

    public CacheList(int size) {
        super();
        this.maxSize = size;
        this.remainingSize = size;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        Node<ContentItem> curr = getHead();
        while (curr != null) {
            temp.append("[").append(curr.getData()).append("]\n");
            curr = curr.getNext();
        }
        return String.format("""
                REMAINING SPACE:%d
                ITEMS:%d
                LIST:
                %s""", this.remainingSize, getNumItems(), temp);
    }

    /**
     * Adds a node containing a ContentItem object to the beginning of the list.
     * Uses either the lru/mru eviction policy to remove items from the cache when necessary.
     *
     * @param content        - ContentItem object
     * @param evictionPolicy - Either the String "lru" or "mru". Case-insensitive
     * @return null (if successful) or an error message
     */
    public String put(ContentItem content, String evictionPolicy) {
        // YOUR CODE HERE

        //Check if size is more than max size
        if(content.getSize() > this.maxSize){
            return "ContentItem size too large for cache";
        //Check for existing node
        }else if(findNoAddToHead(content.getCid()) != null){
            return "Duplicate node";
        //Check for valid eviction policy
        }else if(!evictionPolicy.equalsIgnoreCase("lru") &&
                !evictionPolicy.equalsIgnoreCase("mru")){
            return "Invalid eviction policy";
        //Check if size is less than remaining size
        }else if(content.getSize() <= this.remainingSize){
            addToHead(content);
            this.remainingSize -= content.getSize();
            return null;
        //Use eviction policy to create space for content
        }else{
            while(content.getSize() > this.remainingSize){
                if(evictionPolicy.equalsIgnoreCase("lru")){
                    lruEvict();
                }else{
                    mruEvict();
                }
            }
            addToHead(content);
            this.remainingSize -= content.getSize();
            return null;
        }
    }

    /**
     * Searches for the ContentItem object in the cache given the content id.
     * If the item is found, it is then moved to the beginning of the list
     *
     * @param cid - ContentItem id
     * @return ContentItem object or null
     */
    public ContentItem find(int cid) {
        // YOUR CODE HERE
        //Checking for empty CacheList
        if(isEmpty()){
            return null;
        //Checking for CacheList with only 1 node
        }else if(getHead().getNext() == null) {
            if(getHead().getData().getCid() == cid) {
                return getHead().getData();
            }else{
                return null;
            }
        //Traverse CacheList and check for matches
        }else{
            Node<ContentItem> slowNode = getHead();
            Node<ContentItem> fastNode = getHead().getNext();
            //Checks first node
            if(slowNode.getData().getCid() == cid){
                return getHead().getData();
            }else{
                //Checks all nodes except first node
                while(fastNode != null) {
                    if(fastNode.getData().getCid() == cid) {
                        addToHead(fastNode.getData());
                        setNumItems(getNumItems() - 1);
                        slowNode.setNext(fastNode.getNext());
                        return getHead().getData();
                    }else{
                        slowNode = slowNode.getNext();
                        fastNode = fastNode.getNext();
                    }
                }
                return null;
            }
        }
    }

    /**
     * Searches for the ContentItem object in the cache given the content id.
     * If the item is found, it is not moved to the beginning of the list
     *
     * @param cid - ContentItem id
     * @return ContentItem object or null
     */
    public ContentItem findNoAddToHead(int cid){
        // YOUR CODE HERE
        //Checking for empty CacheList
        if(isEmpty()) {
            return null;
        //Traverse CacheList and check for matches
        }else{
            Node<ContentItem> currNode = getHead();
            while(currNode != null) {
                if(currNode.getData().getCid() == cid) {
                    return currNode.getData();
                }else{
                    currNode = currNode.getNext();
                }
            }
            return null;
        }
    }

    /**
     * Updates the content of the ContentItem object (if it is found). Node is then moved to the
     * beginning of the list.
     *
     * @param cid - ContentItem id
     * @param content - New ContentItem object for updating the old object
     * @return true if updated, null otherwise
     */
    public Boolean update (int cid, ContentItem content){
        // YOUR CODE HERE
        //Find matching cid and update content
        if (find(cid) != null) {
            getHead().setData(content);
            return true;
        } else {
            return null;
        }
    }

    /**
     * Removes the first item of the list
     */
    public void mruEvict () {
        // YOUR CODE HERE
        this.remainingSize += removeFromHead().getSize();
    }

    /**
     * Removes the last item of the list
     */
    public void lruEvict () {
        // YOUR CODE HERE
        this.remainingSize += removeFromTail().getSize();
    }

    /**
     * Removes all items from the list
     */
    public void clear () {
        // YOUR CODE HERE
        setHead(null);
        setNumItems(0);
        this.remainingSize = this.maxSize;
    }
}

