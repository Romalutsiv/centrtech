  <#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<#--  <h1>${good}</h1>  -->
<#list goods as g>
    <h2>${g.getName()} ${g.getId()}</h2>
    <p>${g.getCount()} ціна ${g.getPriceNew()} 
    
    <#if (g.getPriceDifference() >= 0)>
                                                        (+${g.getPriceDifference()})</p>
                                              <#else> (${g.getPriceDifference()})</p>  
        
    </#if></p>
</#list>

</@c.page>