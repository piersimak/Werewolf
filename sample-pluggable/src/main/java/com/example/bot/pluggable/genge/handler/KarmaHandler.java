package com.example.bot.pluggable.genge.handler;

import com.example.bot.pluggable.genge.storage.KeyValueStorage;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.content.TextContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KarmaHandler implements Handler {
    @Autowired
    private LineBotClient lineBotClient;
    @Autowired
    private KeyValueStorage<Integer> keyValueStorage;

    private static final Pattern PATTERN = Pattern.compile("(\\w+)(\\+\\+|\\-\\-)");

    @Override
    public HandlerResponse told(TextContent textContent) throws LineBotAPIException {
        String text = textContent.getText();
        Matcher matcher = PATTERN.matcher(text);

        if (!matcher.matches()) {
            return HandlerResponse.DECLINED;
        }

        String name = matcher.group(1);
        String type = matcher.group(2);

        Integer retval = keyValueStorage.compute(
                this.getClass(),
                name,
                ( key,  current) -> {
                    if (current == null) {
                        return 1;
                    } else {
                        if ("++".equals(type)) {
                            return current + 1;
                        } else {
                            return current - 1;
                        }
                    }
                }
        );

        lineBotClient.sendText(
                textContent.getFrom(),
                String.format("%s%s: %d", name, type, retval)
        );
        return HandlerResponse.OK;
    }
}
