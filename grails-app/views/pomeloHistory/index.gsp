
<%@ page import="solardivehtest.PomeloHistory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pomeloHistory.label', default: 'PomeloHistory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pomeloHistory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pomeloHistory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="details" title="${message(code: 'pomeloHistory.details.label', default: 'Details')}" />
					
						<th><g:message code="pomeloHistory.pomelo.label" default="Pomelo" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pomeloHistoryInstanceList}" status="i" var="pomeloHistoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pomeloHistoryInstance.id}">${fieldValue(bean: pomeloHistoryInstance, field: "details")}</g:link></td>
					
						<td>${fieldValue(bean: pomeloHistoryInstance, field: "pomelo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pomeloHistoryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
