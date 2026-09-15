public class CrivoLinear {

    private int n;
    private int[] menorFatorPrimo;
    private int[] primos;

    private int qtdPrimos;
    private boolean jaExecutado;

    public CrivoLinear(int n) {
        if (n < 1 ) {
            throw new IllegalArgumentException(
                "é necessário que n seja maior que 1");
        }

        this.n = n;
        this.menorFatorPrimo = new int[n + 1];
        this.primos = new int[n + 1];
        this.qtdPrimos = 0;
        this.jaExecutado = false;
    }

    public void executar() {
        if (jaExecutado) {
            throw new IllegalStateException(
                "o crivo já foi executado");
        }

        for (int i = 2; i <= n; i++) {

            if (menorFatorPrimo[i] == 0) {
                menorFatorPrimo[i] = i;

                primos[qtdPrimos] = i;
                qtdPrimos++;
            }

            for (int j = 0; j < qtdPrimos; j++) {

                if (primos[j] > menorFatorPrimo[i]) {
                    break;
                }

                if (primos[j] > n / i) {
                    break;
                }
                int produto = i * primos[j];

                menorFatorPrimo[produto] = primos[j];
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

    public int pegarMenorFatorPrimo(int numero) {
        verificarExecutado();

        if (numero < 2 || numero > n) {
            throw new IllegalArgumentException(
                "o número deve estar entre 2 e " + n);
        }

        return menorFatorPrimo[numero];
    }
}
