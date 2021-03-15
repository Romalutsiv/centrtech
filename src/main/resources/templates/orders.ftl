<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
<div class="container text-center">
    <div class="bd-example">
       <a href="/orders/neworder" class="btn btn-primary">Новий заказ +</a> 
        <a class="btn btn-secondary" href="/orders">Всі</a>
        <a class="btn btn-danger" href="/orders?type=NEW">Нові закази</a>
        <a class="btn btn-warning" href="/orders?type=FOR_PERFORMANCE">Закази що виконуються</a>
        <a class="btn btn-success" href="/orders?type=TO_PAY">До оплати</a>
        <a class="btn btn-dark" href="/orders?type=PAID">Оплачені</a>
    </div>
  </div>
  <br>
  <div class="container">
    <div class="bd-example">
        <div class="row  row-cols-1   ">
            <div class="col">
            <#--  <#assign var=value></#assign>  -->
    <#list orders as order>
        <div class="card ">
            <div class="alert-${order.getOrderType().getStyle()} card-header">
                 Заказ №${order.getId()}
            </div>
            <div class="card-body  alert-dismissible">
              <h5 class="card-title">${order.getDevice().getType()} ${order.getDevice().getName()}</h5>
              <p class="card-text">${order.getDevice().getText()}<br>
              <a href="/orders/delete/${order.id}">X</a>
              <a href="#" class="btn btn-${order.getOrderType().getStyle()}">Детальніше</a>
            </div>
            <div class="card-footer alert-${order.getOrderType().getStyle()} text-muted">
                ${order.getDateCreate()}
            </div>
        </div>
        <p></p>
    </#list>
    
</@c.page>