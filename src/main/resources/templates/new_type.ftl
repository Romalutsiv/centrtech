  <#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<form method="post" action="/goods/new_type/r">
    <input name="name" type="text">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit">
</form>

</@c.page>