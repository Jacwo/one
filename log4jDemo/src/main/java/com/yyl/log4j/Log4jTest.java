package com.yyl.log4j;

import org.apache.log4j.Logger;

/**
 * @author yyl
 * @date 2018/12/22 15:46
 */
public class Log4jTest {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(Log4jTest.class);
        logger.info("22222");
    }
}
