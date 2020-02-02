package net.sample.doctor.docapp.security;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("security")
@Data
public class RestSecurityProperties {
    List<String> alloweddomains= Collections.emptyList();
    List<String> allowedheaders=Collections.emptyList();
    List<String> allowedmethods=Collections.emptyList();

    public List<String> getAlloweddomains() {
        return alloweddomains;
    }

    public void setAlloweddomains(List<String> alloweddomains) {
        this.alloweddomains = alloweddomains;
    }

    public List<String> getAllowedheaders() {
        return allowedheaders;
    }

    public void setAllowedheaders(List<String> allowedheaders) {
        this.allowedheaders = allowedheaders;
    }

    public List<String> getAllowedmethods() {
        return allowedmethods;
    }

    public void setAllowedmethods(List<String> allowedmethods) {
        this.allowedmethods = allowedmethods;
    }

    public List<String> getAllowedpublicapis() {
        return allowedpublicapis;
    }

    public void setAllowedpublicapis(List<String> allowedpublicapis) {
        this.allowedpublicapis = allowedpublicapis;
    }

    List<String> allowedpublicapis=Collections.emptyList();
}
