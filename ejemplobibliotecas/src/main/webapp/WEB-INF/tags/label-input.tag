<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ attribute name="tipo"%>
<%@ attribute name="id"%>
<%@ attribute name="etiqueta"%>
<%@ attribute name="valor"%>
<%@ attribute name="error"%>
<div class="row mb-3">
	<c:if test="${tipo != 'button'}">
		<label for="${id}" class="col-sm-2 col-form-label">${etiqueta}</label>
	</c:if>
	<div class="${tipo == 'button' ? 'offset-sm-2' : ''} col-sm">
		<c:choose>
			<c:when test="${tipo == 'button'}">
				<button class="btn btn-primary">${etiqueta}</button>
			</c:when>
			<c:otherwise>
				<input type="${tipo}"
					class="form-control ${ error == null || error.isBlank() ? '': 'is-invalid' }"
					id="${id}" name="${id}" value="${fn:escapeXml(valor)}">
				<div class="invalid-feedback">${error}</div>
			</c:otherwise>
		</c:choose>
	</div>
</div>