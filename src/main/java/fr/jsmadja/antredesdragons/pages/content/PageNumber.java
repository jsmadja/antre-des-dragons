package fr.jsmadja.antredesdragons.pages.content;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageNumber {
    private Integer value;

    public static PageNumber of(int value) {
        return new PageNumber(value);
    }
}
