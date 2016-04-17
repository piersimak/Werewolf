package com.example.bot.pluggable.genge.plugin.time_signal;

import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Collections;

public class TimeSignalHandler {
    @Autowired
    private LineBotClient lineBotClient;

    @Scheduled(cron="0 * * * *")
    public void run() throws LineBotAPIException {
        // TOOD pass mid
        lineBotClient.sendText(Collections.emptyList(),
                LocalDateTime.now().toString());
    }
}
