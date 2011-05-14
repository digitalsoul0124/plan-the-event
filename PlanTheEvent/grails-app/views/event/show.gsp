
<%@ page import="digitalsoul.plantheevent.Event" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>イベント情報</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>                    
                        <tr class="prop">
                            <td valign="top" class="name" id="EVENT_LAVEL"><g:message code="event.detail.label" default="詳細" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: eventInstance, field: "detail")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${eventInstance?.id}" />
                    <span class="button"><g:actionSubmit id="apply" action="apply" value="申し込み" /></span>
                    <span class="button"><g:actionSubmit action="/userList" value="ユーザー一覧" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
