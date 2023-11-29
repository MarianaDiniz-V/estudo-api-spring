package med.voll.api.adapters.repositories.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    Page <MedicoEntity> findAllByAtivoTrue(Pageable paginacao);
}
