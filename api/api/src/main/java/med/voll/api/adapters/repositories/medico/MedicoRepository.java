package med.voll.api.adapters.repositories.medico;

import med.voll.api.adapters.repositories.medico.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
