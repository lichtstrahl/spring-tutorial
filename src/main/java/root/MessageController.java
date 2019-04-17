package root;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/msg")
    public Message message(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Message(counter.incrementAndGet(), String.format(Locale.ENGLISH, template, name));
    }
}
