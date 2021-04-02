package ru.ldwx.webparser;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Doll {
    private String name;
    private BigDecimal price;
    private String url;
    private LocalDate lastUpdate;

    public Doll(String name, BigDecimal price, String url, LocalDate lastUpdate) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }
}
