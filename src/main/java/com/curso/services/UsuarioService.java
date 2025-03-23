package com.curso.services;

import com.curso.domains.Usuario;
import com.curso.domains.dtos.UsuarioDTO;
import com.curso.repositories.UsuarioRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. ID: " + id));
    }

    public Usuario findByCpf(String cpf) {
        Optional<Usuario> obj = usuarioRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. CPF: " + cpf));
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> obj = usuarioRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Email: " + email));
    }

    public Usuario create(UsuarioDTO objDto) {
        objDto.setIdPessoa(null);
        validaPorCPFeEmail(objDto);
        Usuario newObj = new Usuario(objDto);
        return usuarioRepository.save(newObj);
    }

    public Usuario update(Long id, UsuarioDTO objDto) {
        objDto.setIdPessoa(id);
        Usuario oldObj = findById(id);
        validaPorCPFeEmail(objDto);
        oldObj = new Usuario(objDto);
        return usuarioRepository.save(oldObj);
    }

    public void delete(Long id) {
        Usuario obj = findById(id);
        if (obj.getPedidos().size() > 0) {
            throw new DataIntegrityViolationException("Técnico não pode ser deletado pois possui pedidos vinculados");
        }
        usuarioRepository.deleteById(id);
    }

    private void validaPorCPFeEmail(UsuarioDTO objDto) {
        Optional<Usuario> obj = usuarioRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getIdPessoa() != objDto.getIdPessoa()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = usuarioRepository.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getIdPessoa() != objDto.getIdPessoa()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistmea");
        }
    }
}
