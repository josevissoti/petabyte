package com.curso.services;

import com.curso.domains.*;
import com.curso.domains.enums.Condicao;
import com.curso.domains.enums.Status;
import com.curso.domains.enums.StatusPedido;
import com.curso.domains.enums.TipoEntrega;
import com.curso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class DBService {

    @Autowired
    private CategoriaComponenteRepository categoriaComponenteRepo;

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private ComponenteRepository componenteRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private FuncionarioRepository funcionarioRepo;

    @Autowired
    private PedidoRepository pedidoRepo;

    @Autowired
    private VeiculoRepository veiculoRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB() {

        CategoriaComponente categoriaComponente01 = new CategoriaComponente(null, "SSD");
        CategoriaComponente categoriaComponente02 = new CategoriaComponente(null, "Processador");
        CategoriaComponente categoriaComponente03 = new CategoriaComponente(null, "Placa de vídeo");

        Fornecedor fornecedor01 = new Fornecedor(null, "AMD", "147910124", "Brasil", "Rio de Janeiro", "Rio de Janeiro", "Rua Belo Horizonte n176", Status.ATIVO);
        Fornecedor fornecedor02 = new Fornecedor(null, "NVidia", "840148054", "Brasil", "São Paulo", "Campinas", "Av. Liberdade n738", Status.ATIVO);
        Fornecedor fornecedor03 = new Fornecedor(null, "Kingston", "749302647", "EUA", "New York", "New York", "St. Mark's Place N30", Status.ATIVO);

        Componente componente01 = new Componente(null, "GeForce RTX 4080", "GDDR6X", LocalDate.of(2022, Month.DECEMBER, 05), new BigDecimal("15000.00"), new BigDecimal("20"), 50, categoriaComponente03, fornecedor02, Status.ATIVO, Condicao.NOVO);
        Componente componente02 = new Componente(null, "SSD Kingston 1TB", "A400", LocalDate.of(2020, Month.APRIL, 21), new BigDecimal("219.99"), new BigDecimal("10.00"), 400, categoriaComponente01, fornecedor03, Status.ATIVO, Condicao.SEMIUSADO);
        Componente componente03 = new Componente(null, "Ryzen 5", "5600G", LocalDate.of(2019, Month.JULY, 12), new BigDecimal("1199.99"), new BigDecimal("15.50"), 267, categoriaComponente02, fornecedor01, Status.ATIVO, Condicao.USADO);

        Usuario usuario01 = new Usuario(null, "Ronaldo", "29850950005", LocalDate.of(1982, Month.NOVEMBER, 5), "Ronaldo@gmail.com", encoder.encode("Ronaldo123"));
        Usuario usuario02 = new Usuario(null, "Giovana", "99763020026", LocalDate.of(2000, Month.FEBRUARY, 23), "Giovana@gmail.com", encoder.encode("Giovana123"));

        Funcionario funcionario01 = new Funcionario(null, "Leandro", "26537686075", LocalDate.of(1974, Month.OCTOBER, 18), "Leandro@gmail.com", encoder.encode("Leandro123"));
        Funcionario funcionario02 = new Funcionario(null, "Claudia", "31075052009", LocalDate.of(1985, Month.JULY, 13), "Claudia@gmail.com", encoder.encode("Claudia123"));

        Pedido pedido01 = new Pedido(null, "PedidoGrande", LocalDate.of(2025, Month.APRIL, 1), TipoEntrega.NORMAL, StatusPedido.CAMINHO, usuario01, funcionario01);
        Pedido pedido02 = new Pedido(null, "PedidoPequeno", LocalDate.of(2025, Month.MARCH, 21), TipoEntrega.EXPRESSO, StatusPedido.ENTREGUE, usuario02, funcionario02);

        Veiculo veiculo01 = new Veiculo(null, "Corsa", LocalDate.of(2020, Month.OCTOBER, 14), new BigDecimal("50000.00"), "Fernando", "84521647519");
        Veiculo veiculo02 = new Veiculo(null, "Duster", LocalDate.of(2024, Month.JANUARY, 23), new BigDecimal("80000.00"), "Jorge", "87521684581");

        categoriaComponenteRepo.save(categoriaComponente01);
        categoriaComponenteRepo.save(categoriaComponente02);
        categoriaComponenteRepo.save(categoriaComponente03);

        fornecedorRepo.save(fornecedor01);
        fornecedorRepo.save(fornecedor02);
        fornecedorRepo.save(fornecedor03);

        componenteRepo.save(componente01);
        componenteRepo.save(componente02);
        componenteRepo.save(componente03);

        usuarioRepo.save(usuario01);
        usuarioRepo.save(usuario02);

        funcionarioRepo.save(funcionario01);
        funcionarioRepo.save(funcionario02);

        pedidoRepo.save(pedido01);
        pedidoRepo.save(pedido02);

        veiculoRepo.save(veiculo01);
        veiculoRepo.save(veiculo02);

    }

}
