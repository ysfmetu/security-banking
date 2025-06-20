package com.ysf.security.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/* Created by yusufulku,20.06.2025 */
@Component
@Slf4j
public class AuthenticationEvents {
    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        log.info("Authentication Success Event: {}",successEvent.getAuthentication().getName());
    }
    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        log.error("Authentication failed for the user : {} due to : {} ",failureEvent.getAuthentication().getName(),failureEvent.getException().getMessage());
    }
}
