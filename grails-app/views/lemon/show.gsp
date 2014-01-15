
<%@ page import="solardivehtest.Lemon" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lemon.label', default: 'Lemon')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lemon" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lemon" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lemon">
			
				<g:if test="${lemonInstance?.citrus}">
				<li class="fieldcontain">
					<span id="citrus-label" class="property-label"><g:message code="lemon.citrus.label" default="Citrus" /></span>
					
						<span class="property-value" aria-labelledby="citrus-label"><g:fieldValue bean="${lemonInstance}" field="citrus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lemonInstance?.trail}">
				<li class="fieldcontain">
					<span id="trail-label" class="property-label"><g:message code="lemon.trail.label" default="Trail" /></span>
					
						<span class="property-value" aria-labelledby="trail-label"><g:fieldValue bean="${lemonInstance}" field="trail"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:lemonInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lemonInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
