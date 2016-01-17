package net.dzhai.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by MaxTP on 2016/1/17.
 */
public class LogBackTest1 {

    static Logger logger= LoggerFactory.getLogger(LogBackTest1.class);

    public static void main(String[] args) {

        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
    }


    public void getName(){}
}
