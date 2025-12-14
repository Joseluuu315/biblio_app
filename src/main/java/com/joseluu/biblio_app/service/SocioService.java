package com.joseluu.biblio_app.service;

import com.joseluu.biblio_app.entity.Socio;
import com.joseluu.biblio_app.exception.SocioNoEncontradoException;
import com.joseluu.biblio_app.repository.SocioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la gestión de socios del sistema.
 *
 * <p>
 * Centraliza la lógica de negocio relacionada con la entidad {@link Socio},
 * actuando como intermediario entre los controladores y el repositorio.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Acceso básico a datos mediante repositorios JPA.</li>
 *   <li><b>V4</b> – Implementación del CRUD completo de socios.</li>
 *   <li><b>V6</b> – Gestión de errores mediante excepciones personalizadas.</li>
 * </ul>
 *
 * <p>
 * Lanza {@link SocioNoEncontradoException} cuando se intenta acceder o eliminar
 * un socio inexistente.
 * </p>
 *
 * Se marca con {@link Service} para permitir la inyección automática por parte
 * de Spring.
 */
@Service
public class SocioService {

    /**
     * Repositorio JPA para la entidad {@link Socio}.
     *
     * V1 - Persistencia básica con Spring Data JPA.
     */
    private final SocioRepository socioRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param socioRepository repositorio de socios
     */
    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    /**
     * Obtiene el listado completo de socios registrados en el sistema.
     *
     * <p>
     * V4 - Listado de socios dentro del CRUD completo.
     * </p>
     *
     * @return lista de socios
     */
    public List<Socio> listarSocios() {
        return socioRepository.findAll();
    }

    /**
     * Obtiene un socio a partir de su identificador.
     *
     * <p>
     * V4 - Consulta individual de socios.
     * </p>
     * <p>
     * V6 - Lanza una excepción controlada si el socio no existe.
     * </p>
     *
     * @param id identificador del socio
     * @return socio encontrado
     * @throws SocioNoEncontradoException si no existe un socio con ese id
     */
    public Socio obtenerSocioPorId(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() ->
                        new SocioNoEncontradoException("Socio con id " + id + " no encontrado"));
    }

    /**
     * Guarda un socio en la base de datos.
     *
     * <p>
     * Permite tanto la creación de un nuevo socio como la modificación
     * de uno existente.
     * </p>
     *
     * <p>
     * V4 - Alta y modificación de socios.
     * </p>
     *
     * @param socio socio a guardar
     * @return socio persistido
     */
    public Socio guardarSocio(Socio socio) {
        return socioRepository.save(socio);
    }

    /**
     * Elimina un socio del sistema a partir de su identificador.
     *
     * <p>
     * V4 - Baja de socios.
     * </p>
     * <p>
     * V6 - Control de errores si el socio no existe.
     * </p>
     *
     * @param id identificador del socio a eliminar
     * @throws SocioNoEncontradoException si no existe el socio
     */
    public void eliminarSocio(Long id) {
        // V6 - Validación de existencia antes de eliminar
        if (!socioRepository.existsById(id)) {
            throw new SocioNoEncontradoException("No existe socio con id " + id);
        }
        socioRepository.deleteById(id);
    }
}
