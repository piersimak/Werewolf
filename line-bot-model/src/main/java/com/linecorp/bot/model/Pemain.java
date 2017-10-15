
package com.linecorp.bot.model;

import java.util.Collections;
import java.util.List;

import com.linecorp.bot.model.message.Message;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Send messages to users, groups, and rooms at any time.
 */
public class Pemain {
    /**
     * ID of the receiver
     */
    private String nama;
    private String id;
    /**
     * List of Message objects.<br>
     * Max: 5
     */


    public Pemain(String nama_, String id_) {
        this.nama = nama_;
        this.id = id_;
    }
}
