<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<#include "parts/order_nav.ftl"/> 

<div class="container">
    <div class="bd-example">
        <div class="row justify-content-center">
            <div class="col-10">
                <div class="card ">
                    <div class="alert-${order.getOrderType().getStyle()} card-header">
                        <a class="alert-link" href="/orders/one/${order.id}">Заказ №${order.id}</a>
                    </div>
                    <div class="card-body  alert-dismissible">
                        <h5 class="card-title">${order.getDevice().getType()} ${order.getDevice().getName()}</h5>
                        <p class="card-text">${order.getDevice().getText()}</p>                
                        <a href="/orders/delete/${order.id}" class="btn btn-secondary">X</a>
                        <a href="/orders" class="btn btn-secondary">Назад</a>
                        <#if order.getOrderType().getStyle() == "danger">
                            <a href="/orders/accept/${order.id}" class="btn btn-${order.getOrderType().getStyle()}">Прийняти заказ</a>
                            <a href="/orders/receiving/${order.id}" class="text-end btn btn-success">PDF</a>
                        <#elseif order.getOrderType().getStyle() == "warning">
                            <a href="/orders/orderchek/${order.id}" class="btn btn-${order.getOrderType().getStyle()}">До оплати</a>
                            <a href="/orders/receiving/${order.id}" class="text-end btn btn-success">Excel</a>
                        <#elseif order.getOrderType().getStyle() == "success">
                            <a href="/orders/receiving/${order.id}" class="text-end btn btn-success">Excel@</a>

                        </#if>
                    </div>
                    <div class="card-footer alert-${order.getOrderType().getStyle()} text-muted">
                        ${order.getDateCreate()}
                        <#if order.getUser()?has_content>
                            майстер ${order.getUser().getUsername()}
                        </#if>
                    </div>
                </div>
                <br>
            </div>
        </div>
    </div>
</div>

</@c.page>