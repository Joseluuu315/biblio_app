package com.joseluu.biblio_app.exception;

/**
 * Excepción personalizada que se lanza cuando un socio no es encontrado
 * en el sistema.
 *
 * <p>
 * Se utiliza para indicar errores de tipo "recurso no encontrado" al intentar
 * acceder, modificar o eliminar un socio inexistente.
 * </p>
 *
 * <h3>Versionado del proyecto</h3>
 * <ul>
 *   <li><b>V6</b> – Gestión de errores y excepciones personalizadas.</li>
 * </ul>
 *
 * <p>
 * Extiende {@link RuntimeException}, por lo que se trata de una excepción
 * no verificada. Esto permite su propagación automática hasta la capa
 * de controladores.
 * </p>
 *
 * <p>
 * En controladores REST, esta excepción suele mapearse a un código HTTP
 * {@code 404 Not Found} mediante un {@code @ControllerAdvice}.
 * </p>
 */
public class SocioNoEncontradoException extends RuntimeException {

    /**
     * Constructor que crea una nueva excepción con un mensaje descriptivo.
     *
     * <p>
     * V6 - Mensajes de error personalizados para el cliente.
     * </p>
     *
     * @param mensaje mensaje que describe la causa del error
     */
    public SocioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
