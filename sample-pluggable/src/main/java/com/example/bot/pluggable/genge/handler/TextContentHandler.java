package com.example.bot.pluggable.genge.handler;

import com.linecorp.bot.client.exception.LineBotAPIException;
import com.linecorp.bot.model.callback.Message;
import com.linecorp.bot.model.content.TextContent;

public interface TextContentHandler {
    HandlerResponse told(TextContent message) throws LineBotAPIException;
}
