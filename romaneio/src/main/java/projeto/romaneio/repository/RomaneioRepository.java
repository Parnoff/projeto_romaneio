package projeto.romaneio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projeto.romaneio.model.Romaneio;

@Repository
@Transactional
public interface RomaneioRepository extends CrudRepository<Romaneio, Long> {

}
