/**
 * 
 */
package org.jivesoftware.wildfire.gateway;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Noah Campbell
 * @version 1.0
 */
public class EndpointValve {
    
    
    /** The valve handle. */
    private final AtomicBoolean open;
    
    /**
     * Construct a new <code>EndpointValve</code>.  The valve is closed by 
     * default.
     */
    public EndpointValve() {
        this(false);
    }
    
    /**
     * Construct a new <code>EndpointValve</code>.
     *
     * @param open The valve is open or closed.
     */
    public EndpointValve(boolean open) {
        this.open = new AtomicBoolean(open);
    }

    
    /**
     * @return open If the valve is open or not.
     */
    public boolean isOpen() {
        return this.open.get();
    }
    
    
    /**
     * Open the valve and let any pending message get processed.
     */
    public void open() {
        this.open.set(true);
    }
    
    
    /**
     * Close the valve and queue any new messeages destine for the endpoint.
     */
    public void close() {
        this.open.set(false);
    }
}
