package br.com.osbdesenvolvimento.bikesorocaba.classes;

import java.util.List;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;

public class Interfaces {

    public interface AsyncReturnListEstacoes {
        void processFinish(List<Estacao> lista);
    }
}
