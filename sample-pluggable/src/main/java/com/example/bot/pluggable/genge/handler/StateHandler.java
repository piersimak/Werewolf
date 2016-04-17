package com.example.bot.pluggable.genge.handler;

import com.example.bot.pluggable.genge.storage.KeyValueStorage;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.content.TextContent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

public class StateHandler implements TextContentHandler {
    @Autowired
    private TextContentHandler handler;
    @Getter
    @Setter
    private String state;
    @Autowired
    private KeyValueStorage<String> kvs;

    @Override
    public HandlerResponse told(TextContent textContent) throws LineBotAPIException {
        String state = kvs.load(getClass().getPackage(),
                textContent.getFrom());
        if (state == null) {
            state = "initial";
        }

        if (state.equals(this.state)) {
            return handler.told(textContent);
        } else {
            return HandlerResponse.DECLINED;
        }
    }
}
