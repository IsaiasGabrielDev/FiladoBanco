import java.sql.Time;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ManageAttendence filas = new ManageAttendence(10);
        int opc = 0;
        String nome = "";
        int idade = 0;
        do{
            System.out.println("=-==-==-==-==BANCO=DINHEIRO=NA=MÃO=-==-==-==-==");
            System.out.println("[1] - Chegada do cliente na agência");
            System.out.println("[2] - Verificar quem é o próximo a ser atendido");
            System.out.println("[3] - Atender um cliente");
            System.out.println("[4] - Exibir as filas");
            System.out.println("[5] - Finalizar o programa");
            System.out.print("---------------------------> ");
            opc = s.nextInt();
            if(opc == 1){
                System.out.print("NOME: ");
                do{
                    nome = s.next();
                    if(nome.length() < 5){
                        System.out.println("---------------------------");
                        System.out.println("ERRO!");
                        System.out.println("Nome deve ter mais de 4 caracteres!");
                        System.out.println("---------------------------");
                        System.out.print("NOME: ");
                    }
                }while(nome.length() < 5);
                System.out.print("IDADE: ");
                do{
                    idade = s.nextInt();
                    if(idade < 1){
                        System.out.println("---------------------------");
                        System.out.println("ERRO!");
                        System.out.println("Idade deve ser maior que 0!");
                        System.out.println("---------------------------");
                        System.out.print("IDADE: ");
                    }
                }while(idade < 1);
                Client c = new Client(nome, idade);
                filas.addClient(c.getName(), c.getAge());
            }else if(opc == 2){
                filas.ClientShowNext();
            }else if(opc == 3){
                filas.ClientGetNext();
            }else if(opc == 4){
                filas.showQueues();
            }else if(opc == 5){
                if(filas.numClients() > 0){
                    System.out.println("Fila cheia, não é possivel desligar o sistema!");
                }else{
                    System.out.println("Finalizando o sistema!");
                    
                }
            }else{
                System.out.print("Opção Inválida!!!");
            }
            System.out.println("---------------------------");
        }while(filas.numClients() > 0 || opc != 5);

    }
}
