package ru.ilka.cryptocoin.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.ilka.cryptocoin.logic.BitcoinPriceLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Demo {
    private static final Logger logger = LogManager.getLogger(Demo.class);

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            BitcoinPriceLogic bitcoinPriceLogic = new BitcoinPriceLogic();
            List<String> variants = List.of("cinema", "concert", "dancing");
            logger.info(bitcoinPriceLogic.getSolutionByBitcoinPrice(variants));
            Thread.sleep(5 * 1000);
        }
    }
}
