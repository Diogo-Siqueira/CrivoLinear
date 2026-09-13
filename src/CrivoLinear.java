public class CrivoLinear {

    private int n;
    private boolean[] composto;
    private int[] primos;

    private int qtdPrimos;
    private boolean jaExecutado;

    public CrivoLinear(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                "não é possível realizar a busca de números primos, escreva um número maior ou igual a 0");
        }
        this.n = n;
        this.composto = new boolean[n + 1];
        this.primos = new int[n + 1];
        this.qtdPrimos = 0;
        this.jaExecutado = false;
    }

    public void executar() {
        for (int i = 2; i <= n; i++) {
            if (!composto[i]) {
                primos[qtdPrimos] = i;
                qtdPrimos++;
            }

            for (int j = 0; j < qtdPrimos; j++) {
                if (primos[j] > n / i) {
                    break;
                }
                int produto = i * primos[j];
                composto[produto] = true;

                if (i % primos[j] == 0) {
                    break;
                }
            }
        }
        jaExecutado = true;
    }

    public void verificarExecutado() {
        if (!jaExecutado) {
            throw new IllegalStateException(
                "chame executar() antes de consultar os resultados");
        }
    }

    public int[] pegarPrimos() {
        verificarExecutado();

        int[] resultado = new int[qtdPrimos];
        for (int k = 0; k < qtdPrimos; k++) {
            resultado[k] = primos[k];
        }
        return resultado;
    }

}