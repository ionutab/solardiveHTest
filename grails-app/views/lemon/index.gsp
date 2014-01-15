
<%@ page import="solardivehtest.Lemon" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lemon.label', default: 'Lemon')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-lemon" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-lemon" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="citrus" title="${message(code: 'lemon.citrus.label', default: 'Citrus')}" />
					
						<g:sortableColumn property="trail" title="${message(code: 'lemon.trail.label', default: 'Trail')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lemonInstanceList}" status="i" var="lemonInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lemonInstance.id}">${fieldValue(bean: lemonInstance, field: "citrus")}</g:link></td>
					
						<td>${fieldValue(bean: lemonInstance, field: "trail")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${lemonInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
