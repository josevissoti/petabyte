package com.curso.services;

import com.curso.domains.Pessoa;
import com.curso.repositories.PessoaRepository;
import com.curso.security.TechnicianSS;
import com.curso.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianDetailsServiceImpl implements UserDetailsService {

    private final PessoaRepository pessoaRepository;

    public TechnicianDetailsServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Pessoa> user = pessoaRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Technician not found: " + username);
        }
        return new TechnicianSS((user.orElse(null)));
    }

}
