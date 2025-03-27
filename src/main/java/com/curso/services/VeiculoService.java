package com.curso.services;

import com.curso.domains.Veiculo;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.repositories.VeiculoRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    public VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll().stream()
                .map(obj -> new VeiculoDTO(obj)).collect(Collectors.toList());
    }

    public Veiculo findById(Long id) {
        Optional<Veiculo> obj = veiculoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado. ID: " + id));
    }

    public Veiculo findByCpfProprietario(String cpfProprietario) {
        Optional<Veiculo> obj = veiculoRepository.findByCpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veículo não encontrado. CPF do proprietário: " + cpfProprietario));
    }

    public Veiculo create(VeiculoDTO veiculoDTO) {
        veiculoDTO.setIdVeiculo(null);
        validaVeiculo(veiculoDTO);
        Veiculo obj = new Veiculo(veiculoDTO);
        return veiculoRepository.save(obj);
    }

    public void validaVeiculo(VeiculoDTO veiculoDTO) {
        Optional<Veiculo> obj = veiculoRepository.findByCpfProprietario(veiculoDTO.getCpfProprietario());
        if (obj.isPresent() && obj.get().getIdVeiculo() != veiculoDTO.getIdVeiculo()) {
            throw new DataIntegrityViolationException("CPF do proprietário já cadastrado");
        }
    }

    public Veiculo update(Long id, VeiculoDTO objDTO) {
        objDTO.setIdVeiculo(id);
        Veiculo oldObj = findById(id);
        validaVeiculo(objDTO);
        oldObj = new Veiculo(objDTO);
        return veiculoRepository.save(oldObj);
    }

    public void delete(Long id) {
        Veiculo obj = findById(id);
        veiculoRepository.deleteById(id);
    }
}
