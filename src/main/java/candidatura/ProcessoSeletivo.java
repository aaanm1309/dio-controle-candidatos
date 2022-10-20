package candidatura;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo");
        analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);

    }
    static void analisarCandidato(Double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o Candidato - salario pretendido: " + salarioPretendido);
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra-proposta - salario pretendido: " + salarioPretendido);
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos - salario pretendido: " + salarioPretendido);
        }
    }
}
