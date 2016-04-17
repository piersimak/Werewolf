package com.example.bot.pluggable.genge.plugin.forward;

import com.example.bot.pluggable.genge.storage.KeyValueStorage;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.exception.LineBotAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForwardController {
    @Autowired
    private LineBotClient lineBotClient;
    @Autowired
    private KeyValueStorage<String> keyValueStorage;

    @RequestMapping(value = "${me.geso.genge.plugin.forward.path:/forward}", method = RequestMethod.POST)
    public void forward(@RequestParam("token") String token,
                        @RequestParam("message") String message) throws LineBotAPIException {
        String mid = keyValueStorage.load(getClass().getPackage(),
                "token:" + token);
        lineBotClient.sendText(mid, message);
    }
}
