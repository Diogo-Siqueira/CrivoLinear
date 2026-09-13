import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        CrivoLinear crivo = new CrivoLinear(n);
        crivo.executar();

        int[] primos = crivo.pegarPrimos();

        for (int k = 0; k < primos.length; k++) {
            System.out.print(primos[k]);
            if (k < primos.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}