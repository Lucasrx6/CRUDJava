# CRUD simples em JAVA

### Este programa tem a finalidade academica, para estudos da linguagem de programação Java

------------------------------------------------------------------------

# Prints da tela 

### Ao executar:
-- A tela de Menu é aberta, solicitando ao usuário qual opção quer selecionar.

![1](https://user-images.githubusercontent.com/86980974/218827086-7e8217c2-7651-4023-8466-360f7134a4e0.PNG)

-- Opção 1 realiza o cadastro do cliente <br>
-- Opção 2 lista os cliente cadastrados <br>
-- Opção 3 busca o cliente cadastrado pelo Id <br>
-- Opção 4 atualiza o cliente, atraves de uma busca pelo Id <br>
-- Opção 5 deleta o cliente selecionado <br>
-- Opção 0 Sai do programa


------------------------------------------------------------------

## Abaixo um breve exemplo da execução do programa


-- Ao selecionar a opção 1, a tela de cadastro é aberta o qual vai solicitar Nome, Telefone e Email.

![3](https://user-images.githubusercontent.com/86980974/218827108-be6daba2-2972-47a6-9cba-921c20ac8ccc.PNG)

-- O nome sómente aceita letras, qualquer numero digitado não é aceito pelo sistema.

![2](https://user-images.githubusercontent.com/86980974/218827099-9e9d605a-7db4-4573-9c1e-0a814764a1e8.PNG)

-- Quando digitado de forma correta, o cadastro do nome é realizado.

![4](https://user-images.githubusercontent.com/86980974/218827119-71d91bd1-035d-4920-9a1b-4316cf386d21.PNG)

-- O mesmo exemplo serve para o telefone e email.


![5](https://user-images.githubusercontent.com/86980974/218827127-460ca8c5-c3f3-4524-ab87-eb612532be09.PNG)


![6](https://user-images.githubusercontent.com/86980974/218827138-9426f90c-45a1-49a3-a861-eda3c12e0a09.PNG)


![7](https://user-images.githubusercontent.com/86980974/218827148-b9ffe42d-a1f0-4a84-9abf-c5cc7fea01ba.PNG)


![8](https://user-images.githubusercontent.com/86980974/218827171-2b010e91-ebdb-4749-b224-cfa6876d3650.PNG)






----------------------------------------------------------------------

### Código da classe Principal


package CRUD;

// Classe Main
public class Principal {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        dao.executar();
    }
}


### Código da classe Cliente 

package CRUD;

public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

### Código da classe ClienteDAO

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
