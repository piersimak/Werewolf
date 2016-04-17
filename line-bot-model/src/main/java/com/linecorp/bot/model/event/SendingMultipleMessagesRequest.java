/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.bot.model.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendingMultipleMessagesRequest implements EventRequest {
    public static final int TO_TYPE_USER = 1;

    /**
     * List of mids
     */
    private List<String> to;

    /**
     * Receiver channel ID
     */
    private long toChannel;

    /**
     * Event type.
     */
    private String eventType;

    /**
     * Content
     */
    private SendingMultipleMessagesRequestContent content;

    @JsonCreator
    public SendingMultipleMessagesRequest(
            @JsonProperty("to") List<String> to,
            @JsonProperty("toChannel") long toChannel,
            @JsonProperty("eventType") String eventType,
            @JsonProperty("content") SendingMultipleMessagesRequestContent content) {
        this.to = to;
        this.toChannel = toChannel;
        this.eventType = eventType;
        this.content = content;
    }
}
