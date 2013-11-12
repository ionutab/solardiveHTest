<%@ page import="solardivehtest.Mandarine" %>



<div class="fieldcontain ${hasErrors(bean: mandarineInstance, field: 'mandarineHistory', 'error')} ">
	<label for="mandarineHistory">
		<g:message code="mandarine.mandarineHistory.label" default="Mandarine History" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mandarineInstance?.mandarineHistory?}" var="m">
    <li><g:link controller="mandarineHistory" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mandarineHistory" action="create" params="['mandarine.id': mandarineInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mandarineHistory.label', default: 'MandarineHistory')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: mandarineInstance, field: 'pipe', 'error')} ">
	<label for="pipe">
		<g:message code="mandarine.pipe.label" default="Pipe" />
		
	</label>
	<g:textField name="pipe" value="${mandarineInstance?.pipe}"/>
</div>

