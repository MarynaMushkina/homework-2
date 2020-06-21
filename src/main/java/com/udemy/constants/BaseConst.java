package com.udemy.constants;

import java.util.List;

import static java.util.Arrays.asList;

public interface BaseConst {
    String BASE_URL = "https://udemy.com/";
    String SEARCH_PHRASE = "Angular";
    String SEARCH_PHRASE_RESULTS = "results for “angular”";
    String CTA_SUB_HEADER = "See why leading organizations choose Udemy for Business as their destination for employee learning";
    String TEACHING_TEXT = "Make a global impact";

    List<String> MAIN_CATEGORIES = asList(
            "Development",
            "Business",
            "Finance & Accounting",
            "IT & Software",
            "Office Productivity",
            "Personal Development",
            "Design",
            "Marketing",
            "Lifestyle",
            "Photography",
            "Health & Fitness",
            "Music",
            "Teaching & Academics"
            );
}
