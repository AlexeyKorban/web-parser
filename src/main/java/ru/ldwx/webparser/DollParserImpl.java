package ru.ldwx.webparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DollParserImpl implements DollParser {
    @Override
    public Optional<Doll> getDollFromPage(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        var name = document.getElementById("productName").childNode(0).toString();
        var priceString = document.getElementById("productPrices").childNode(0).toString().replaceAll("\\$", "").trim();
        BigDecimal price = new BigDecimal(priceString);
        return Optional.of(new Doll(name, price, url, LocalDate.now()));
    }

    @Override
    public Set<String> getUrls(String url) throws IOException {
        Set<String> urls = new HashSet<>();
        TreeSet<String> urlsToParse = new TreeSet<>();
        urlsToParse.add(url);
        while (!urlsToParse.isEmpty()) {
            var currentUrl = urlsToParse.pollFirst();
            Set<String> urlsFromPage = getUrlsFromPage(currentUrl);
            for (String urlFromPage : urlsFromPage) {
                if (urls.add(urlFromPage)) {
                    urlsToParse.add(urlFromPage);
                }
            }
        }
        return urls;
    }

    private Set<String> getUrlsFromPage(String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements links = document.select("a");
        if (links.isEmpty()) {
            return new HashSet<>();
        }
        return links.stream().map(link -> link.attr("abs:href")).filter(link -> link.contains("acbjd.com")).collect(Collectors.toSet());
    }
}
