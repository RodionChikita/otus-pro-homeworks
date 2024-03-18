package ru.otus.java.pro.hw30_https.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryUserDetailsService implements UserDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GrantedAuthority writerAuthority = new SimpleGrantedAuthority("WRITER");
        GrantedAuthority readerAuthority = new SimpleGrantedAuthority("READER");

        if ("writer".equals(username)) {
            return new User("writer", "1234", List.of(writerAuthority));
        }
        if ("reader".equals(username)) {
            return new User("reader", "4321", List.of(readerAuthority));
        }
        throw new UsernameNotFoundException("Username not found");
    }
}
