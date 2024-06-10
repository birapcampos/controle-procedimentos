package br.com.birapcampos.procedimento.mapper;

import br.com.birapcampos.procedimento.entity.Procedimento;
import br.com.birapcampos.procedimento.model.request.ProcedimentoRequest;
import br.com.birapcampos.procedimento.model.response.ProcedimentoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface ProcedimentoMapper {

    @Mapping(target = "id",ignore = true)
    Procedimento toEntity(final ProcedimentoRequest request);

    @Mapping(target = "id",ignore = true)
    Procedimento toEntity(final ProcedimentoRequest request, @MappingTarget final Procedimento entity);

    ProcedimentoResponse toResponse(final Procedimento entity);

}
