package com.example.bot.pluggable.genge.plugin.time_signal;

import com.example.bot.pluggable.genge.friend_list.FriendRepository;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.Collections;

public class TimeSignalHandler {
    @Autowired
    private LineBotClient lineBotClient;
    @Autowired
    private FriendRepository friendRepository;

    @Scheduled(cron="0 * * * *")
    public void run() throws LineBotAPIException {
        // TOOD pass mid
        lineBotClient.sendText(friendRepository.getMids(),
                LocalDateTime.now().toString());
    }
}
