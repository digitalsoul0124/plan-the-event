
<%@ page import="digitalsoul.plantheevent.Participant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'participant.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="message" title="${message(code: 'participant.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="twitterId" title="${message(code: 'participant.twitterId.label', default: 'Twitter Id')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${participantInstanceList}" status="i" var="participantInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${participantInstance.id}">${fieldValue(bean: participantInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: participantInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: participantInstance, field: "twitterId")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${participantInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
