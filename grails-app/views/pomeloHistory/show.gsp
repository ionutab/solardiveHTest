
<%@ page import="solardivehtest.PomeloHistory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pomeloHistory.label', default: 'PomeloHistory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pomeloHistory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pomeloHistory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pomeloHistory">
			
				<g:if test="${pomeloHistoryInstance?.details}">
				<li class="fieldcontain">
					<span id="details-label" class="property-label"><g:message code="pomeloHistory.details.label" default="Details" /></span>
					
						<span class="property-value" aria-labelledby="details-label"><g:fieldValue bean="${pomeloHistoryInstance}" field="details"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${pomeloHistoryInstance?.pomelo}">
				<li class="fieldcontain">
					<span id="pomelo-label" class="property-label"><g:message code="pomeloHistory.pomelo.label" default="Pomelo" /></span>
					
						<span class="property-value" aria-labelledby="pomelo-label"><g:link controller="pomelo" action="show" id="${pomeloHistoryInstance?.pomelo?.id}">${pomeloHistoryInstance?.pomelo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:pomeloHistoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${pomeloHistoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
