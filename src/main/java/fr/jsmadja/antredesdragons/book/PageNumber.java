package fr.jsmadja.antredesdragons.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "page")
public class PageNumber {
    private final Integer page;
}
