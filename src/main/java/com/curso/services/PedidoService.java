package com.curso.services;

import com.curso.domains.Funcionario;
import com.curso.domains.Pedido;
import com.curso.domains.Usuario;
import com.curso.domains.dtos.PedidoDTO;
import com.curso.domains.enums.StatusPedido;
import com.curso.domains.enums.TipoEntrega;
import com.curso.repositories.PedidoRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private UsuarioService usuarioService;

    public Pedido findById(UUID id) {
        Optional<Pedido> obj = pedidoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado. ID: " + id));
    }

    public List<PedidoDTO> findAll() {
        return pedidoRepo.findAll().stream()
                .map(obj -> new PedidoDTO(obj)).collect(Collectors.toList());
    }

    private Pedido novosPedidos(PedidoDTO obj) {
        Funcionario funcionario = funcionarioService.findById(obj.getFuncionario());
        Usuario usuario = usuarioService.findById(obj.getUsuario());

        Pedido pedido = new Pedido();
        if (obj.getIdPedido() != null) {
            pedido.setIdPedido(obj.getIdPedido());
        }

        if (obj.getStatusPedido().equals(2)) {
            pedido.setDataEntrega(LocalDate.now());
        }

        pedido.setFuncionario(funcionario);
        pedido.setUsuario(usuario);
        pedido.setTipoEntrega(TipoEntrega.toEnum(obj.getTipoEntrega()));
        pedido.setStatusPedido(StatusPedido.toEnum(obj.getStatusPedido()));
        pedido.setDescricao(obj.getDescricao());
        pedido.setPrazoMaximo(obj.getPrazoMaximo());
        return pedido;
    }

    public Pedido create(PedidoDTO objDto) {
        return pedidoRepo.save(novosPedidos(objDto));
    }

    public Pedido update(UUID id, PedidoDTO objDto) {
        objDto.setIdPedido(id);
        Pedido oldObj = findById(id);
        oldObj = novosPedidos(objDto);
        return pedidoRepo.save(oldObj);
    }

}
