package com.curso.services;

import com.curso.domains.Funcionario;
import com.curso.domains.dtos.FuncionarioDTO;
import com.curso.repositories.FuncionarioRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    public List<FuncionarioDTO> fundAll() {
        return funcionarioRepo.findAll().stream()
                .map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. ID: " + id));
    }

    public Funcionario findByCpf(String cpf) {
        Optional<Funcionario> obj = funcionarioRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. CPF: " + cpf));
    }

    public Funcionario findByEmail(String email) {
        Optional<Funcionario> obj = funcionarioRepo.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Email: " + email));
    }

    public Funcionario create(FuncionarioDTO objDto) {
        objDto.setIdPessoa(null);
        validaPorCPFeEmail(objDto);
        Funcionario newObj = new Funcionario(objDto);
        return funcionarioRepo.save(newObj);
    }

    public Funcionario update(Long id, FuncionarioDTO objDto) {
        objDto.setIdPessoa(id);
        Funcionario oldObj = findById(id);
        validaPorCPFeEmail(objDto);
        oldObj = new Funcionario(objDto);
        return funcionarioRepo.save(oldObj);
    }

    public void delete(Long id) {
        Funcionario obj = findById(id);
        if (obj.getPedidos().size() > 0) {
            throw new DataIntegrityViolationException("Técnico não pode ser deletado pois possui pedidos vinculados");
        }
        funcionarioRepo.deleteById(id);
    }

    private void validaPorCPFeEmail(FuncionarioDTO objDto) {
        Optional<Funcionario> obj = funcionarioRepo.findByCpf(objDto.getCpf());
        if (obj.isPresent() && obj.get().getIdPessoa() != objDto.getIdPessoa()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = funcionarioRepo.findByEmail(objDto.getEmail());
        if (obj.isPresent() && obj.get().getIdPessoa() != objDto.getIdPessoa()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistmea");
        }
    }
}
