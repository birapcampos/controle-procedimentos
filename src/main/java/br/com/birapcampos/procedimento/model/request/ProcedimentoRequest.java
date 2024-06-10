package br.com.birapcampos.procedimento.model.request;

import br.com.birapcampos.procedimento.entity.TipoProcedimento;
import br.com.birapcampos.procedimento.validator.TrimString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProcedimentoRequest (
        @TrimString
        @Size(min=5,max=50,message = "Deve ter entre 5 e 50 caracteres")
        @NotBlank(message = "Não pode ser branco")
        String nome,
        @TrimString
        @Size(min=15,max=100,message = "Deve ter entre 15 e 100 caracteres")
        @NotBlank(message = "Não pode ser branco ou nulo")
        String descricao,
        @TrimString
        @Size(min=5,max=10,message = "Deve ter entre 5 e 10 caracteres")
        @NotBlank(message = "Não pode ser branco ou nulo")
        String codigo,
        @NotBlank(message = "Não pode ser branco ou nulo")
        TipoProcedimento tipoProcedimento,

        @Positive(message = "O valor deve ser maior do que zero.")
        Double valor
) {}
