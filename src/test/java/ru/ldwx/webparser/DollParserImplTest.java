package ru.ldwx.webparser;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DollParserImplTest {
    private final DollParser parser = new DollParserImpl();

    @Test
    void getDollFromPageShouldWork() throws IOException {
        Optional<Doll> optionalDoll = parser.getDollFromPage("http://www.acbjd.com/francis-p-6081.html?cPath=1140_1143&zenid=3ff463866f5b859668806fd107761d89");
        assertTrue(optionalDoll.isPresent());
        optionalDoll.ifPresent(doll -> {
                    assertEquals("Francis", doll.getName());
                    assertEquals(new BigDecimal("199.00"), doll.getPrice());
                    assertEquals("http://www.acbjd.com/francis-p-6081.html?cPath=1140_1143&zenid=3ff463866f5b859668806fd107761d89", doll.getUrl());
                    assertEquals(LocalDate.now(), doll.getLastUpdate());
                }
        );
    }

    @Test
    void getUrlsShouldWork() throws IOException {
        Set<String> urls = parser.getUrls("http://www.acbjd.com/");
        System.out.println(urls);
        assertTrue(urls.size() > 0);
    }
}