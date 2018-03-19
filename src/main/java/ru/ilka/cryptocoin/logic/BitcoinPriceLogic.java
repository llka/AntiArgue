package ru.ilka.cryptocoin.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.ilka.cryptocoin.service.BitcoinPriceService;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

public class BitcoinPriceLogic {
    private static final Logger logger = LogManager.getLogger(BitcoinPriceLogic.class);
    private BitcoinPriceService bitcoinPriceService;

    public BitcoinPriceLogic() {
        bitcoinPriceService = new BitcoinPriceService();
    }

    public String getSolutionByBitcoinPrice(List<String> variants) {
        double price = bitcoinPriceService.getBitcoinPrice();
        StringBuilder priceString = new StringBuilder("Bitcoin price in USD = ");
        priceString.append(price);
        priceString.append(", price mod ");
        priceString.append(variants.size());
        priceString.append(" = ");
        priceString.append(Math.round(price) % variants.size());
        priceString.append(", Solution = ");
        priceString.append(variants.get((int) Math.round(price) % variants.size()));
        return priceString.toString();
    }
}
