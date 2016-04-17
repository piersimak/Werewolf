package com.example.bot.pluggable.genge.plugin.echo;

import com.example.bot.pluggable.genge.handler.TextContentHandler;
import com.example.bot.pluggable.genge.handler.HandlerResponse;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.content.TextContent;
import org.springframework.beans.factory.annotation.Autowired;

public class EchoHandler implements TextContentHandler {
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
