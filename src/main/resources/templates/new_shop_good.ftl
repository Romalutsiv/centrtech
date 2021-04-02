<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post" action="/goods/shop/new/q">
        <input type="number" step="any" min="0" value="0.0" name="price" type="text" placeholder="price">
        <select name="good" id="" class="form-control" accesskey="s">
            <#list goods as good>
                <option value="${good.id}" >${good.getName()}</option>
            </#list>
        </select>
        <select name="good" id="" class="form-control" accesskey="s">
            <#list goods as good>
                <option value="${good.id}" >${good.getName()}</option>
            </#list>
        </select>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit">
    </form>


</@c.page>