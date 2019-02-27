package com.ehayes.springit2.Config;

 import com.ehayes.springit2.Springitmodel.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

  public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
     public Optional<String> getCurrentAuditor() {
        if(SecurityContextHolder.getContext().getAuthentication() == null || SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("annoymousUser")){
            return Optional.of("super@gmail.com");
    }
        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
    }
 }
