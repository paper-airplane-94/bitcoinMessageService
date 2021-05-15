package org.investment.bitcoin.markettickpricenotifyservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class FcmPushMessage {
    @SerializedName("validate_only")
    private boolean isValidation;
    private Message message;
}
