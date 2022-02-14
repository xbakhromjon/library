package uz.elmurodov.criteria;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BookCriteria {
    private String filter;
    private String search;
}
