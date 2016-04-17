package com.example.bot.pluggable.genge.plugin.base64;

import com.example.bot.pluggable.genge.handler.TextContentHandler;
import com.example.bot.pluggable.genge.handler.HandlerResponse;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.content.TextContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodeHandler implements TextContentHandler {
    @Autowired
    private LineBotClient lineBotClient;

    @Override
    public HandlerResponse told(TextContent textContent) throws LineBotAPIException {
        String encoded = Base64.getEncoder()
                .encodeToString(
                        textContent.getText()
                                .getBytes(StandardCharsets.UTF_8));

        lineBotClient.sendText(
                textContent.getFrom(),
                encoded
        );
        return HandlerResponse.OK;
    }
}
