
<%@ page import="digitalsoul.plantheevent.Participant" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'participant.label', default: 'Participant')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>参加者一覧</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>

                            <g:sortableColumn property="twitterId" title="Twitter Id" />

                            <g:sortableColumn property="message" title="メッセージ" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${participantInstanceList}" status="i" var="participant">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td class="twitterId" style="width:100">${participant?.twitterId}</td>

                            <td class="participantsMessage" style="width:300">${participant?.message}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <g:form method="post" >
                <div class="buttons">
                    <span class="button"><g:actionSubmit id="back" action="back" value="イベント情報に戻る" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
