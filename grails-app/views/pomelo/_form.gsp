<%@ page import="solardivehtest.Pomelo" %>



<div class="fieldcontain ${hasErrors(bean: pomeloInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="pomelo.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${pomeloInstance?.name}"/>
</div>

