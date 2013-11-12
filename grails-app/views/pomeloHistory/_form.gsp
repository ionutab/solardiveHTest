<%@ page import="solardivehtest.PomeloHistory" %>



<div class="fieldcontain ${hasErrors(bean: pomeloHistoryInstance, field: 'details', 'error')} ">
	<label for="details">
		<g:message code="pomeloHistory.details.label" default="Details" />
		
	</label>
	<g:textField name="details" value="${pomeloHistoryInstance?.details}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pomeloHistoryInstance, field: 'pomelo', 'error')} required">
	<label for="pomelo">
		<g:message code="pomeloHistory.pomelo.label" default="Pomelo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pomelo" name="pomelo.id" from="${solardivehtest.Pomelo.list()}" optionKey="id" required="" value="${pomeloHistoryInstance?.pomelo?.id}" class="many-to-one"/>
</div>

