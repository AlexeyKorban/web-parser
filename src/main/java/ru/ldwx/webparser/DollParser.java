package ru.ldwx.webparser;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public interface DollParser {
    Optional<Doll> getDollFromPage(String url) throws IOException;
    Set<String> getUrls(String url) throws IOException;
}
