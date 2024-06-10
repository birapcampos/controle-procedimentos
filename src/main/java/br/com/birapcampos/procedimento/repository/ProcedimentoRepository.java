package br.com.birapcampos.procedimento.repository;

import br.com.birapcampos.procedimento.entity.Procedimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProcedimentoRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public ProcedimentoRepository(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Mono<Procedimento> save(final Procedimento procedimento){
        return mongoTemplate.save(procedimento);
    }

    public Mono<Procedimento> findById(String id) {
        return mongoTemplate.findById(id, Procedimento.class);
    }

    public Flux<Procedimento> findAll(){
        return mongoTemplate.findAll(Procedimento.class);
    }

    public Mono<Procedimento> findAndRemove(String id) {
        Query query = new Query();
        Criteria where = Criteria.where("id").is(id);
        return mongoTemplate.findAndRemove(query.addCriteria(where), Procedimento.class);
    }

}
