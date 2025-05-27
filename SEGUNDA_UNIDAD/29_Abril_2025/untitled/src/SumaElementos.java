import java.util.Scanner;
public class SumaElementos {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int tamaño,suma=0;
        System.out.println("Ingrese el tamaño del array que desea crear");
        tamaño=scanner.nextInt();
        int [] numeritos=new int [tamaño];
        for(int i=0;i<numeritos.length;i++){
            System.out.println("Ingrese el elemento "+(i+1)+":");
            numeritos[i]=scanner.nextInt();
        }
        for(int avestruz:numeritos){
            suma+=avestruz;
        }
        System.out.println("La suma de los elementos es:"+suma);
    }
}