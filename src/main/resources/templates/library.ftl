<#import "parts/common.ftl" as a>

<@a.page>
    <h1>Добавить библиотеку</h1>
    <form method="post"></form>
    <h1>Библиотеки</h1>
    <#list libraries as lib>
        <a href="/library/${lib.id}">${lib.name}</a>
    </#list>
</@a.page>