package alura.com.br.aluratrips.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import alura.com.br.aluratrips.model.Package;

public class PackageDAO {

    public List<Package> list() {
        return new ArrayList<>(Arrays.asList(
                new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99")),
                new Package("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal("421.50")),
                new Package("Recife", "recife_pe", 4, new BigDecimal("754.20")),
                new Package("Rio de Janeiro", "rio_de_janeiro_rj", 6, new BigDecimal("532.55")),
                new Package("Salvador", "salvador_ba", 5, new BigDecimal("899.99")),
                new Package("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal("289.90")))
        );
    }

}
