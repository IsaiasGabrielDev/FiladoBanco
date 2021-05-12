public class ManageAttendence {
    
    private String nomesNormal[];
    private int idadesNormal[];
    private String nomesIdoso[];
    private int idadesIdoso[];
    private int finalFilaNormal = 0;
    private int finalFilaIdoso = 0;
    private int idosos = 0;
    private int total = 0;
    private int contidoso =0;
    private int contnormal =0;

    public ManageAttendence(int n){
        nomesNormal = new String[n];
        idadesNormal = new int[n];
        nomesIdoso = new String[n];
        idadesIdoso = new int[n];
        total = n;
    }

    public boolean isEmpty(){
        return(finalFilaNormal + finalFilaIdoso == 0);
    }

    public int numClients(){
        return finalFilaNormal + finalFilaIdoso;
    }

    public int numElderlyClients(){
        return finalFilaIdoso;
    }

    public void addClient(String nome, int idade){
        if(idade < 60){
            if(finalFilaNormal == total){
                System.out.println("ERRO! \n Fila Cheia.");
            }
            else{
                nomesNormal[finalFilaNormal] = nome;
                idadesNormal[finalFilaNormal] = idade;
                finalFilaNormal++;
            }
        }else{
            if(finalFilaIdoso == nomesIdoso.length){
                System.out.println("ERRO! \n Fila Cheia.");
            }
            else{
                nomesIdoso[finalFilaIdoso] = nome;
                idadesIdoso[finalFilaIdoso] = idade;
                finalFilaIdoso++;
            }
        }
    }

public void ClientShowNext(){
    if(isEmpty()){
        System.out.println("Fila Vazia");
    }else{
        if(finalFilaIdoso > 0 && contidoso < 2){
            System.out.println("Próximo cliente: " + nomesIdoso[0] + "-" + idadesIdoso[0]);
        }else{
            System.out.println("Próximo cliente: " + nomesNormal[0] + "-" + idadesNormal[0]);
        }
    }
}

/*   public void ClientShowNext(){
        if(finalFilaNormal == 0){
            System.out.println("Fila Vazia");
        }else{
            System.out.println(nomesNormal[0]); 
        }
    }*/

public void ClientGetNext(){
    
    
    if(isEmpty()){
        System.out.println("Fila Vazia!");
    }else{
        if(finalFilaIdoso > 0 && contidoso < 2){
            String nomeaux = nomesIdoso[0];
            int idadeaux = idadesIdoso[0];
            for (int i = 0; i < finalFilaIdoso; i++) {
                nomesIdoso[i] = nomesIdoso[i+1];
                idadesIdoso[i] = idadesIdoso[i+1];
            }
            finalFilaIdoso--;
            System.out.println("Cliente " + nomeaux +  " foi atendido.");
            contidoso++;
            
        }else if(finalFilaNormal > 0){
            String nomeaux = nomesNormal[0];
            int idadeaux = idadesNormal[0];
            for (int i = 0; i < finalFilaNormal; i++) {
                nomesNormal[i] = nomesNormal[i+1];
                idadesNormal[i] = idadesNormal[i+1];
            }
            finalFilaNormal--;
            contidoso=0;
            System.out.println("Cliente " + nomeaux + " foi atendido");
        }
    }
} 

/*    public void ClientGetNext(){
        if(isEmpty()){
            System.out.println("Fila Vazia");
        }else{
            String nomeaux = nomesNormal[0];
            int idadeaux = idadesNormal[0];
            for (int i = 0; i < finalFilaNormal-1; i++) {
                nomesNormal[i] = nomesNormal[i+1];
                idadesNormal[i] = idadesNormal[i+1];
            }
            finalFilaNormal--;
            System.out.println(nomeaux + " - " + idadeaux + " Anos.");
        }
    }*/

    public void showQueues(){
        System.out.print("IDOSO: ");
        if(finalFilaIdoso == 0){
            System.out.print("Vazia;");
        }else{
            for (int i = 0; i < finalFilaIdoso; i++) {
                System.out.print(nomesIdoso[i] + ":" + idadesIdoso[i] + "-");
            }
        System.out.print(";");
        }
        System.out.print("NORMAL: ");
        if(finalFilaNormal == 0){
            System.out.print("Vazia");
        }else{
            for (int i = 0; i < finalFilaNormal; i++) {
                System.out.print(nomesNormal[i] + ":" + idadesNormal[i] + "-");
            }
        }
        System.out.println();
    }


    
}
