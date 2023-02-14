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

Código Principal


package br.com.senaitagua.sa1.app9;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		int mes=12;
		int opcao=5;
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao 5"));
		
	    switch(opcao) {
	       case 1:
	    	   
			    if(mes==1)
				    System.out.println("Janeiro");
			        break;
	       case 2:
	    	   
	    	   if(mes==1)
				    System.out.println("Janeiro");
			    else
			     	System.out.print("Outro mês");
			    break;
	       case 3:
	    	   
	    	   if(mes==1) {
				    System.out.println("Janeiro");
	    	   }else if(mes==2) {
			     	System.out.print("Fevereiro");
	    	   }else {
			    	System.out.println("Outro mês");
	    	   }
			    break;
	       case 4:
	    	   if(mes==12) {
	    		   for(int i=1;i<=12;i++) {
	    			   System.out.println("Feliz Natal-mes:"+i);
	    		   }
	    	   }else {
	    		   System.out.println("Não é natal!");
	    	   }
	    	   break;
	       case 5:
	    	   if(mes==12) {
	    		   System.out.println("Seja bem vindo ao Banco SS");
	    		   
	    		   int senha;
	    		   int cont=1;
	    		    
	    		   while (cont <= 3) {
	    		   senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha"));
		    		   if(senha == 123) {
		    			   System.out.println("pode sacar");
		    			   break;
		    		   }else{
		    			   System.out.println("senha inválida");
		    			   cont++;
		    		   }
		    			   
		    		if (cont == 4) {
		    			JOptionPane.showMessageDialog(null, "Conta Bloqueada");
		    			break;
		    			}
		    		}
	    	   }
	    	  
			default:
				System.out.println("Não tem essa opção não");
				break;
	    	     
	    }
		
	}
}
