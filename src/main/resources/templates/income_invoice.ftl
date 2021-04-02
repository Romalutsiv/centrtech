<#ftl encoding='UTF-8'>
<#import "parts/common.ftl" as c>

<@c.page>

<div class="container">
    <div class="bd-example">
      <div class="row  row-cols-1  ">
        <div class="col">
          <div class="card ">
            <div class="alert-secondary card-header">
               Прихід товару № 100 
            </div>
            <div class="card-body">        
                <form class="form-inline" action="/goods/new" method="post">
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Дата</span>
                    <input type="date" name="date" value="" id="datePicker"class="form-control" >
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Постачальник</span>
                    <input list="providers" type="text" class="form-control" placeholder="постачальник" name="provider" id="">
                    <datalist id="providers" for="providers">
                      <option value="перший"></option>
                      <option value="другий">другий</option>
                      <option value="третій"></option>
                      <option value="четвертий"></option>
                    </datalist>
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Склад</span>
                    <select name="storage" id="" class="form-control" accesskey="s">
                      <option value="first" >Склад 1</option>
                      <option value="second" selected>Склад 2</option>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <span class="input-group-text" for="">Доставка</span>
                    <input type="number" class="form-control" step=any placeholder="доставка" name="delivery" id="del" value="0.0" min="0">
                  </div>
                  <button class="btn btn-secondary" onclick="addRow('myTable');return false;">+</button>
                    <table id="myTable" class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">№</th>
                                <th scope="col">назва</th>
                                <th scope="col">кількість</th>
                                <th scope="col">ціна (грн)</th>
                                <th scope="col">сума (грн)</th>
                                <th scope="col">тип товару</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td><input class="form-control" type="text" name="name" id=""></td>
                                <td><input class="form-control" type="number" name="count" id="input1" value="1" min="0"></td>
                                <td><input class="form-control" type="number" step=any name="price" id="input2" value="0.0" min="0"></td>
                                <td><input class="form-control" disabled="disabled" type="text" id="input3" value="" min="0"></td>
                                <td><select id="sell" name="type" class="form-control">
                                  <#list gtype as g>
                                    <option value="${g.getId()}">${g.getName()}</option>
                                  </#list>
                                </select></td>
                            </tr>
                        </tbody>
                    </table>
                    <div id="sum1"><i> Загальна сума (грн):</i> <b>0</b> </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input class="btn btn-secondary" type="submit" value="підтвердити">
                </form>
          </div>
<script src="/static/myjs.js"></script>
</@c.page>