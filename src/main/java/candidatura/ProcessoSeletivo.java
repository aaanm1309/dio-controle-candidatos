package candidatura;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        double salarioBase = 2000.0;
        System.out.println("Processo seletivo");
//        analisarCandidato(1900.0);
//        analisarCandidato(2200.0);
//        analisarCandidato(2000.0);
        selecaoCandidatos(salarioBase);

    }

    static Map<String,Double> selecaoCandidatos(Double salarioBase) {
        List<String> candidatos = new ArrayList<>(List.of(
                "Felipe",
                "Marcia","Julia","Paula",
                "Augusto","Monica","Fabricio",
                "Mirela","Daniela","Jordao",
                "Augusto1","Monica1","Fabricio1",
                "Mirela1","Daniela1","Jordao1",
                "Emerson","Fabiola"));
        Map<String,Double> candidatosSelecionados = new HashMap<>();

        int quantidadeCandidatosSelecionados = 0;
        for (String candidato: candidatos) {
            double salarioPretendido = valorPretendido();
            System.out.printf("O candidado %s. Solicitou este valor de salário: R$ %.2f \n" ,candidato,salarioPretendido);
            if (analisarCandidatoApto( salarioPretendido, salarioBase)) {
                System.out.printf("O candidado %s. Ele foi selecionado para a vaga com o valor de: R$ %.2f \n" ,candidato,salarioPretendido );
                candidatosSelecionados.put(candidato,salarioPretendido);
                quantidadeCandidatosSelecionados++;
                entrandoEmContato( candidato);
            }
            if(quantidadeCandidatosSelecionados>=5){
                break;
            }
        }

//        System.out.println(candidatosSelecionados);
        return candidatosSelecionados;

    }
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atenderChamada();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.printf("Contato com candidato %s foi realizado com sucesso. Candidato contratado na tentativa %s \n",candidato, tentativasRealizadas );
            }

        } while (continuarTentando && tentativasRealizadas<3);
        if (tentativasRealizadas >=3){
            System.out.printf("Contato com candidato %s sem sucesso. Candidato PERDEU a vaga \n",candidato );

        }

    }

    static boolean atenderChamada() {
        return  new Random().nextInt(3) == 1;
    }


    private static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static Boolean analisarCandidatoApto(Double salarioPretendido,Double salarioBase){

        if (salarioBase > salarioPretendido) {
//            System.out.println("Ligar para o Candidato - salario pretendido: " + salarioPretendido);
            return true;
        } else if (salarioBase == salarioPretendido) {
//            System.out.println("Ligar para o candidato com contra-proposta - salario pretendido: " + salarioPretendido);
        } else {
//            System.out.println("Aguardando o resultado dos demais candidatos - salario pretendido: " + salarioPretendido);
        }
        return false;
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
