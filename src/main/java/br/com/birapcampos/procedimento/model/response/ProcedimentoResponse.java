package br.com.birapcampos.procedimento.model.response;

import br.com.birapcampos.procedimento.entity.TipoProcedimento;

public record ProcedimentoResponse (
        String nome,
        String descricao,
        String codigo,
        TipoProcedimento tipoProcedimento
) {}
