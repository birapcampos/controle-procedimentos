package br.com.birapcampos.procedimento.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Procedimento {

    @Id
    private String id;
    private String nome;

    private String descricao;
    @Indexed(unique = true)
    private String codigo;

    private TipoProcedimento tipoProcedimento;
    private Double valor;


}
