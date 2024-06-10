package br.com.birapcampos.procedimento.service;

import br.com.birapcampos.procedimento.entity.Procedimento;
import br.com.birapcampos.procedimento.exceptions.ObjectNotFoundException;
import br.com.birapcampos.procedimento.mapper.ProcedimentoMapper;
import br.com.birapcampos.procedimento.model.request.ProcedimentoRequest;
import br.com.birapcampos.procedimento.repository.ProcedimentoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
public class ProcedimentoService {

    private ProcedimentoRepository procedimentoRepository;
    private ProcedimentoMapper procedimentoMapper;

    public ProcedimentoService(ProcedimentoRepository procedimentoRepository,
                               ProcedimentoMapper procedimentoMapper) {
        this.procedimentoRepository = procedimentoRepository;
        this.procedimentoMapper = procedimentoMapper;
    }

    public Mono<Procedimento> save(final ProcedimentoRequest request){
        return procedimentoRepository.save(procedimentoMapper.toEntity(request));
    }

    public Mono<Procedimento> findById(final String id){
        return handleNotFound(procedimentoRepository.findById(id),id);    }

    public Flux<Procedimento> findAll(){
        return procedimentoRepository.findAll();
    }

    public Mono<Procedimento> update(final String id,ProcedimentoRequest request){
        return findById(id)
                .map(entity -> procedimentoMapper.toEntity(request,entity))
                .flatMap(procedimentoRepository::save);
    }

    public Mono<Procedimento> delete(final String id){

        return handleNotFound(procedimentoRepository.findAndRemove(id),id);
    }

    private <T> Mono<T> handleNotFound(Mono<T> mono,String id){
        return mono.switchIfEmpty(
                Mono.error(new ObjectNotFoundException(
                                format("Object not found. id: %s, Type: %s",id,Procedimento.class.getSimpleName())
                        )
                ));
    }

}
