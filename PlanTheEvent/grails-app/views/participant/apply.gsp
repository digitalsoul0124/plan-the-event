

<%@ page import="digitalsoul.plantheevent.Participant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>申し込み</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${participantInstance}">
            <div class="errors">
                <g:renderErrors bean="${participantInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <div class="dialog">
                    <table>
                        <tbody>                        

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="twitterId"><g:message code="participant.twitterId.label" default="Twitter Id" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: participantInstance, field: 'twitterId', 'errors')}">
                                    <g:textField name="twitterId" value="${params.twitterId}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="message"><g:message code="participant.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: participantInstance, field: 'message', 'errors')}">
                                    <g:textField name="message" value="${params.message}" />
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit id="register" action="register" value="登録" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
