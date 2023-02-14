package CRUD;

import javax.swing.JOptionPane;

public class ClienteDAO {

    private static final int OPCAO_SAIR = 0;
    private static final int OPCAO_CADASTRAR = 1;
    private static final int OPCAO_LISTAR = 2;
    private static final int OPCAO_BUSCAR = 3;
    private static final int OPCAO_ATUALIZAR = 4;
    private static final int OPCAO_EXCLUIR = 5;

    private static int contadorClientes = 0;
    private static Cliente[] clientes = new Cliente[10];

    public void executar() {

        int opcao = -1;

        while (opcao != OPCAO_SAIR) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

            switch (opcao) {
                case OPCAO_CADASTRAR:
                    cadastrar();
                    break;
                case OPCAO_LISTAR:
                    listar();
                    break;
                case OPCAO_BUSCAR:
                    buscar();
                    break;
                case OPCAO_ATUALIZAR:
                    atualizar();
                    break;
                case OPCAO_EXCLUIR:
                    excluir();
                    break;
                case OPCAO_SAIR:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
        }
    }

    public String menu() {
        return "Escolha uma opção:\n"
                + OPCAO_CADASTRAR + " - Cadastrar cliente\n"
                + OPCAO_LISTAR + " - Listar clientes\n"
                + OPCAO_BUSCAR + " - Buscar cliente\n"
                + OPCAO_ATUALIZAR + " - Atualizar cliente\n"
                + OPCAO_EXCLUIR + " - Excluir cliente\n"
                + OPCAO_SAIR + " - Sair";
    }

    public void cadastrar() {
        if (contadorClientes == clientes.length) {
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar mais clientes");
            return;
        }
        
        String nome = null;
        while (nome == null || !nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")) {
            nome = JOptionPane.showInputDialog("Nome do cliente:");
            if (nome == null) {
                return; // usuário cancelou o cadastro
            }
            if (!nome.matches("[A-Za-zÀ-ÖØ-öø-ÿ]+")) {
                JOptionPane.showMessageDialog(null, "Nome inválido. Por favor, insira somente letras.");
            }
        }
        
        String telefone = null;
        while (telefone == null || !telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
            telefone = JOptionPane.showInputDialog("Telefone do cliente (padrão: (xx) xxxx-xxxx ou (xx) xxxxx-xxxx):");
            if (telefone == null) {
                return; // usuário cancelou o cadastro
            }
            if (!telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Telefone inválido. Por favor, insira um telefone no formato (xx) xxxx-xxxx ou (xx) xxxxx-xxxx.");
            }
        }
        
        String email = null;
        while (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            email = JOptionPane.showInputDialog("E-mail do cliente:");
            if (email == null) {
                return; // usuário cancelou o cadastro
            }
            if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                JOptionPane.showMessageDialog(null, "E-mail inválido. Por favor, insira um e-mail no formato nome@dominio.com.");
            }
        }

        Cliente cliente = new Cliente(contadorClientes + 1, nome, email, telefone);
        clientes[contadorClientes] = cliente;
        contadorClientes++;

        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
    }


    public void listar() {
        String listaClientes = "";
        for (int i = 0; i < contadorClientes; i++) {
            listaClientes += "ID: " + clientes[i].getId()+ "\nNome: " + clientes[i].getNome()
                    + "\nE-mail: " + clientes[i].getEmail()
                    + "\nTelefone: " + clientes[i].getTelefone()
                    + "\n\n";
        }
        JOptionPane.showMessageDialog(null, listaClientes);
    }

    public void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId() == id) {
                String mensagem = "ID: " + clientes[i].getId()
                        + "\nNome: " + clientes[i].getNome()
                        + "\nE-mail: " + clientes[i].getEmail()
                        + "\nTelefone: " + clientes[i].getTelefone();
                JOptionPane.showMessageDialog(null, mensagem);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
    }

    public void atualizar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId() == id) {
                String nome = JOptionPane.showInputDialog("Nome do cliente:");
                String email = JOptionPane.showInputDialog("E-mail do cliente:");
                String telefone = JOptionPane.showInputDialog("Telefone do cliente:");

                clientes[i].setNome(nome);
                clientes[i].setEmail(email);
                clientes[i].setTelefone(telefone);

                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
    }

    public void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getId() == id) {
                for (int j = i; j < contadorClientes - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                contadorClientes--;

                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
    }
}

