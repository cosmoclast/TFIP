/**
 * Desc: Cache class that simulates the different levels of caches.
 */

import java.nio.charset.StandardCharsets;

public class Cache {
    private CacheList[] caches;
    private final int numCaches;

    /**
     * Constructor to initialise the numCaches with minimum 2 levels of cache,
     * initialise CacheList[] and create new CacheLists.
     *
     * @param numCaches number of levels of cache
     */

    // Constructor ------------------------
    // YOUR CODE HERE
    public Cache(int numCaches) {
        this.numCaches = Integer.max(2, numCaches);
        this.caches = new CacheList[this.numCaches];
        for(int i = 0; i < this.numCaches; i++){
            this.caches[i] = new CacheList(200);
        }
    }

    /**
     * Constructor to initialise the numCaches with default 3 levels of cache,
     * initialise CacheList[] and create new CacheLists.
     */
    //this code is not finished, make sure you take care of default 3 caches and other caches the user can input.
    public Cache(){
        this.numCaches = 3;
        this.caches = new CacheList[this.numCaches];
        for(int i = 0; i < this.numCaches; i++){
            this.caches[i] = new CacheList(200);
        }
    }

    public CacheList[] getCaches() {
        return this.caches;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i=0; i<this.numCaches; i++)
            temp.append("L").append(i+1).append(" CACHE: ")
                    .append(System.getProperty("line.separator")).append(caches[i])
                    .append(System.getProperty("line.separator"));
        return temp.toString();
    }

    /**
     * Clears all the caches of data
     * @return String message "Cache cleared!"
     */
    public String clear() {
        // YOUR CODE HERE
        for(CacheList currCacheList : caches){
            currCacheList.clear();
        }
        return "Cache cleared!";
    }

    /**
     * Calculates the hash from the content header. The hash formula to use is:
     * summing the ASCII value of each letter in the content header then modulus it by
     * the number of caches created
     * @param contentHeader - ContentItem object header
     * @return the index of the cache level
     */
    private int hashFunction(String contentHeader) {
        // YOUR CODE HERE
        int count = 0;

        for(int i = 0; i < contentHeader.length(); i++)
            count += contentHeader.charAt(i);

        return count % this.numCaches;
    }

    /**
     * Adds a ContentItem object into the cache, along with the eviction policy.
     * Use either 'lru' or 'mru' to refer to the eviction policy
     * @param content - ContentItem object
     * @param evictionPolicy - Either the String "lru" or "mru". Case-insensitive
     * @return String message on the status of the insert.
     */
    public String insert(ContentItem content, String evictionPolicy) {
        // YOUR CODE HERE
        String result = null;

        //Validation of ContentItem
        if(validateContentItem(content)){
            result = this.caches[hashFunction(content.getHeader())].put(content, evictionPolicy);
        }else{
            return "Invalid content item";
        }

        if(result == null) // YOUR CODE HERE
            return String.format("INSERTED: %s", content);
        else
            return result;
    }

    /**
     * Gets the content from the ContentItem object from the cache (if any)
     * @param content - ContentItem object
     * @return Object that can be either a ContentItem object or the String "Cache miss"
     */
    public Object retrieveContent(ContentItem content) {
        // YOUR CODE HERE
        ContentItem currContent = null;

        //Validation of ContentItem
        if(validateContentItem(content)){
            currContent = this.caches[hashFunction(content.getHeader())].find(content.getCid());
        }else{
            return "Invalid content item";
        }

        if(currContent != null)// YOUR CODE HERE
            return content;
        else
            return "Cache miss";
    }

    /**
     * Updates ONLY the ContentItem object's content from the cache (if any).
     * Do not update any other attributes in the object other than the content attribute.
     * @param content - ContentItem object
     * @return String message on the status of the update.
     */
    public String updateContent(ContentItem content) {
        // YOUR CODE HERE
        Boolean contentUpdated = null;

        //Validation of ContentItem
        if(validateContentItem(content)){
            contentUpdated = this.caches[hashFunction(content.getHeader())].update(content.getCid(), content);
        }else{
            return "Invalid content item";
        }

        if(contentUpdated != null) // YOUR CODE HERE
            return String.format("UPDATED: %s", content);
        else
            return "Cache miss";
    }

    /**
     * Checks for negative cid values, 0 or negative size values, null headers and null contents
     *
     * @param content - ContentItem object
     * @return true if ContentItem has valid contents, false if invalid
     */
    public boolean validateContentItem(ContentItem content){
        if(content.getCid() < 0){
            return false;
        }else if(content.getSize() <= 0){
            return false;
        }else if(content.getHeader() == null){
            return false;
        }else if(content.getContent() == null) {
            return false;
        }else {
            return true;
        }
    }
}
