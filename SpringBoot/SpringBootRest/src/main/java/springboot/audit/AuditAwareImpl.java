package springboot.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String auditUser = SecurityContextHolder.getContext().getAuthentication().getName();
        if(auditUser==null)
            auditUser="AnonymousUser";
        return Optional.of(auditUser);
    }
}
