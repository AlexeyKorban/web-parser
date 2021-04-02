package ru.ldwx.webparser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DollParser {
    Optional<Doll> getDollFromPage(String url) throws IOException;
    List<Doll> getDolls(String url) throws IOException;
}
