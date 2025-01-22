package cl.mineduc.sidep.unidadeducativaapi.model;

import lombok.Data;

@Data
public class CodigoGeograficoModel {

    ComunaModel comuna;
    ProvinciaModel provincia;
    RegionModel region;

}
