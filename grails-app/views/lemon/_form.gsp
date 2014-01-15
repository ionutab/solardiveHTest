<%@ page import="solardivehtest.Lemon" %>



<div class="fieldcontain ${hasErrors(bean: lemonInstance, field: 'citrus', 'error')} ">
	<label for="citrus">
		<g:message code="lemon.citrus.label" default="Citrus" />
		
	</label>
	<g:textField name="citrus" value="${lemonInstance?.citrus}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lemonInstance, field: 'trail', 'error')} ">
	<label for="trail">
		<g:message code="lemon.trail.label" default="Trail" />
		
	</label>
	<g:textField name="trail" value="${lemonInstance?.trail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: lemonInstance, field: 'pomelo', 'error')} ">
    <label for="trail">
        <g:message code="lemon.pomelo.name.label" default="Pomelo Name" />

    </label>
    <g:textField name="pomelo.name" value="${lemonInstance?.pomelo?.name}"/>
</div>
