package com.example.bot.pluggable.genge.handler;

import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.content.TextContent;
import org.springframework.beans.factory.annotation.Autowired;

public class EchoHandler implements Handler {
    @Autowired
    private LineBotClient lineBotClient;

    @Override
    public HandlerResponse told(TextContent textContent) throws LineBotAPIException {
        lineBotClient.sendText(
                textContent.getFrom(),
                textContent.getText()
        );
        return HandlerResponse.OK;
    }
}
