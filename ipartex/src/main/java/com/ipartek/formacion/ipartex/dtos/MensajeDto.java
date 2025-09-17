package com.ipartek.formacion.ipartex.dtos;

import java.time.LocalDateTime;

public record MensajeDto(Long id, String nombreUsuario, LocalDateTime fechaHora, String texto, Long numeroRespuestas, Long numeroLikes, Long idMensajePadre) {

}
