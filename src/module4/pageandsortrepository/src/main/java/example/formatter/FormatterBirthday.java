package example.formatter;

import example.model.Customer;
import example.service.ICustomerService;
import org.springframework.format.Formatter;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FormatterBirthday implements Formatter<LocalDate> {
    private DateTimeFormatter formatter;
    private String pattern;

    public FormatterBirthday(String pattern) {
        this.pattern = pattern;
        formatter=DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate parse(String date, Locale locale) throws ParseException {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return "";
    }
}
