package com.ketch.events.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RequestStatusReason {
    @JsonProperty("unknown") Unknown,
    @JsonProperty("need_user_verification") NeedUserVerification,
    @JsonProperty("suspected_fraud") SuspectedFraud,
    @JsonProperty("insufficient_verification") InsufficientVerification,
    @JsonProperty("no_match") NoMatch,
    @JsonProperty("claim_not_covered") ClaimNotCovered,
    @JsonProperty("outside_jurisdiction") OutsideJurisdiction,
    @JsonProperty("too_many_requests") TooManyRequests,
    @JsonProperty("other") Other;
}
