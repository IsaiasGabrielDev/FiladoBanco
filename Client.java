public class Client {
    private String name;
    private int age;

    public Client(String name, int age){
        this.name = name;
        if(age < 16){
            this.age = 18;
        }else{
            this.age = age;
        }
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean isElderly(){
        return age >= 60;
    }
}
