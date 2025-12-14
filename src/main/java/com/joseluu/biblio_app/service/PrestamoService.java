package com.joseluu.biblio_app.service;

import com.joseluu.biblio_app.entity.Prestamo;
import com.joseluu.biblio_app.repository.PrestamoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio encargado de la gestión de la lógica de negocio de los préstamos.
 *
 * <p>
 * Proporciona operaciones para listar, crear, actualizar, eliminar y devolver
 * préstamos, así como el cálculo de fechas por defecto.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V1</b> – Gestión básica de préstamos (alta, listado y baja).</li>
 *   <li><b>V3</b> – Inicio de reglas de negocio: cálculo de fechas límite.</li>
 *   <li><b>V6</b> – Validación básica de datos y control de errores.</li>
 * </ul>
 *
 * Se marca con {@link Service} para permitir la inyección automática
 * de dependencias en Spring.
 */
@Service
public class PrestamoService {

    /**
     * Repositorio JPA para la entidad {@link Prestamo}.
     *
     * V1 - Persistencia básica de préstamos.
     */
    private final PrestamoRepository prestamoRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param prestamoRepository repositorio de préstamos
     */
    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    /**
     * Obtiene el listado completo de préstamos del sistema.
     *
     * <p>
     * V1 - Listado básico de préstamos.
     * </p>
     *
     * @return lista de préstamos
     */
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    /**
     * Guarda o actualiza un préstamo en la base de datos.
     *
     * <p>
     * Si el préstamo no contiene fechas, se asignan valores por defecto:
     * </p>
     * <ul>
     *   <li>Fecha de préstamo: fecha actual.</li>
     *   <li>Fecha fin: 14 días desde la fecha actual.</li>
     * </ul>
     *
     * <p>
     * V1 - Alta básica de préstamos.
     * </p>
     * <p>
     * V3 - Cálculo automático de la fecha límite del préstamo.
     * </p>
     * <p>
     * V6 - Validación de datos de entrada.
     * </p>
     *
     * @param prestamo préstamo a guardar o actualizar
     * @return préstamo persistido
     * @throws IllegalArgumentException si el préstamo es nulo
     */
    public Prestamo guardarPrestamo(Prestamo prestamo) {
        // V6 - Validación básica de entrada
        if (prestamo == null) {
            throw new IllegalArgumentException("El préstamo no puede ser nulo");
        }

        // V3 - Asignación de fecha de inicio por defecto
        if (prestamo.getFechaPrestamo() == null) {
            prestamo.setFechaPrestamo(LocalDate.now());
        }

        // V3 - Cálculo de fecha límite (14 días por defecto)
        if (prestamo.getFechaFin() == null) {
            prestamo.setFechaFin(LocalDate.now().plusDays(14));
        }

        return prestamoRepository.save(prestamo);
    }

    /**
     * Obtiene un préstamo a partir de su identificador.
     *
     * <p>
     * V1 - Consulta básica de préstamos.
     * </p>
     *
     * @param id identificador del préstamo
     * @return préstamo encontrado o {@code null} si no existe
     */
    public Prestamo obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un préstamo del sistema.
     *
     * <p>
     * V1 - Baja de préstamos.
     * </p>
     *
     * @param id identificador del préstamo a eliminar
     */
    public void eliminarPrestamo(Long id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
        }
    }

    /**
     * Marca un préstamo como devuelto.
     *
     * <p>
     * Cambia el estado del préstamo a {@link Prestamo.Estado#DEVUELTO}
     * y actualiza la fecha de fin con la fecha real de devolución.
     * </p>
     *
     * <p>
     * V1 - Funcionalidad básica de devolución de préstamos.
     * </p>
     *
     * @param id identificador del préstamo a devolver
     */
    public void devolverPrestamo(Long id) {
        Prestamo p = obtenerPrestamoPorId(id);
        if (p != null) {
            p.setEstado(Prestamo.Estado.DEVUELTO);
            p.setFechaFin(LocalDate.now()); // V1 - Fecha real de devolución
            prestamoRepository.save(p);
        }
    }
}
