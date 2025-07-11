/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package fotogames.main;

import fotogames.DAO.ClienteDAO;
import fotogames.DAO.EstoqueDAO;
import fotogames.DAO.ProdutoDAO;
import fotogames.DAO.VendaDAO;
import fotogames.DAO.VendaProdutoDAO;
import fotogames.entidades.Acessorio;
import fotogames.entidades.Cliente;
import fotogames.entidades.Jogo;
import fotogames.entidades.Produto;
import fotogames.entidades.Venda;
import fotogames.entidades.VendaProduto;
import fotogames.servico.Validacao;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author breno
 */
public class WebFotoGames {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO pDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        EstoqueDAO eDAO = new EstoqueDAO();
        VendaDAO vendaDAO = new VendaDAO();
        VendaProdutoDAO vendaProdutoDAO = new VendaProdutoDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        double valorTotal = 0;
        List<Produto> produtosSelecionados = new ArrayList<>();
        VendaProduto vendaProduto = new VendaProduto();
        Venda venda = new Venda();
        Cliente cliente = new Cliente();

        System.out.println("------------------------");
        System.out.println("1 - Venda; 2 - Estoque; 3 - Cliente; 0 - Sair");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("------------------------");
                System.out.println("4 - Listar Vendas; 5 - Efetuar venda");
                opcao = sc.nextInt();

                if (opcao == 4) {
                    VendaDAO vDAO = new VendaDAO();
                    List<Venda> listaVendas = vDAO.listar();

                    for (int i = 0; i < listaVendas.size(); i++) {
                        Venda vendaAtual = listaVendas.get(i);
                        System.out.println(vendaAtual.toString());
                    }
                } else if (opcao == 5) {
                    do {
                        System.out.println("------------------------");
                        System.out.println("Informa id do produto");
                        int id = sc.nextInt();

                        List<Produto> lista = pDAO.listar();

                        for (Produto p : lista) {
                            boolean produtoEncontrado = eDAO.status(id);
                            if (produtoEncontrado && clienteDAO != null) {
                                valorTotal += p.getValor();
                                produtoEncontrado = true;
                                produtosSelecionados.add(p);
                                break;
                            }
                        }
                        System.out.println("------------------------");
                        System.out.println("Deseja continuar 0 - N; 1 - S");
                        opcao = sc.nextInt();
                    } while (opcao != 0);

                    System.out.println("Informa id do cliente");
                    int idCliente = sc.nextInt();
                    cliente = clienteDAO.getCliente(idCliente);

                    if (cliente != null) {
                        System.out.println("Forma de pagamento");
                        sc.nextLine();
                        venda.setFormPagamento(sc.nextLine());

                        venda.setCliente(cliente);

                        System.out.println("Data da venda");
                        String textoData = sc.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate localDate = LocalDate.parse(textoData, formatter);

                        Date sqlData = Date.valueOf(localDate);
                        venda.setData(sqlData);
                        vendaDAO.cadastrar(venda);
                    }

                    for (int i = 0; i < produtosSelecionados.size(); i++) {
                        Produto p = produtosSelecionados.get(i);

                        vendaProduto.setValorTotal(valorTotal);
                        eDAO.atualizar(p.getId(), 1);

                        vendaProduto.setQuantidade(1);
                        vendaProduto.setProduto(p);
                        vendaProduto.setVenda(venda);
                        vendaProdutoDAO.cadastrar(vendaProduto);

                    }

                } else {
                    System.out.println("Opcao Invalida");
                }

                break;

            case 2:
                System.out.println("------------------------");
                System.out.println("6 - Listar Produtos; 7 - Cadastrar Produto");
                opcao = sc.nextInt();

                if (opcao == 6) {
                    List<Produto> listaProduto = pDAO.listar();

                    for (int i = 0; i < listaProduto.size(); i++) {
                        Produto produtoAtual = listaProduto.get(i);
                        System.out.println(produtoAtual.toString());
                    }
                } else if (opcao == 7) {
                    System.out.println("1 - Hardware; 2 - Jogo; 3 - Acessorio");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao == 1) {
                        Produto p = new Produto();

                        System.out.println("Nome do Produto");
                        p.setNomeProduto(sc.nextLine());
                        System.out.println("Fabricante");
                        p.setFabricante(sc.nextLine());
                        System.out.println("Categoria");
                        p.setCategoria(sc.nextLine());
                        System.out.println("Garantia");
                        p.setGarantia(sc.nextInt());
                        System.out.println("Valor");
                        p.setValor(sc.nextDouble());

                        produtoDAO.cadastrar(p);
                    } else if (opcao == 2) {
                        Jogo jogo = new Jogo();
                        System.out.println("Nome do Produto");
                        jogo.setNomeProduto(sc.nextLine());
                        System.out.println("Fabricante");
                        jogo.setFabricante(sc.nextLine());
                        System.out.println("Categoria");
                        jogo.setCategoria(sc.nextLine());
                        System.out.println("Plataforma");
                        jogo.setPlataforma(sc.nextLine());
                        System.out.println("Garantia");
                        jogo.setGarantia(sc.nextInt());
                        System.out.println("Valor");
                        jogo.setValor(sc.nextDouble());

                        produtoDAO.cadastrar(jogo);
                    } else if (opcao == 3) {
                        Acessorio acessorio = new Acessorio();
                        System.out.println("Nome do Produto");
                        acessorio.setNomeProduto(sc.nextLine());
                        System.out.println("Fabricante");
                        acessorio.setFabricante(sc.nextLine());
                        System.out.println("Categoria");
                        acessorio.setCategoria(sc.nextLine());
                        System.out.println("Cor");
                        acessorio.setCor(sc.nextLine());
                        System.out.println("Garantia");
                        acessorio.setGarantia(sc.nextInt());
                        System.out.println("Valor");
                        acessorio.setValor(sc.nextDouble());

                        produtoDAO.cadastrar(acessorio);
                    }
                } else {
                    System.out.println("Opcao invalida");
                }
                break;
            case 3:
                System.out.println("------------------------");
                System.out.println("8 - Listar Clientes; 9 - Cadastrar");
                opcao = sc.nextInt();

                if (opcao == 8) {
                    ClienteDAO cDAO = new ClienteDAO();
                    List<Cliente> listaCliente = cDAO.listar();

                    for (int i = 0; i < listaCliente.size(); i++) {
                        Cliente clienteAtual = listaCliente.get(i);
                        System.out.println(clienteAtual.toString());
                    }
                } else if (opcao == 9) {
                    sc.nextLine();
                    Validacao validacao = new Validacao();

                    do {
                        System.out.println("Nome do cliente");
                        cliente.setNome(sc.nextLine());
                        System.out.println("Informe seu CPF");
                        cliente.setCpf(sc.nextLine());
                        System.out.println("Informe seu email");
                        cliente.setEmail(sc.nextLine());
                        System.out.println("Informe seu telefone");
                        cliente.setTelefone(sc.nextLine());
                    } while (validacao.cliente(cliente.getCpf(), cliente.getEmail(), cliente.getTelefone()));
                    clienteDAO.cadastrar(cliente);
                } else {
                    System.out.println("Opcao invalida");
                }
                break;
            case 0:
                System.out.println("Saindo do teste");
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }
}
