package com.ziluck.iastate.mis320final.utils.model;

/**
 * The speed for performance logging
 */
public enum Speed {
    /**
     * Time spent less than 10 ms
     */
    VeryFast,

    /**
     * Time spent less than 100 ms
     */
    Fast,

    /**
     * Time spent less than 1,000 ms
     */
    Medium,

    /**
     * Time spent less than 5,000 ms
     */
    Slow,

    /**
     * Time spent more than 5,000 ms
     */
    VerySlow
}
