package com.ziluck.iastate.mis320final.utils;

import com.ziluck.iastate.mis320final.utils.model.Speed;
import org.slf4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The utility to record the execution performance.
 */
public class Stopwatch {

    // region Fields and internal class

    /**
     * The internal class that represents a watch result.
     */
    private class Result {
        /**
         * The message of the watch.
         */
        private String message;

        /**
         * The time spent
         */
        private long timeSpent;
    }

    /**
     * All the results of the watches.
     */
    private Map<Long, Result> results = new LinkedHashMap<>();

    /**
     * The start time of current watch
     */
    private long startTime = -1;

    /**
     * The result model of current watch.
     */
    private Result currentResult;

    // endregion

    /**
     * The default constructor
     */
    public Stopwatch() {
    }

    /**
     * start to watch.
     *
     * @param startMessage The message of the watch.
     */
    public void start(String startMessage) {
        startTime = System.currentTimeMillis();
        currentResult = new Result();
        currentResult.message = startMessage;
    }

    /**
     * Stop last watch, and start a new watch.
     *
     * @param watchMessage The message of the watch
     */
    public void watch(String watchMessage) {
        this.stop();
        this.start(watchMessage);
    }

    /**
     * Stop the watch.
     */
    public void stop() {
        if (currentResult != null) {
            currentResult.timeSpent = System.currentTimeMillis() - startTime;
            Long key = startTime;
            while (results.containsKey(key)) {
                key += 999;
            }
            results.put(key, currentResult);

            startTime = -1;
            currentResult = null;
        }
    }

    /**
     * Reset the watches, all the watch results will be cleared.
     */
    public void reset() {
        startTime = -1;
        currentResult = null;
        results = new LinkedHashMap<>();
    }

    /**
     * Get the total time spent of the watches.
     *
     * @return The total time spent
     */
    public long getTotalTimeSpent() {
        long total = 0;

        for (Result result : results.values()) {
            total += result.timeSpent;
        }

        return total;
    }

    /**
     * Get the string of the watch results.
     *
     * @return
     */
    @Override
    public String toString() {
        this.stop();

        StringBuilder sb = new StringBuilder();

        long total = 0;

        boolean isFirst = true;
        for (Result result : results.values()) {
            // Separate the messages with ", "
            if (!isFirst) {
                sb.append(", ");
            }
            isFirst = false;

            // Append the watch result
            if (result.message != null && !result.message.isEmpty()) {
                sb.append(result.message).append(": ");
            } else {
                sb.append("time spent: ");
            }
            sb.append(result.timeSpent).append(" ms");

            // Calculate the total time spent
            total += result.timeSpent;
        }

        // Append the "total" time spent
        if (results.size() > 1) {
            sb.insert(0, "total: " + total + " ms, ");
        }

        // Append speed
        sb.append(" (").append(getSpeed(total).toString()).append(")");

        return sb.toString();
    }

    /**
     * Output the performance log, the log level will be different based on the
     * speed.
     * <p>
     * The log will be: > Warning level if the speed is very slow(> 5s) > Info
     * level if the speed is slow (1s - 5s) > Debug level if the speed is medium
     * (100 ms - 1s) > Trace level if the speed is fast or very fast (0 -
     * 100ms)
     *
     * @param logger
     * @param format
     * @param param
     */
    public void logPerformance(Logger logger, String format, Object... param) {
        String message = MessageFormatter.arrayFormat(format, param).getMessage();

        this.stop();

        Speed speed = this.getSpeed(this.getTotalTimeSpent());
        switch (speed) {
            case Fast:
            case VeryFast:
                logger.trace("{}, {}", message, this.toString());
                break;
            case Medium:
                logger.debug("{}, {}", message, this.toString());
                break;
            case Slow:
                logger.info("{}, {}", message, this.toString());
                break;
            case VerySlow:
                logger.warn("{}, {}", message, this.toString());
                break;
            default:
                logger.debug("{}, {}", message, this.toString());
                break;
        }
    }

    /**
     * Get the speed
     *
     * @param timeSpent The time spent
     * @return The speed
     */
    private Speed getSpeed(long timeSpent) {
        Speed speed;
        if (timeSpent < 10) {
            speed = Speed.VeryFast;
        } else if (timeSpent < 100) {
            speed = Speed.Fast;
        } else if (timeSpent < 1000) {
            speed = Speed.Medium;
        } else if (timeSpent < 5000) {
            speed = Speed.Slow;
        } else {
            speed = Speed.VerySlow;
        }
        return speed;
    }

    /**
     * Create a Stopwatch instance and start the watch.
     *
     * @param startMessage The start message
     * @return The Stopwatch instance
     */
    public static Stopwatch startWatch(String startMessage) {
        Stopwatch sw = new Stopwatch();
        sw.start(startMessage);
        return sw;
    }
}
