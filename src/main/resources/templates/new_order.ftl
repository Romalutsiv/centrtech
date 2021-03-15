<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>
      <div class="container">
    <div class="bd-example">
      <div class="row  row-cols-1  ">
        <div class="col">
          <div class="card ">
            <div class="alert-secondary card-header">
               Новий заказ
            </div>
            <div class="card-body bg-light alert-dismissible">
              <form class="form-inline"  method="post" action="/orders/orders"> 
                <input type="text" class="form-control" name="name" id="" placeholder="імя *">
                <input type="text" class="form-control" name="lastname" id="" placeholder="прізвище *">
                <input type="email" class="form-control" name="mail" id="" placeholder="email">
                <input type="tel" class="form-control" name="phonenumber" id="" placeholder="телефон *">
                <input type="text" class="form-control" name="addres" id="" placeholder="адреса">
                <input type="text" class="form-control" name="type" id="" placeholder="тип виробу"> 
                <input type="text" class="form-control" name="deviceName" id="" placeholder="марка">
                <input type="text" class="form-control" name="deviceModel" id="" placeholder="модель">
                <input type="text" class="form-control" name="serialNumber" id="" placeholder="серійний номер">
                <input type="text" class="form-control" name="devicePass" id="" placeholder="пароль ОС/біос">
                <p></p>
                <#list defects as defect> 
                  <input name="${defect}" type="checkbox" class="btn-check" id="${defect}"  autocomplete="off">
                  <label class="btn btn-outline-secondary" name="${defect}" for="${defect}">${defect.getUkrName()}</label>                  
                </#list>
                <p></p>
                <textarea name="text" class="form-control" id="" cols="100" rows="5" placeholder="замовлена несправність"></textarea><p></p>  
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="submit" value="створити" class="btn btn-secondary">
              </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</@c.page>