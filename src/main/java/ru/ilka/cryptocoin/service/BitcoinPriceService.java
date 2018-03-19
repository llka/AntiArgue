package ru.ilka.cryptocoin.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import ru.ilka.cryptocoin.exception.ServiceException;

import java.io.IOException;

public class BitcoinPriceService {
    private static final Logger logger = LogManager.getLogger(BitcoinPriceService.class);

    private static final String BITCOIN_PRICE_URL = "https://coinmarketcap.com/currencies/bitcoin/";
    private static final String DATA_PRICE_ATTRIBUTE = "data-currency-price";

    public double getBitcoinPrice() throws ServiceException {
        Document document = null;
        try {
            document = Jsoup.connect(BITCOIN_PRICE_URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements price;
        try {
            price = document.getElementsByAttribute(DATA_PRICE_ATTRIBUTE);
        } catch (NullPointerException e) {
            throw new ServiceException("Can not get Attribute " + DATA_PRICE_ATTRIBUTE, e);
        }
        return Double.parseDouble(price.first().attributes().asList().get(2).getValue());
    }
}
