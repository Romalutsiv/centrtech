<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<#include "parts/order_nav.ftl"/> 

<div class="container">
    <div class="bd-example">
        <div class="row justify-content-center">
            <div class="col-10">
                <#list orders as order>
                    <div class="card ">
                        <div class="alert-${order.getOrderType().getStyle()} card-header">
                            <a class="alert-link" href="/orders/one/${order.id}">Заказ №${order.id}</a>
                        </div>
                        <div class="card-body  alert-dismissible">
                            <h5 class="card-title">${order.getDevice().getType()} ${order.getDevice().getName()}</h5>
                            <p class="card-text">${order.getDevice().getText()}<br>
                            <a href="/orders/delete/${order.id}">X</a>
                            <a href="/orders/one/${order.id}" class="btn btn-${order.getOrderType().getStyle()}">Детальніше</a>
                        </div>
                        <div class="card-footer alert-${order.getOrderType().getStyle()} text-muted">
                            ${order.getDateCreate()}
                        </div>
                    </div>
                    <br>
                </#list>
            </div>
        </div>
    </div>
</div>
    
</@c.page>