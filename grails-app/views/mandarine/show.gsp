
<%@ page import="solardivehtest.Mandarine" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mandarine.label', default: 'Mandarine')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mandarine" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mandarine" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mandarine">
			
				<g:if test="${mandarineInstance?.mandarineHistory}">
				<li class="fieldcontain">
					<span id="mandarineHistory-label" class="property-label"><g:message code="mandarine.mandarineHistory.label" default="Mandarine History" /></span>
					
						<g:each in="${mandarineInstance.mandarineHistory}" var="m">
						<span class="property-value" aria-labelledby="mandarineHistory-label"><g:link controller="mandarineHistory" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${mandarineInstance?.pipe}">
				<li class="fieldcontain">
					<span id="pipe-label" class="property-label"><g:message code="mandarine.pipe.label" default="Pipe" /></span>
					
						<span class="property-value" aria-labelledby="pipe-label"><g:fieldValue bean="${mandarineInstance}" field="pipe"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:mandarineInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${mandarineInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
